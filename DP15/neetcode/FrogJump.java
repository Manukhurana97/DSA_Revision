// https://leetcode.com/problems/frog-jump/description/

public class FrogJump {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Integer> stoneSet = new HashMap<>();
        
        for(int i=0; i<n; i++){
            stoneSet.put(stones[i], i);
        }

        // Boolean[][] dp = new Boolean[n+1][n+1];
        
        // return recursion(0, 0, stones, stoneSet, dp);   

        return tabulation(stones, stoneSet);
    }

    private boolean recursion(int n, int prev, int[] stones, Map<Integer, Integer> stoneSet, Boolean[][] dp){
        if(n == stones.length - 1) return true;

        if(dp[n][prev] != null) return dp[n][prev];

        for(int k=-1; k<=1; k++){
            int nextJump = prev+k;
            if(nextJump <= 0 || !stoneSet.containsKey(stones[n] + nextJump)) continue;
            if(recursion(stoneSet.get(stones[n] + nextJump), nextJump, stones,stoneSet, dp)) return dp[n][prev] = true;
        }

        return dp[n][prev] = false;
    }

    private boolean tabulation(int[] stones, Map<Integer, Integer> stoneSet){
        int n = stones.length;
        boolean[][] dp = new boolean[n+1][n+1];

        for(int i=0; i<n; i++){
            dp[n-1][i] = true;
        }

        for(int i=n-2; i>=0; i--){
            for(int prev = n-1; prev>=0; prev--){
                dp[i][prev] = false;
                for(int k=-1; k<=1; k++){
                    int nextJump = prev+k;
                    if(nextJump <= 0 || !stoneSet.containsKey(stones[i] + nextJump)) continue;
                    if(dp[stoneSet.get(stones[i] + nextJump)][nextJump]) {
                        dp[i][prev] = true;
                    }
                }
            }
        }

        return dp[0][0];
    }
}