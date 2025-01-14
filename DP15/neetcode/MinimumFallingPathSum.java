// https://leetcode.com/problems/minimum-falling-path-sum/

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int minResult = Integer.MAX_VALUE;
        // int[][] dp = new int[rows][cols];

        // for(int c=0; c<cols; c++){
        //     minResult = Math.min(minResult, recursion(rows-1, c, matrix, dp));
        // }
        // return minResult;

        // return tabulation(matrix, dp);

        return spaceOptimization(matrix);
    }

    private int recursion(int r, int c, int[][] grid, int[][] dp){
        if(r<0 || c<0 || r>=grid.length || c>=grid[r].length) return Integer.MAX_VALUE;
        if(r==0) return grid[r][c];

        if(dp[r][c] != 0) return dp[r][c];

        int up = recursion(r-1, c, grid, dp);
        int left = recursion(r-1, c-1, grid, dp);
        int right = recursion(r-1, c+1, grid, dp);

        return dp[r][c] = grid[r][c] + Math.min(up, Math.min(left, right));
    }

    private int tabulation(int[][] grid, int[][] dp){
        int rows = grid.length, cols = grid[0].length;

        dp[0] = grid[0];

        for(int r=1; r<rows; r++){
            for(int c=0; c<cols; c++){
                int up = dp[r-1][c];
                int left = c-1<0 ? Integer.MAX_VALUE : dp[r-1][c-1];
                int right = c+1>=cols ? Integer.MAX_VALUE : dp[r-1][c+1];


                dp[r][c] = grid[r][c] + Math.min(up, Math.min(left, right));
            }
        }

        int minValue = Integer.MAX_VALUE;
        for(int c=0; c<cols; c++){
            minValue = Math.min(minValue, dp[rows-1][c]);
        }

        return minValue;
    }


    private int spaceOptimization(int[][] grid){
        int rows = grid.length, cols = grid[0].length;

        int[] prev = new int[cols];
        prev = grid[0];

        for(int r=1; r<rows; r++){
            int[] curr = new int[cols+1];
            for(int c=0; c<cols; c++){
                int up = prev[c];
                int left = c-1<0 ? Integer.MAX_VALUE : prev[c-1];
                int right = c+1>=cols ? Integer.MAX_VALUE : prev[c+1];


               curr[c] = grid[r][c] + Math.min(up, Math.min(left, right));
            }
            prev = curr;
        }

        int minValue = Integer.MAX_VALUE;
        for(int c=0; c<cols; c++){
            minValue = Math.min(minValue, prev[c]);
        }

        return minValue;
    }
}