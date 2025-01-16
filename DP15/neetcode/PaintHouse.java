// https://leetcode.com/problems/paint-house/description/ 
// https://www.lintcode.com/problem/515/

public class PaintHouse{

	private int minCost(int[][] costs) {
		int rows = costs.length;
		int cols = costs[0].length;
		
		// return recursion(rows-1, cols, costs);

		int[][] dp = new int[rows][cols];
		// return memoization(rows-1, cols, costs, dp);

		// return tabulation(costs, dp);

		return spaceOptimization(costs);
	}

	private int recursion(int r, int prev, int[][] costs){
		if(r < 0) return 0;

		int minCost = Integer.MAX_VALUE;
		for(int c=0; c<costs[r].length; c++){
			if(c!=prev){
				int cost = costs[r][c] + recursion(r-1, c, costs);
				minCost = Math.min(minCost, cost);
			}
		}

		return minCost;
	}


	private int memoization(int r, int prev, int[][] costs, int[][] dp){
		if(r < 0) return 0;

		if(dp[r][prev] != 0) return dp[r][prev];
		
		int minCost = Integer.MAX_VALUE;
		for(int c=0; c<costs[r].length; c++){
			if(c!=prev){
				int cost = costs[r][c] + memoization(r-1,  c, costs, dp);
				minCost = Math.min(minCost, cost);
			}
		}

		return dp[r][prev] = minCost;
	}


	private int tabulation(int[][] costs, int[][] dp){
		int rows = costs.length, cols = costs[0].length;

		for (int c = 0; c < cols; c++) {
	        dp[0][c] = costs[0][c];
	    }

		for (int r = 1; r < rows; r++) {		
				for (int c = 0; c < cols; c++) {
					int minCost = Integer.MAX_VALUE;
					for (int prev = 0; prev < cols; prev++){
					if(c!=prev){
						int cost = costs[r][c] + dp[r-1][prev];
						minCost = Math.min(minCost, cost);
					}
				}

				 dp[r][c] = minCost;
			}
		}

		int min = Integer.MAX_VALUE;
		for(int c=0; c<cols; c++){
			min = Math.min(min, dp[rows-1][c]);
		}

		return min;
	}



	private int spaceOptimization(int[][] costs){
		int rows = costs.length, cols = costs[0].length;
		int[] prevdp = new int[cols+1];
		

		for (int c = 0; c < cols; c++) {
	        prevdp[c] = costs[0][c];
	    }

		for (int r = 1; r < rows; r++) {
			int[] curr = new int[cols+1];		
			for (int c = 0; c < cols; c++) {
				int minCost = Integer.MAX_VALUE;
				for (int prev = 0; prev < cols; prev++){
					if(c!=prev){
						int cost = costs[r][c] + prevdp[prev];
						minCost = Math.min(minCost, cost);
					}
				}

				curr[c] = minCost;
			}
			prevdp = curr;
		}

		int min = Integer.MAX_VALUE;
		for(int c=0; c<cols; c++){
			min = Math.min(min, prevdp[c]);
		}

		return min;
	}


	public static void main(String[] args) {
		PaintHouse obj = new PaintHouse();
		int[][] arr = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
		System.out.println(obj.minCost(arr));
	}
}