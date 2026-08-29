// https://leetcode.com/problems/cherry-pickup/

public class CherryPickup{
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];

        return Math.max(0, recursion(0, 0, 0, grid, dp));
    }

    private int recursion(int r, int c1, int c2, int[][] grid, Integer[][][] dp) {
        if(r >= grid.length || r+c1-c2 >= grid.length || c1 >= grid.length || c2 >= grid.length || grid[r][c1] == -1 || grid[r+c1-c2][c2] == -1) return Integer.MIN_VALUE;

        if(r == grid.length-1 && c1 == grid.length-1) return grid[r][c1];

        if(dp[r][c1][c2] != null) return dp[r][c1][c2];
        
        int cherries = grid[r][c1] + (c1 != c2 ? grid[r+c1-c2][c2] : 0);
        
        int maxCherries = Math.max(
            Math.max(recursion(r+1, c1, c2, grid, dp), recursion(r, c1+1, c2, grid, dp)),
            Math.max(recursion(r+1, c1, c2+1, grid, dp), recursion(r, c1+1, c2+1, grid, dp))
        );

        cherries += maxCherries;

        return dp[r][c1][c2] = cherries;

    }
}


/**
 * 
 * class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dp = [[[[-1] * n for _ in range(n)] for _ in range(n)] for _ in range(n)]
        

        def recursion(r1, r2, c1, c2):
            if r1 >= n or r2 >= n or c1 >= n or c2 >= n or grid[r1][c1] == -1 or grid[r2][c2] == -1: 
                return float("-inf")
            if r1 == n-1 and c1 == n-1:
                return grid[r1][c1]
            
            if dp[r1][r2][c1][c2] != -1:
                return dp[r1][r2][c1][c2]

            cherries = grid[r1][c1] + (0 if r1 == r2 and c1 == c2 else grid[r2][c2])
            cherries += max(
                recursion(r1, r2, c1+1, c2+1), # down, down 
                recursion(r1+1, r2, c1, c2+1), # down, right
                recursion(r1, r2+1, c1+1, c2), # right, down
                recursion(r1+1, r2+1, c1, c2), # right, right
            )

            dp[r1][r2][c1][c2] = cherries
            return cherries

        return max(0, recursion(0, 0, 0, 0))

 * 
 * */ 