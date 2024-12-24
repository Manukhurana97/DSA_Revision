public class UnboundedKnapSack{

	private int unboundedKnapsack(int wt, int[][] grid){

		// return recursion(grid.length-1, wt, grid);

		// int[][] dp = new int[grid.length][wt+1];
		// return memoization(grid.length-1, wt, grid, dp);

		// return tabulation(wt, grid, dp);

		// return spaceOptimization(wt, grid);
		
		return spaceOptimization1(wt, grid);
	}

	// Time : O(almost exponential), Space O(>>n)
	private int recursion(int index, int wt, int[][] grid){
		if(index == 0){
			return (wt >= grid[index][0]) ? (wt / grid[index][0]) * grid[index][1] : Integer.MIN_VALUE;
		}

		int notTake = recursion(index-1, wt, grid);
		int take = wt >= grid[index][0] ? grid[index][1] + recursion(index, wt-grid[index][0], grid) : Integer.MIN_VALUE;

		return Math.max(take, notTake);
	}


	// Time : O(n), Space O(n+n{recursion space })
	private int memoization(int index, int wt, int[][] grid, int[][] dp){
		if(index == 0){
			return (wt >= grid[index][0]) ? (wt / grid[index][0]) * grid[index][1] : Integer.MIN_VALUE;
		}

		if(dp[index][wt] != 0) return dp[index][wt];

		int notTake = memoization(index-1, wt, grid, dp);
		int take = wt >= grid[index][0] ? grid[index][1] + memoization(index, wt-grid[index][0], grid, dp) : Integer.MIN_VALUE;

		return dp[index][wt] = Math.max(take, notTake);
	}


	// Time : O(n), Space O(n)
	private int tabulation(int wt, int[][] grid, int[][] dp){
		for(int t=0; t<=wt; t++){
			dp[0][t] = (wt >= grid[0][0]) ? (t / grid[0][0]) * grid[0][1] : Integer.MIN_VALUE;
		}

		for(int index=1; index<grid.length; index++){
			for(int t=0; t<=wt; t++){
				int notTake = dp[index-1][t];
				int take = t >= grid[index][0] ? grid[index][1] + dp[index][t-grid[index][0]] : Integer.MIN_VALUE;
	
				dp[index][t] = Math.max(take, notTake);
			}}

		return dp[grid.length-1][wt];
	}


	// Time : O(n), Space O(wt)
	private int spaceOptimization(int wt, int[][] grid){
		int[] prev = new int[wt+1];
		int[] curr = new int[wt+1];

		for(int t=0; t<=wt; t++){
			prev[t] = (wt >= grid[0][0]) ? (t / grid[0][0]) * grid[0][1] : Integer.MIN_VALUE;
		}

		for(int index=1; index<grid.length; index++){
			for(int t=0; t<=wt; t++){
				int notTake = prev[t];
				int take = t >= grid[index][0] ? grid[index][1] + curr[t-grid[index][0]] : Integer.MIN_VALUE;
	
				curr[t] = Math.max(take, notTake);
			}
			prev = curr;
		}

		return prev[wt];
	}


	// Time : O(n), Space O(2wt)
	private int spaceOptimization1(int wt, int[][] grid){
		int[] prev = new int[wt+1];

		for(int t=0; t<=wt; t++){
			prev[t] = (wt >= grid[0][0]) ? (t / grid[0][0]) * grid[0][1] : Integer.MIN_VALUE;
		}

		for(int index=1; index<grid.length; index++){
			for(int t=0; t<=wt; t++){
				int notTake = prev[t];
				int take = t >= grid[index][0] ? grid[index][1] + prev[t-grid[index][0]] : Integer.MIN_VALUE;
	
				prev[t] = Math.max(take, notTake);
			}
		}

		return prev[wt];
	}

	public static void main(String[] args) {
		UnboundedKnapSack obj = new UnboundedKnapSack();
		int[][] arr = {{2, 5}, {4, 11}, {6, 13}};

		System.out.println(obj.unboundedKnapsack(10, arr));
	}

}