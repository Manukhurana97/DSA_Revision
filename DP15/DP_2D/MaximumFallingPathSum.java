public class MaximumFallingPathSum{
	public int maxSumPath(int[][] grid){

		int row = grid.length;
		int col = grid[0].length;
		int matPathSum = 0;

		int[][] dp = new int[row][col];

		// for(int c=0; c<col; c++){
		// 	// matPathSum = Math.max(matPathSum, recussion(row-1, c,grid));
		// 
		// 	// matPathSum = Math.max(matPathSum, memoization(row-1, c,grid, dp));
		// }

		// matPathSum = Math.max(matPathSum, tabulation(row-1, col-1,grid, dp));

		matPathSum = Math.max(matPathSum, spaceOptimization(row-1, col-1,grid));

		return matPathSum;
	}

	public int recussion(int row, int col, int[][] grid){
		if(col<0 || col>=grid[0].length) return Integer.MIN_VALUE;
		if(row == 0) return grid[row][col];

		
		int up = recussion(row-1, col, grid);
		int left = recussion(row-1, col-1, grid);
		int right = recussion(row-1, col+1, grid);
		

		return grid[row][col] + Math.max(up, Math.max(left, right));
	}


	public int memoization(int row, int col, int[][] grid, int[][] dp){
		if(col<0 || col>=grid[0].length) return Integer.MIN_VALUE;
		if(row == 0) return grid[row][col];

		if(dp[row][col] != 0) return dp[row][col];

		
		int up = memoization(row-1, col, grid, dp);
		int left = memoization(row-1, col-1, grid, dp);
		int right = memoization(row-1, col+1, grid, dp);
		

		return dp[row][col] = grid[row][col] + Math.max(up, Math.max(left, right));
	} 


	public int tabulation(int row, int col, int[][] grid, int[][] dp){
		if(row == 0) return grid[row][col];

		// Initialize the first row.
		dp[0] = grid[0];

		for(int r=1; r<=row; r++){
			for(int c=0; c<=col; c++){
				int up = dp[r - 1][c];
				int left = c > 0 ? dp[r - 1][c - 1] : Integer.MIN_VALUE;
				int right = c < col ? dp[r - 1][c + 1] : Integer.MIN_VALUE;

				dp[r][c] = grid[r][c] + Math.max(up, Math.max(left, right));
			}
		}

		return dp[row][col];
	}

	public int spaceOptimization(int row, int col, int[][] grid){
		if(row == 0) return grid[row][col]; 

		// Initialize the first row.
		int[] prev = grid[0];

		for(int r=1; r<=row; r++){
			int[] curr = new int[col+1];
			for(int c=0; c<=col; c++){
				int up = prev[c];
				int left = c > 0 ? prev[c - 1] : Integer.MIN_VALUE;
				int right = c < col ? prev[c + 1] : Integer.MIN_VALUE;

				curr[c] = grid[r][c] + Math.max(up, Math.max(left, right));
			}
			prev = curr;
		}

		return prev[col];
	}


	public static void main(String[] args) {
		MaximumFallingPathSum obj = new MaximumFallingPathSum();

		int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		System.out.println(obj.maxSumPath(arr));
	}

}