/**
 * input give, if we cut the rod of size n, we are give profit per piece size & n : total rod size
 * Instead of taking is this way assume we have give rods  of size ith and profit per rod of ith, 
 * we have to find max profit but taking a rod (we have infinit quantity)
 * it will be same as unboundKnapSack
 * */

public class RodCutting{

	private int getMaxProfitByCuttingRod(int n, int[] price){

		// return recursion(price.length-1, n, price);

		int[][] dp = new int[price.length][n+1];
		// return memoization(price.length-1, n, price, dp);

		// return tabulation(n, price, dp);

		// return spaceOptimization(n, price);

		return spaceOptimization1(n, price);
	}

	private int recursion(int index, int target, int[] price){
		if(index == 0){
			return target * price[0];
		}

		int notTake = recursion(index-1, target, price);
		int rodLen = index+1;
		int take = target >= rodLen ? price[index] + recursion(index, target-rodLen, price) : Integer.MIN_VALUE;

		return Math.max(take, notTake); 
	}


	private int memoization(int index, int target, int[] price, int[][] dp){
		if(index == 0){
			return target * price[0];
		}

		if(dp[index][target] != 0) return dp[index][target];

		int notTake = memoization(index-1, target, price, dp);
		int rodLen = index+1;
		int take = target >= rodLen ? price[index] + memoization(index, target-rodLen, price, dp) : Integer.MIN_VALUE;

		return dp[index][target] = Math.max(take, notTake); 
	}


	/**
	 * 1. base case
	 * 2. changing parameters
	 * 3. copy recurrence
	 * 
	 * */
	private int tabulation(int target, int[] price, int[][] dp){
		for(int t=0; t<=target; t++){
			dp[0][t] =  t * price[0];
		}

		for(int index=1; index<price.length; index++){
			for(int t=0; t<=target; t++){
				// Not taking the current rod length
                int notTake = dp[index - 1][t];

				int rodLen = index + 1;
				int take = t >= rodLen ? price[index] + dp[index][t-rodLen] : Integer.MIN_VALUE;

				dp[index][t] = Math.max(take, notTake); 
			}
		}

		return dp[price.length-1][target];
	}


	private int spaceOptimization(int target, int[] price){
		int[] curr = new int[target+1];
		int[] prev = new int[target+1];

		for(int t=0; t<=target; t++){
			prev[t] =  t * price[0];
		}

		for(int index=1; index<price.length; index++){
			for(int t=0; t<=target; t++){
				// Not taking the current rod length
                int notTake = prev[t];

                // Taking the current rod length if possible
				int rodLen = index + 1;
				int take = t >= rodLen ? price[index] + curr[t-rodLen] : Integer.MIN_VALUE;

				curr[t] = Math.max(take, notTake); 
			}
			prev = curr;
		}

		return prev[target];
	}


	private int spaceOptimization1(int target, int[] price){
		int[] prev = new int[target+1];

		for(int t=0; t<=target; t++){
			prev[t] =  t * price[0];
		}

		for(int index=1; index<price.length; index++){
			for(int t=0; t<=target; t++){
				// Not taking the current rod length
                int notTake = prev[t];

                // Taking the current rod length if possible
				int rodLen = index + 1;
				int take = t >= rodLen ? price[index] + prev[t-rodLen] : Integer.MIN_VALUE;

				prev[t] = Math.max(take, notTake); 
			}
		}

		return prev[target];
	}


	public static void main(String[] args) {
		RodCutting obj = new RodCutting();

		int[] arr = {2, 5, 7, 8, 10};
		System.out.println(obj.getMaxProfitByCuttingRod(5, arr));
	}
}
