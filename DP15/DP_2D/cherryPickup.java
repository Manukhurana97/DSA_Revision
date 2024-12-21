import java.util.*;

public class cherryPickup{
	public int maxChocolates(int[][] grid){
		int row = grid.length;
		int col = grid[0].length;

		// return recursion(0, 0, col-1, grid);

		// int[][][] dp = new int[row][col][col];

		// return memoization(0, 0, col-1, grid, dp);

		// return tabulation(row, col, grid, dp);

		return spaceOptimization(row, col, grid);
	}

	public int recursion(int r, int c1, int c2, int[][] grid){
		if(c1 < 0 || c2 < 0 || c1 >= grid[r].length || c2 >= grid[r].length) return Integer.MIN_VALUE; // Out of bounds

		if(r == grid.length-1){
			// If at the last row, collect chocolates from both positions
			return grid[r][c1] + (c1 == c2 ? 0 :  grid[r][c2]);
		}

		int maxValue = Integer.MIN_VALUE;
		for(int i=-1; i<=1;i++){ // Move for the first person
			for(int j=-1; j<=1; j++){ // Move for the second person

				int value = grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);

				value += recursion(r+1, c1+i, c2+j, grid);

				maxValue = Math.max(maxValue, value);
			}
		}

		return maxValue;
	}



	public int memoization(int r, int c1, int c2, int[][] grid, int[][][] dp){
		if(c1 < 0 || c2 < 0 || c1 >= grid[r].length || c2 >= grid[r].length) return Integer.MIN_VALUE; // Out of bounds

		if(r == grid.length-1){
			// If at the last row, collect chocolates from both positions
			return grid[r][c1] + (c1 == c2 ? 0 :  grid[r][c2]);
		}

		if(dp[r][c1][c2] != 0) return dp[r][c1][c2];

		int maxValue = Integer.MIN_VALUE;
		for(int i=-1; i<=1;i++){ // Move for the first person
			for(int j=-1; j<=1; j++){ // Move for the second person

				int value = grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);

				value += memoization(r+1, c1+i, c2+j, grid, dp);

				maxValue = Math.max(maxValue, value);
			}
		}

		dp[r][c1][c2] = maxValue;

		return maxValue;
	}


	public int tabulation(int row, int col, int[][] grid, int[][][] dp){

		for (int c1 = 0; c1 < col; c1++) {
	        for (int c2 = 0; c2 < col; c2++) {
	            dp[row - 1][c1][c2] = grid[row - 1][c1] + (c1 == c2 ? 0 : grid[row - 1][c2]);
	        }
	    }
		

		for (int r = row - 2; r >= 0; r--) {
	        for (int c1 = 0; c1 < col; c1++) {
	            for (int c2 = 0; c2 < col; c2++) {
					int maxValue = Integer.MIN_VALUE;

					for(int i=-1; i<=1;i++){ // Move for the first person
						for(int j=-1; j<=1; j++){ // Move for the second person

							int value = grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);

							value += (c1+i>=0 && c2+j>=0 &&  c1+i < grid[r].length && c2+j < grid[r].length) ? dp[r+1][c1+i][c2+j] : Integer.MIN_VALUE;

							maxValue = Math.max(maxValue, value);
						}
					}
					dp[r][c1][c2] = maxValue;
				}
				
			}
		}
	

		int result = Integer.MIN_VALUE;
	    for (int c1 = 0; c1 < col; c1++) {
	        for (int c2 = 0; c2 < col; c2++) {
	            result = Math.max(result, dp[0][c1][c2]);
	        }
	    }
	    return result;
	}



	public int spaceOptimization(int rows, int cols, int[][] grid) {
    int[][] dp = new int[cols][cols];
    int[][] curr = new int[cols][cols];

    // Initialize dp for the last row
    for (int c1 = 0; c1 < cols; c1++) {
        for (int c2 = 0; c2 < cols; c2++) {
            dp[c1][c2] = grid[rows - 1][c1] + (c1 == c2 ? 0 : grid[rows - 1][c2]);
        }
    }

    // Fill dp bottom-up
    for (int r = rows - 2; r >= 0; r--) {
        for (int c1 = 0; c1 < cols; c1++) {
            for (int c2 = 0; c2 < cols; c2++) {
                int maxValue = Integer.MIN_VALUE;

                for (int move1 = -1; move1 <= 1; move1++) {
                    for (int move2 = -1; move2 <= 1; move2++) {
                        int newC1 = c1 + move1;
                        int newC2 = c2 + move2;

                        if (newC1 >= 0 && newC1 < cols && newC2 >= 0 && newC2 < cols) {
                            int value = grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]) + dp[newC1][newC2];
                            maxValue = Math.max(maxValue, value);
                        }
                    }
                }
                curr[c1][c2] = maxValue;
            }
        }

        // Copy curr to dp for the next iteration
        for (int c1 = 0; c1 < cols; c1++) {
            for (int c2 = 0; c2 < cols; c2++) {
                dp[c1][c2] = curr[c1][c2];
            }
        }
    }

    // Get the result from the first row
    int result = Integer.MIN_VALUE;
    for (int c1 = 0; c1 < cols; c1++) {
        for (int c2 = 0; c2 < cols; c2++) {
            result = Math.max(result, dp[c1][c2]);
        }
    }

    return result;
}




	public static void main(String[] args) {
		cherryPickup obj = new cherryPickup();
		int[][] grid = {
		    {2, 3, 1, 2},
		    {3, 4, 5, 1},
		    {1, 2, 1, 3},
		    {4, 1, 2, 1}
		};
	System.out.println(obj.maxChocolates(grid));
	}
}