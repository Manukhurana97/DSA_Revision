// https://leetcode.com/problems/unique-paths/description/

public class UniquePath{
    public int uniquePaths(int m, int n) {
        
        return spaceOptimization(m, n);
    }

    private int recursion(int r, int c, int[][] dp){
        if(r == 0 && c == 0) return 1;
        if(r<0 || c<0) return 0;

        if(dp[r][c] != 0) return dp[r][c];

        int up = recursion(r-1, c, dp);
        int left = recursion(r, c-1, dp);

        return dp[r][c] = up + left;

    }


    private int tabulation(int m, int n, int[][] dp){
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(r ==0 && c == 0){
                    dp[0][0] = 1;
                    continue;
                }
                int up = r - 1 >= 0 ? dp[r-1][c] : 0;
                int left = c - 1 >= 0 ? dp[r][c-1] : 0;

                dp[r][c] = up + left;
            }
        }

        return dp[m-1][n-1];
    }



    private int spaceOptimization(int m, int n){
        int[] prev = new int[n];

        for(int r=0; r<m; r++){
            int[] curr = new int[n];
            for(int c=0; c<n; c++){
                if(r ==0 && c == 0){
                    curr[0] = 1;
                    continue;
                }
                int up = r - 1 >= 0 ? prev[c] : 0;
                int left = c - 1 >= 0 ? curr[c-1] : 0;

                curr[c] = up + left;
            }
            prev = curr;
        }

        return prev[n-1];
    }
}