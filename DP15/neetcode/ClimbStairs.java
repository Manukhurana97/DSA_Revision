public class ClimbStairs {
    public int climbStairs(int n) {
        
        // return recursion(n-1);

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // return memoization(n-1, dp);

        // return tabulation(n, dp);

        return spaceOptimize(n);
    }

    
    private int recursion(int n){
        if(n < 0) return 1;
        if(n == 0) return 1;

        return recursion(n-1) + recursion(n-2);
    }


    private int memoization(int n, int[] dp){
        if(n < 0) return 1;
        if(n == 0) return 1;

        if(dp[n] != -1) return dp[n];

        return dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
    }


    private int tabulation(int n, int[] dp){
        dp[0] = 1;

        for(int i = 1; i<=n; i++){
            dp[i] = dp[i - 1] + (i-2<0 ? 0 : dp[i-2]);
        }

        return dp[n];
    }


    private int spaceOptimize(int n){
        int prev1 = 1, prev2 = 0;

        for(int i = 1; i<=n; i++){
            int curr = prev1 + (i-2<0 ? 0 : prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}