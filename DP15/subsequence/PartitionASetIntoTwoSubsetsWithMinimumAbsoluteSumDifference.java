// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/description/

/**
 * 
 * Tabulation: it contains the data from 0 to k , 
 * for each index Tabulation DP data contain, if we can create a subset of target (i) 
 * 
 * we can derivies if every possible target b/w 1 to k is true/false
 * */ 

public class PartitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference{

	public int minSubSetDifference(int[] arr, int n){

		int sum = 0;
		for(int i: arr) sum += i;

		boolean dp[] = tabulation(arr, sum);  

		// s1 - s2 = min(values)

		int minDiff = Integer.MAX_VALUE;
		// for all the values of s1
		for(int i=0; i<=sum/2; i++){
			if(dp[i]){
				minDiff = Math.min(minDiff, Math.abs(i - (sum - i)));
			}
		}

		return minDiff;
	}


	public boolean[] tabulation(int[] arr, int target){
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

		return dp[n-1];
	}


	public static void main(String[] args) {
		PartitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference obj = new PartitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference();
		int[] arr = {1,2,3,4};
		System.out.println(obj.minSubSetDifference(arr, arr.length));
	}
}