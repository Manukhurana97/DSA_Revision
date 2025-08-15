// https://leetcode.com/problems/dungeon-game/

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        // return recursion(0, 0, dungeon, dp); 
        return tabulation(dungeon, dp);
    }

    private int recursion(int r, int c,  int[][] grid, int[][] dp) {
        if(r>=grid.length || c>=grid[r].length) return Integer.MAX_VALUE;
        if(r == grid.length-1 && c == grid[r].length-1) return Math.max(1, 1-grid[r][c]);
        if(dp[r][c] != 0) return dp[r][c];


        int bestValue = Math.min(recursion(r, c+1, grid, dp), recursion(r+1, c, grid, dp)) - grid[r][c];
        return dp[r][c] =  Math.max(1, bestValue);
    }


    private int tabulation(int[][] grid, int[][] dp) {
        int rows = grid.length, cols = grid[0].length;

        for(int r=rows-1; r>=0; r--) {
            for(int c=cols-1; c>=0; c--) {
                if(rows-1 == r && cols-1 == c) {
                    dp[r][c] = Math.max(1, 1-grid[r][c]);
                    continue;
                }

                int bestValue = Math.min(c+1>=grid[0].length ? Integer.MAX_VALUE : dp[r][c+1], r+1 >= grid.length ? Integer.MAX_VALUE : dp[r+1][c]) - grid[r][c];
                dp[r][c] =  Math.max(1, bestValue);
            }
        }

        return dp[0][0];
    }
}