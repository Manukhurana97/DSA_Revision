// https://leetcode.com/problems/cherry-pickup-ii/

import java.util.*;

public class cherryPickup{
	class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];

        // return recursion(0, 0, cols-1, grid, dp);

        // return tabulation(grid, dp);

        return spaceOptimization(grid);
    }

    private int recursion(int r, int c1, int c2, int[][] grid, int[][][] dp) {
        if(c1 < 0 || c2 < 0 || c1 >= grid[0].length || c2 >= grid[0].length) return Integer.MIN_VALUE;
        if(r == grid.length - 1) return grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
 
        if(dp[r][c1][c2] != 0) return dp[r][c1][c2];

        int maxSum = Integer.MIN_VALUE;
        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                int sum = grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
                
                sum += recursion(r+1, c1+i, c2+j, grid, dp);
                
                maxSum = Math.max(maxSum, sum);
            }
        }

        return dp[r][c1][c2] = maxSum;
    }

    private int tabulation(int[][] grid, int[][][] dp) {
        int rows = grid.length, cols = grid[0].length;

        for(int c1=0; c1<cols; c1++) {
            for(int c2=0; c2<cols; c2++) {
                dp[rows-1][c1][c2] = grid[rows-1][c1] + (c1 == c2 ? 0 : grid[rows-1][c2]);
            }
        }

        for(int r=rows-2; r>=0; r--) {
            for(int c1=0; c1<cols; c1++) {
                for(int c2=0; c2<cols; c2++) {
                    int maxSum = Integer.MIN_VALUE;

                    for(int i=-1; i<=1; i++) {
                        for(int j=-1; j<=1; j++) {
                            int sum = grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
                            
                            sum += (r+1 >= rows || c1 + i < 0 || c2 + j < 0 || c1 + i >= grid[0].length || c2 + j >= grid[0].length) ? Integer.MIN_VALUE : dp[r+1][c1+i][c2+j];
                            
                            maxSum = Math.max(maxSum, sum);
                        }
                    }

                    dp[r][c1][c2] = maxSum;
                }
            }
        }

        return dp[0][0][cols-1];
    }


    private int spaceOptimization(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] prev = new int[cols][cols];

        for(int c1=0; c1<cols; c1++) {
            for(int c2=0; c2<cols; c2++) {
                prev[c1][c2] = grid[rows-1][c1] + (c1 == c2 ? 0 : grid[rows-1][c2]);
            }
        }

        for(int r=rows-2; r>=0; r--) {
            int[][] curr = new int[cols][cols];

            for(int c1=0; c1<cols; c1++) {
                for(int c2=0; c2<cols; c2++) {
                    int maxSum = Integer.MIN_VALUE;

                    for(int i=-1; i<=1; i++) {
                        for(int j=-1; j<=1; j++) {
                            int sum = grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
                            
                            sum += (r+1 >= rows || c1 + i < 0 || c2 + j < 0 || c1 + i >= grid[0].length || c2 + j >= grid[0].length) ? Integer.MIN_VALUE : prev[c1+i][c2+j];
                            
                            maxSum = Math.max(maxSum, sum);
                        }
                    }

                    curr[c1][c2] = maxSum;
                }
            }

            prev = curr;
        }

        return prev[0][cols-1];
    }
}
