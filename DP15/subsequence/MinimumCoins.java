public class MinimumCoins{

	public int getMinCoins(int target, int[] coins){

		int n = coins.length;
		// return recursion(n-1, target, coins);

		int[][] dp = new int[n][target+1];
		// return memoization(n-1, target, coins, dp);
		
		// return tabulation(target, coins, dp);

		return spaceOptimization(target, coins);
	}

	public int recursion(int n, int target, int[] coins){
		if(n == 0){
			if(target % coins[n] == 0) return target/coins[n];
			return Integer.MAX_VALUE;
		}


		int notTake = recursion(n-1, target, coins);
		int take = target >= coins[n] ? 1 + recursion(n, target-coins[n], coins) : Integer.MAX_VALUE;


		return Math.min(take, notTake);
	}


	public int memoization(int n, int target, int[] coins, int[][] dp){
		if(n == 0){
			if(target % coins[n] == 0) return target/coins[n];
			return Integer.MAX_VALUE;
		}

		if(dp[n][target] != 0) return dp[n][target];

		int notTake = memoization(n-1, target, coins, dp);
		int take = target >= coins[n] ? 1 + memoization(n, target-coins[n], coins, dp) : Integer.MAX_VALUE;


		return dp[n][target] = Math.min(take, notTake);
	}


	public int tabulation(int target, int[] coins, int[][] dp){
		int n = coins.length;

		for(int t=0; t<=target; t++){
			if(t % coins[0] == 0) dp[0][t] = t/coins[0];
			else dp[0][t] = Integer.MAX_VALUE;
		}

		for(int index=1; index<n; index++){
			for(int t=0; t<=target; t++){
				int notTake =dp[index-1][t];
				int take = t >= coins[index] ? 1 + dp[index][t-coins[index]] : Integer.MAX_VALUE;

				dp[index][t] = Math.min(take, notTake);
			}
		}

		return dp[n-1][target] == Integer.MAX_VALUE ? -1: dp[n-1][target];
	}


	public int spaceOptimization(int target, int[] coins){
		int n = coins.length;

		int[] prev = new int[target+1];
		int[] curr = new int[target+1];

		
		for(int t=0; t<=target; t++){
			if(t % coins[0] == 0) prev[t] = t/coins[0];
			else prev[t] = Integer.MAX_VALUE;
		}
		for(int index=1; index<n; index++){
			for(int t=0; t<=target; t++){
				int notTake =prev[t];
				int take = t >= coins[index] ? 1 + curr[t-coins[index]] : Integer.MAX_VALUE;

				curr[t] = Math.min(take, notTake);
			}
			prev = curr;
		}

		return prev[target] == Integer.MAX_VALUE ? -1: prev[target];
	}



	public static void main(String[] args) {
		MinimumCoins obj = new MinimumCoins();
		int[] arr = {1,2,5};

		System.out.println(obj.getMinCoins(23, arr));
	}
}