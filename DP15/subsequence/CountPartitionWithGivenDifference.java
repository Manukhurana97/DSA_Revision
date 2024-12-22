// use of CountSubSetsWithSumK : tabution

public class CountPartitionWithGivenDifference{

	public boolean countParitions(int[] arr, int d){
		int sum = 0;
		for(int i: arr) sum+=i;

	    // If (sum - d) is negative or not even, partition is not possible
		if (sum - d < 0 || (sum - d) % 2 != 0) return false;

		int target = (sum - d)/2;

		int[] dp = numberOfSubsetWithSumK(arr, target);

	}


	public int numberOfSubsetWithSumK(int[] arr, int k){
		return recursion(arr.length-1, k, arr);
	}


	// time: O(2^n), Space (n{stack space})
	public int recursion(int index, int target, int[] arr){

		if(index == 0){
			if(target == 0 && arr[0] == 0) return 2;
			if(target == 0 ||  arr[index] == target) return 1;
			return 0;
		}

		int notTake = recursion(index-1, target, arr);
		int take = target < arr[index] ? 0 : recursion(index-1, target-arr[index], arr);

		return take + notTake;
	}

}