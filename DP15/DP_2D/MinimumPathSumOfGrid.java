public class MinimumPathSumOfGrid{

	public int minPathSum(int[][] grid){

		int r = grid.length;
		int c = grid[0].length;

		// return dfs(r-1, c-1, grid);

		int[][] dp = new int[r][c];
		// return memoization(r-1, c-1, grid, dp);

		// return tabulation(r-1, c-1, grid, dp);

		return spaceOptimization(r-1, c-1, grid);
	}


	public int dfs(int r, int c, int[][] grid){
		if(r<0  || c<0) return Integer.MAX_VALUE;
		if(r==0 && c==0) return grid[r][c];

		int up = dfs(r-1, c, grid);
		int left = dfs(r, c-1, grid);

		return grid[r][c] + Math.min(up, left);
	}

	public int memoization(int r, int c, int[][] grid, int[][] dp){
		if(r<0  || c<0) return Integer.MAX_VALUE;
		if(r==0 && c==0) return grid[r][c];

		if(dp[r][c] !=0) return dp[r][c];

		int up = memoization(r-1, c, grid, dp);
		int left = memoization(r, c-1, grid, dp);

		dp[r][c] = grid[r][c] + Math.min(up, left);
		return dp[r][c];
	}

	public int tabulation(int row, int col, int[][] grid, int[][] dp){

		if(row==0 && col==0) return grid[row][col]; 

		for(int r=0; r<=row; r++){
			for(int c=0; c<=col; c++){
				if(r == 0 && c == 0){
					dp[r][c] = grid[r][c];
					continue;
				}

				int up = r > 0 ? dp[r-1][c] : Integer.MAX_VALUE;
				int left = c > 0 ? dp[r][c-1] : Integer.MAX_VALUE;

				dp[r][c] = grid[r][c] + Math.min(up, left);
			}
		}
		return dp[row][col];
	}


	public int spaceOptimization(int row, int col, int[][] grid){

		if(row==0 && col==0) return grid[row][col]; 

		int[] prev = new int[col+1];

		for(int r=0; r<=row; r++){
			int[] curr = new int[col+1];
			for(int c=0; c<=col; c++){
				if(r == 0 && c == 0){
					curr[c] = grid[r][c];
					continue;
				}

				int up = r > 0 ? prev[c] : Integer.MAX_VALUE;
				int left = c > 0 ? curr[c-1] : Integer.MAX_VALUE;

				curr[c] = grid[r][c] + Math.min(up, left);
			}
			prev = curr;
		}
		return prev[col];
	}

	public static void main(String[] args) {
		MinimumPathSumOfGrid obj = new MinimumPathSumOfGrid();
		int[][] arr = {
			{10, 8, 2}, 
			{10, 5, 100}, 
			{1,	 1,  2}
		};
		System.out.println(obj.minPathSum(arr));

	}
}