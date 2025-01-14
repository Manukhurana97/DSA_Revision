// https://leetcode.com/problems/unique-paths-ii/

public class UniquePath2{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        Integer[][] dp = new Integer[rows][cols];

        // return recursion(rows-1, cols-1, obstacleGrid, dp);

        // return tabulation(obstacleGrid);

        return spaceOptimization(obstacleGrid);
    }

    private int recursion(int r, int c, int[][] grid, Integer[][] dp){
        if(r<0 || c<0 || grid[r][c] == 1) return 0; // out of bound case
        if(r==0 && c==0) return 1;

        if(dp[r][c]!=null) return dp[r][c];

        int up = recursion(r-1, c, grid, dp);
        int left = recursion(r, c-1, grid, dp);

        return dp[r][c] = up + left;
    }


    private int tabulation(int[][] grid){
        int rows = grid.length, cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(r==0 && c==0 && grid[r][c]!=1){
                    dp[r][c] = 1;
                    continue;
                }

                if(grid[r][c] == 1){
                    dp[r][c] = 0;
                    continue;
                }

                int up = r-1<0 ? 0 : dp[r-1][c];
                int left = c-1<0 ? 0 : dp[r][c-1];

                dp[r][c] = up + left;
            }
        }

        return dp[rows-1][cols-1];
    }


    private int spaceOptimization(int[][] grid){
        int rows = grid.length, cols = grid[0].length;

        int[] prev = new int[cols];
        
        for(int r=0; r<rows; r++){
            int[] curr = new int[cols];
            for(int c=0; c<cols; c++){
                if(r==0 && c==0 && grid[r][c]!=1){
                    curr[c] = 1;
                    continue;
                }

                if(grid[r][c] == 1){
                    prev[c] = 0;
                    continue;
                }

                int up = r-1<0 ? 0 : prev[c];
                int left = c-1<0 ? 0 : curr[c-1];

                curr[c] = up + left;
            }
            prev = curr;
        }

        return prev[cols-1];
    }
}