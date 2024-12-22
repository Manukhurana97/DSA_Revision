public class CountSubSetsWithSumK{
	public int numberOfSubsetWithSumK(int[] arr, int k){
		// return recursion(arr.length-1, k, arr);

		int[][] memo = new int[arr.length][k+1];
		// return memoization(arr.length-1, k, arr, memo);

		// return tabulation(k, arr, memo);

		return spaceOptimization(k, arr);
	}


	// time: O(2^n), Space (n{stack space})
	public int recursion(int index, int target, int[] arr){

		if(target == 0) return 1;
		if(index == 0){
			return arr[index] == target ? 1: 0;
		}

		int notTake = recursion(index-1, target, arr);
		int take = target < arr[index] ? 0 : recursion(index-1, target-arr[index], arr);

		return take + notTake;
	}

	// for input containing 0
	public int recursion1(int index, int target, int[] arr){

		if(index == 0){
			if(target == 0 && arr[0] == 0) return 2;
			if(target == 0 ||  arr[index] == target) return 1;
			return 0;
		}

		int notTake = recursion(index-1, target, arr);
		int take = target < arr[index] ? 0 : recursion(index-1, target-arr[index], arr);

		return take + notTake;
	}


	// time: O(n), Space (n + n{stack space})
	public int memoization(int index, int target, int[] arr, int[][] memo){

		if(target == 0) return 1;
		if(index == 0){
			return arr[index] == target ? 1: 0;
		}

		if(memo[index][target] != 0) return memo[index][target];

		int notTake = memoization(index-1, target, arr, memo);
		int take = target < arr[index] ? 0 : memoization(index-1, target-arr[index], arr, memo);

		return memo[index][target] = take + notTake;
	}


	/**
	 * 1. Base Case
	 * 2. Look At the chaning  and write nested loop
	 * 3. copy the recursion
	 * 
	 * */
	public int tabulation(int target, int[] arr, int[][] memo){
		int n = arr.length;

		for(int index=0; index<n; index++){
			memo[index][0] = 1;
		}

		memo[0][arr[0]] = 1;

		for(int index = 1; index<n; index++){
			for(int t = 0; t<=target; t++){
				int notTake = memo[index-1][t];
				int take = t < arr[index] ? 0 : memo[index-1][t-arr[index]];

				memo[index][t] = take + notTake;
			}
		}

		return memo[n-1][target];
	}


	// for input containing 0
	public int tabulation1(int target, int[] arr, int[][] memo){
		int n = arr.length;

		if(arr[0] == 0) memo[0][0] = 2;
		else memo[0][0] = 1;

		if(arr[0] != 0) memo[0][arr[0]] = 1;

		for(int index = 1; index<n; index++){
			for(int t = 0; t<=target; t++){
				int notTake = memo[index-1][t];
				int take = t < arr[index] ? 0 : memo[index-1][t-arr[index]];

				memo[index][t] = take + notTake;
			}
		}

		return memo[n-1][target];
	}

	public int spaceOptimization(int target, int[] arr){
		int n = arr.length;

		int[] prev = new int[target+1];
		int[] curr = new int[target+1];

		prev[0] = curr[0] = 1;
		prev[arr[0]] = 1;


		for(int index = 1; index<n; index++){
			for (int t = 0; t <= target; t++) {
				int notTake = prev[t];
                int take = t < arr[index] ? 0 : prev[t - arr[index]];

				curr[t] = take + notTake;
			}
			prev = curr;
		}

		return prev[target];
	}

	public static void main(String[] args) {
		CountSubSetsWithSumK obj = new CountSubSetsWithSumK();

		int[] arr = {1,2,2,3};
		System.out.println(obj.numberOfSubsetWithSumK(arr, 3));
	}
}