// https://leetcode.com/problems/cherry-pickup/

public class CherryPickup{
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];

        return Math.max(0, recursion(0, 0, 0, grid, dp));
    }

    private int recursion(int r1, int c1,int c2, int[][] grid, Integer[][][] dp){
        // consider 2 person going from (0, 0) to (n, n)
        // person 1 : (r1, c1), person 2 : (r2, c2) 
        // since both are moving simaltaniously r1 + c1 = r2 + c2 => r2 = r1+c1-c2;


        int n = grid.length, r2 = r1 +c1-c2;
        
        if(r1 >= n || r2 >= n || c1 >=n || c2 >= n ||grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;
        if(r1 == n-1 && c1 == n-1) return grid[r1][c1];

        if(dp[r1][c1][c2] != null) return dp[r1][c1][c2];

        int cherries = grid[r1][c1] + (c1 != c2 ? grid[r2][c2] : 0);
    
        cherries += Math.max(
            Math.max(recursion(r1+1, c1, c2, grid, dp), recursion(r1, c1+1, c2, grid, dp)),
            Math.max(recursion(r1+1, c1, c2+1, grid, dp), recursion(r1, c1+1, c2+1, grid, dp))
        );

        return dp[r1][c1][c2] = cherries;
    }    
}