public class PartialEqualSubSetSum{
	private boolean canPartition(int[] arr){
		int sum = 0;
		for(int i: arr) sum+=i;
		
		if(sum%2 != 0) return false;

		return recursion(arr.length-1, arr, sum/2);

		// Boolean[][] dp = new Boolean[arr.length][sum/2+1];
		// return memoization(arr.length-1, arr, sum/2, dp);

		// return tabulation(arr, sum/2);

		// return spaceOptimization(arr, sum/2);
	}


	public boolean recursion(int index, int[] arr, int target){
		if(target == 0) return  true;
		if(index == 0) return target == arr[0];

		boolean notTake = recursion(index-1, arr, target);
		boolean take = target < arr[index] ? false : recursion(index-1, arr, target-arr[index]);

		return notTake || take;
	}


	public boolean memoization(int index, int[] arr, int target, Boolean[][] dp){
		if(target == 0) return  true;
		if(index == 0) return target == arr[0];

		if(dp[index][target] != null) return dp[index][target];

		boolean notTake = memoization(index-1, arr, target, dp);
		boolean take = target < arr[index] ? false : memoization(index-1, arr, target-arr[index], dp);

		return dp[index][target] = notTake || take;
	}


	public boolean tabulation(int[] arr, int target){
		int n = arr.length;
		boolean[][] dp = new boolean[n][target+1];

		for(int i=0; i<n; i++){
			dp[i][0] = true;
		}

		if(arr[0] <= target){
			dp[0][arr[0]] = true;
		}

		for(int index=1; index<n; index++){
			for(int t=1; t<=target; t++){
				boolean notTake = dp[index-1][t];
				boolean take = t < arr[index] ? false : dp[index-1][t-arr[index]];

				dp[index][t] = notTake || take;
			}
		}

		return dp[n-1][target];
	}


	public boolean spaceOptimization(int[] arr, int target){
		int n = arr.length;
		boolean[] curr = new boolean[target+1];
		boolean[] prev = new boolean[target+1];

		for(int i=0; i<n; i++){
			curr[0] = true;
		}

		if(arr[0] <= target){
			curr[arr[0]] = true;
		}

		for(int index=1; index<n; index++){
			for(int t=1; t<=target; t++){
				boolean notTake = prev[t];
				boolean take = t < arr[index] ? false : prev[t-arr[index]];

				curr[t] = notTake || take;
			}
			prev = curr;
		}

		return prev[target];
	}

	public static void main(String[] args) {
		PartialEqualSubSetSum obj = new PartialEqualSubSetSum();
		int[] arr = {2,3,3,3,4,5};
		System.out.println(obj.canPartition(arr));
	}
}