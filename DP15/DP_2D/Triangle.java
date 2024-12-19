// fix starting point and variable ending point
public class Triangle{

	public int minPathSum(int[][] grid){

		// return dfs(0, 0, grid);

		// int[][] dp = new int[grid.length][grid[grid.length - 1].length];
		// return memoization(0, 0, grid, dp);

		// return tabulation(grid, dp);

		return spaceOptimization(grid);

	}

	public int dfs(int r, int c, int[][] grid){
		if(r >= grid.length || c>= grid[r].length) return Integer.MAX_VALUE;
		if(r==grid.length-1) return grid[r][c];

		int down = dfs(r+1, c, grid);
		int downRight = dfs(r + 1, c+1, grid);

		return grid[r][c] + Math.min(down, downRight);
	}


	public int memoization(int r, int c, int[][] grid, int[][] dp){
		if(r >= grid.length || c>= grid[r].length) return Integer.MAX_VALUE;
		if(r==grid.length-1) return grid[r][c];

		if(dp[r][c] != 0) return dp[r][c];

		int down = memoization(r+1, c, grid, dp);
		int downRight = memoization(r + 1, c+1, grid, dp);

		return dp[r][c] =  grid[r][c] + Math.min(down, downRight);
	}

	public int tabulation(int[][] grid, int[][] dp){
		int rows = grid.length;
		for(int c=0; c<grid[rows - 1].length; c++){
			dp[rows-1][c] = grid[rows-1][c];
		}

		for(int r=rows-2; r>=0; r--){
			for(int c=0; c<grid[r].length; c++){
				int down = dp[r+1][c]; // Value directly below
				int downRight = c + 1 < grid[r + 1].length ? dp[r + 1][c+1] : Integer.MAX_VALUE; // Value down-right, if within bounds

				dp[r][c] = grid[r][c] + Math.min(down, downRight);
			}
		}

		return dp[0][0];
	}


	public int spaceOptimization(int[][] grid){
		int rows = grid.length;
		int[] prev = new int[grid[rows-1].length];

		for(int c=0; c<grid[rows - 1].length; c++){
			prev[c] = grid[rows-1][c];
		}

		for(int r=rows-2; r>=0; r--){
			int[] curr = new int[grid[rows-1].length];
			for(int c=0; c<grid[r].length; c++){
				int down = prev[c]; // Value directly below
				int downRight = c + 1 < grid[r + 1].length ? prev[c+1] : Integer.MAX_VALUE; // Value down-right, if within bounds

				curr[c] = grid[r][c] + Math.min(down, downRight);
			}

			prev = curr;
		}

		return prev[0];
	}

	public static void main(String[] args) {
		Triangle obj = new Triangle();
		int[][] arr = {{1}, {2,3}, {4,5,6}, {7,8,9,10}};
		System.out.println(obj.minPathSum(arr));
	}
}