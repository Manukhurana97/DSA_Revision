import java.util.*;

public class GridUniquePath{

	int uniquePath(int[][] grid){
		int r = grid.length;
		int c = grid[0].length;

		// return dfs(r-1, c-1, grid);

		// int[][] dp = new int[r][c];
		// for(int[] i: dp) Arrays.fill(i, -1);
		// return memoization(r-1, c-1, grid, dp);

		// return tabulation(r, c, grid, dp);

		return spaceOptimization(r, c, grid);
	}


	public int dfs(int r, int c, int[][] grid){
		if(r<0 || c<0) return 0;
		if(r == 0 && c == 0) return 1;


		int up = dfs(r-1, c, grid);
		int left = dfs(r, c-1, grid);


		return up + left;
	}


	public int memoization(int r, int c, int[][] grid, int[][] dp){
		if(r<0 || c<0) return 0;
		if(r == 0 && c == 0) return 1;

		if(dp[r][c] != -1) return dp[r][c];


		int up = memoization(r-1, c, grid, dp);
		int left = memoization(r, c-1, grid, dp);

		return dp[r][c] =  up + left;
	}


	/*
	 * Tabulation:
	 * Declare possible base case
	 * express all state in terms of for loop
	 * copy the recurrence and write 
	 * */
	public int tabulation(int row, int col, int[][] grid, int[][] dp){
		
		for(int r = 0; r<row; r++){
			for(int c = 0; c<col; c++){
				if(r == 0 && c == 0){  
					dp[0][0] = 1; 
					continue;
				}
				int up = r > 0 ? dp[r-1][c] : 0;
				int left = c > 0 ? dp[r][c-1] : 0;
			 	dp[r][c] =  up + left;
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
				int up = r > 0 ? prev[c] : 0;
				int left = c > 0 ? curr[c-1] : 0;
			 	curr[c] =  up + left;
			 }
			 prev = curr;
		}

		return prev[col-1];
	}

	public static void main(String[] args) {
		GridUniquePath obj = new GridUniquePath();

		int[][] grid = {{1,1,1}, {1,1,1}, {1,1,1}};
		System.out.println(obj.uniquePath(grid));
	}
}