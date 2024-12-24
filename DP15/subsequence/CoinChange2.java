public class CoinChange2{

	// n = arrlenngth * target

	public int numberOfWays(int[] arr, int target){
		// return recursion(arr.length-1, arr, target);

		// int[][] dp = new int[arr.length][target+1];
		// return memoization(arr.length-1, arr, target, dp);

		// return tabulation(arr, target, dp);

		return spaceOptimization(arr, target);
	}

	// Time: O(exponnential), Space: O(>>>n)
	public int recursion(int index, int[] arr, int target){

		if(index == 0){
			return target % arr[index] == 0? 1 : 0;
		}

		int notTake = recursion(index-1, arr, target);
		int take = arr[index] <= target ? recursion(index, arr, target - arr[index]) : 0;


		return take + notTake;
	}


	// Time: O(n), Space: O(n+n)
	public int memoization(int index, int[] arr, int target, int[][] dp){

		if(index == 0){
			return target % arr[index] == 0? 1 : 0;
		}

		if(dp[index][target] != 0) return dp[index][target];

		int notTake = memoization(index-1, arr, target, dp);
		int take = arr[index] <= target ? memoization(index, arr, target-arr[index], dp) : 0;

		return dp[index][target] = take + notTake;
	}


	// Time: O(n), Space: O(n)
	private int tabulation(int[] arr, int target, int[][] dp){
		for(int t=0; t<=target; t++){
			dp[0][t] = t % arr[0] == 0? 1 : 0;
		}

		for(int index=1; index<arr.length; index++){
			for(int t=0; t<=target; t++){
				int notTake = dp[index-1][t];
				int take = arr[index] <= t ? dp[index][t-arr[index]] : 0;

				dp[index][t] = take + notTake;
			}
		}

		return dp[arr.length-1][target];
	}


	// Time: O(n), Space: O(2t+1)
	private int spaceOptimization(int[] arr, int target){
		int[] prev = new int[target+1];
		int[] curr = new int[target+1];

		for(int t=0; t<=target; t++){
			prev[t] = t % arr[0] == 0? 1 : 0;
		}

		for(int index=1; index<arr.length; index++){
			for(int t=0; t<=target; t++){
				int notTake = prev[t];
				int take = arr[index] <= t ? curr[t-arr[index]] : 0;

				curr[t] = take + notTake;
			}
			prev = curr;
		}

		return prev[target];
	}


	public static void main(String[] args) {
		CoinChange2 obj = new CoinChange2();

		int[] arr = {1,2,5,10};
		System.out.println(obj.numberOfWays(arr, 18));

	}
}