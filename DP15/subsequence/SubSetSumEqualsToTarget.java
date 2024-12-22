public class SubSetSumEqualsToTarget{

	private boolean subsetSumEqualsK(int target, int[] arr){

		// return recursion(arr.length-1, target, arr);

		// Boolean[][] dp = new Boolean[arr.length][target+1];
		// return memoization(arr.length-1, target, arr, dp);

		// return tabulation(target, arr);

		return spaceOptimize(target, arr);
	}


	private boolean recursion(int index, int target, int[] arr){
		f(target == 0) return  true;
		if(index == 0) return target == arr[0];


		boolean nottake = recursion(index-1, target, arr);
		boolean take = (target<arr[index] ? false : recursion(index-1, target-arr[index], arr));

		return take || nottake;
	}


	private boolean memoization(int index, int target, int[] arr, Boolean[][] dp){
		f(target == 0) return  true;
		if(index == 0) return target == arr[0];

		if (dp[index][target] != null) return dp[index][target];


		boolean nottake = memoization(index-1, target, arr, dp);
		boolean take = (target<arr[index] ? false : memoization(index-1, target-arr[index], arr, dp));

		return dp[index][target] =  take || nottake;
	}


	private boolean tabulation(int target, int[] arr){
		int n = arr.length;
		boolean[][] dp = new boolean[arr.length][target+1];

		// Base case: target == 0 is always true
		for (int i = 0; i < n; i++) {
	        dp[i][0] = true;
	    }

		// Base case: for the first index, only arr[0] can contribute to achieving the sum
		if(arr[0] <= target){
			dp[0][arr[0]] = true;
		}


		for (int index = 1; index < n; index++) {
			for(int t = 1; t<=target; t++){
				boolean nottake = dp[index-1][t];
				boolean take = (t<arr[index] ? false : dp[index-1][t-arr[index]]);
	
				dp[index][t] =  take || nottake;
			}
		}

		return dp[arr.length-1][target];
	}



	private boolean spaceOptimize(int target, int[] arr){
		int n = arr.length;
		boolean[] prev = new boolean[target+1];
		boolean[] curr = new boolean[target+1];

		// Base case: target == 0 is always true
		prev[0] = curr[0] = true;

		// Base case: for the first index, only arr[0] can contribute to achieving the sum
		if (arr[0] <= target) 
			curr[arr[0]] = true;

		for (int index = 1; index < n; index++) {
			for(int t = 1; t<=target; t++){
				boolean nottake = prev[t];
				boolean take = (t<arr[index] ? false : prev[t-arr[index]]);
	
				curr[t] =  take || nottake;
			}
			prev = curr;
		}

		return curr[target];
	}


	
	public static void main(String[] args) {
		SubSetSumEqualsToTarget obj = new SubSetSumEqualsToTarget();

		int[] arr = {2,1,5,9};
		System.out.println(obj.subsetSumEqualsK(15, arr));
	}
}