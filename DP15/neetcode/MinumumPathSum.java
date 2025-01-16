// https://leetcode.com/problems/minimum-path-sum/

public class MinumumPathSum{
	public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // int[][] dp = new int[rows][cols];

        // return recursion(rows-1, cols-1, grid, dp);

        // return tabulation(rows, cols, grid, dp);

        return spaceOptimization1(rows, cols, grid);
    }


    private int recursion(int r, int c, int[][] grid, int[][] dp){
        if(r<0 || c<0) return Integer.MAX_VALUE;
        if(r == 0 && c == 0) return grid[r][c];

        if(dp[r][c] != 0) return dp[r][c];

        int up = recursion(r-1, c, grid, dp);
        int left = recursion(r, c-1, grid, dp);

        return dp[r][c] = grid[r][c] + Math.min(left, up);
    }


    private int tabulation(int rows, int cols, int[][] grid, int[][] dp){
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(r==0 && c==0){
                    dp[r][c] =  grid[r][c];
                    continue;
                }

                int up = r-1 >= 0 ? dp[r-1][c] : Integer.MAX_VALUE;;
                int left = c-1 >= 0 ? dp[r][c-1] : Integer.MAX_VALUE;;

                dp[r][c] = grid[r][c] + Math.min(left, up);
            }
        }
        
        return dp[rows-1][cols-1];
    }


    private int spaceOptimization(int rows, int cols, int[][] grid){
        int[] prev = new int[cols];
        
        for(int r=0; r<rows; r++){
            int[] curr = new int[cols];
            for(int c=0; c<cols; c++){
                if(r==0 && c==0){
                    curr[c] =  grid[r][c];
                    continue;
                }
                
                int up = r-1 >= 0 ? prev[c] : Integer.MAX_VALUE;;
                int left = c-1 >= 0 ? curr[c-1] : Integer.MAX_VALUE;;

                curr[c] = grid[r][c] + Math.min(left, up);
            }
            prev = curr;
        }
        
        return prev[cols-1];
    }


    private int spaceOptimization1(int rows, int cols, int[][] grid){
        int[] prev = new int[cols];
        
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(r==0 && c==0){
                    prev[c] =  grid[r][c];
                    continue;
                }
                
                int up = r-1 >= 0 ? prev[c] : Integer.MAX_VALUE;;
                int left = c-1 >= 0 ? prev[c-1] : Integer.MAX_VALUE;;

                prev[c] = grid[r][c] + Math.min(left, up);
            }
        }
        
        return prev[cols-1];
    }
}