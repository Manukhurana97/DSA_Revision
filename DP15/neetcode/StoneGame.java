// https://leetcode.com/problems/stone-game/

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        // return recursion(0, n-1, piles, true, dp) > 0;

        return tabulation(piles) > 0;
    }

    private int recursion(int start, int end, int[] piles, boolean isAlice, int[][] dp){
        if(start>end) return 0;

        if(dp[start][end] != 0) return dp[start][end];
        
        if(isAlice){
            int takeStart = piles[start] + recursion(start+1, end, piles, false, dp);
            int takeEnd = piles[end] + recursion(start, end-1, piles, false, dp);
            return Math.max(takeStart, takeEnd);
        }else{
            // to reduce the score of alias
            int takeStart = -piles[start] + recursion(start+1, end, piles, true, dp);
            int takeEnd = -piles[end] + recursion(start, end-1, piles, true, dp);

            return dp[start][end] = Math.min(takeStart, takeEnd);
        }    
    }



    private int tabulation( int[] piles){
        int n = piles.length;
        int[][] dp = new int[n][n];
        
        // Base case: If the range has only one pile, the score difference is just the pile's value
        for(int i=0; i<n; i++){
            dp[i][i] = piles[i];
        }
        
        for (int len = 2; len <= n; len++) {
            for(int start=0; start<=n-len; start++){
                int end = start + len - 1;

                    dp[start][end] = Math.max(piles[start] - dp[start+1][end], piles[end] - dp[start][end-1]);
            }
        }
       
       return dp[0][n-1];
    }
}
