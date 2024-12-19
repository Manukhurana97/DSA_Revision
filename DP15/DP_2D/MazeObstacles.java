public class MazeObstacles{

	public int uniquePath(int[][] grid){
		int r = grid.length;
		int c = grid[0].length;

		// return dfs(r-1,c-1,grid);

		// int[][] dp = new int[r][c];
		// return memoization(r-1,c-1,grid, dp);

		// return tabulation(r,c,grid, dp);

		return spaceOptimization(r, c, grid);
	}

	public int dfs(int r, int c, int[][] grid){
		if(r==0 && c==0) return 1;
		if(r<0 || c<0 || grid[r][c] == -1) return 0;

		int up = dfs(r-1, c, grid);
		int left = dfs(r, c-1, grid);

		return up + left;
	}

	public int memoization(int r, int c, int[][] grid, int[][] dp){
		if(r==0 && c==0) return 1;
		if(r<0 || c<0 || grid[r][c] == -1) return 0;

		if(dp[r][c] == -1) return 0;

		int up = memoization(r-1, c, grid, dp);
		int left = memoization(r, c-1, grid, dp);

		return dp[r][c] = up + left;
	}


	public int tabulation(int row, int col, int[][] grid, int[][] dp){
		
		for(int r = 0; r<row; r++){
			for(int c = 0; c<col; c++){
				if(r == 0 && c == 0){  
					dp[0][0] = 1; 
					continue;
				}
				if(grid[r][c] == -1){
					dp[r][c] = 0;
					continue;
				}

				int up = r>0 ? dp[r-1][c] : 0;
				int left = c>0 ? dp[r][c-1] : 0;
				dp[r][c] = up + left;
			}
		}

		return dp[row-1][col-1];
	}


	public int spaceOptimization(int row, int col, int[][] grid){
		int[] prev = new int[col];
		
		for(int r = 0; r<row; r++){
			int[] curr = new int[col];
			for(int c = 0; c<col; c++){
				if(r == 0 && c == 0){  
					curr[0] = 1; 
					continue;
				}

				if(grid[r][c] == -1){
					curr[c] = 0;
					continue;
				}

				int up = r > 0 ? prev[c] : 0;
				int left = c > 0 ? curr[c-1] : 0;
			 	curr[c] =  up + left;
			}

			prev = curr;
		}

		return prev[col-1];
	}


	public static void main(String[] args) {
		MazeObstacles obj = new MazeObstacles();

		int[][] arr = {{1,1,1,}, {1,-1,1}, {1,1,1}};
		System.out.println(obj.uniquePath(arr));
	}
}