// https://leetcode.com/problems/integer-break/description/

public class IntegerBreak {
    public int integerBreak(int n) {
        int[][] dp = new int[n+1][n+1];
        
        // return recursion(n-1, n, dp);

        // return tabulation(n, dp);

        // return spaceOptimization(n);

        return spaceOptimization1(n);

    }

    private int recursion(int i, int n, int[][] dp){
        if(n==0) return 1;
        if(i<=0) return 0;

        if(dp[i][n] != 0) return dp[i][n];
        
        int take = (n-i>=0) ? i * recursion(i, n-i, dp) : 0;
        int notTake = recursion(i-1, n, dp);

        return dp[i][n] = Math.max(take, notTake);
    }


    private int tabulation(int n, int[][] dp){
        for(int i=0; i<n; i++) dp[i][0] = 1;

        for(int i=1; i<n; i++){
            for(int j=1; j<=n; j++){
                int take = (j-i>=0) ? i * dp[i][j-i] : 0;
                int notTake = dp[i-1][j];

                dp[i][j] = Math.max(take, notTake);
            }
        }        
        

        return dp[n-1][n];
    }


    private int spaceOptimization(int n) {
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        curr[0] = 1;
        prev[0] = 1;

        for(int i=1; i<n; i++){
            for(int j=1; j<=n; j++){
                int take = (j-i>=0) ? i * curr[j-i] : 0;
                int notTake = prev[j];

                curr[j] = Math.max(take, notTake);
            }

            prev = curr.clone();
        }        
        
        return prev[n];
    }


    private int spaceOptimization1(int n) {
        int[] prev = new int[n+1];
        prev[0] = 1;

        for(int i=1; i<n; i++){
            for(int j=1; j<=n; j++){
                int take = (j-i>=0) ? i * prev[j-i] : 0;
                int notTake = prev[j];

                prev[j] = Math.max(take, notTake);
            }
        }        
        
        return prev[n];
    }
    

}