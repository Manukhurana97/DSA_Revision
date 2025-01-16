// https://leetcode.com/problems/partition-array-for-maximum-sum/submissions/1510345582/

public class PartitionArrayForMaxSum{
	
	private int maxSum(int[] arr, int k){
		// return recursion(0, k, arr);

		int[] dp = new int[arr.length+1];
		// return memoization(0, k, arr, dp);

		return tabulation(k, arr, dp);
	}

	private int recursion(int i, int k, int[] arr){
		if(i>=arr.length) return 0;

		int len = 0, maxVal = 0, maxAns = 0;
		for(int ind = i; ind<Math.min(arr.length, i+k); ind++){ // will create partition at each element , max element in partition is k
			len+=1; // len of partition
			maxVal = Math.max(maxVal, arr[ind]); // max Element in partition

			int sum = (len * maxVal) + recursion(ind+1, k, arr);
			maxAns = Math.max(maxAns, sum);
		}

		return maxAns;
	}


	private int memoization(int i, int k, int[] arr, int[] dp){
		if(i>=arr.length) return 0;

		if(dp[i] != 0) return dp[i];

		int len = 0, maxVal = 0, maxAns = 0;
		for(int ind = i; ind<Math.min(arr.length, i+k); ind++){
			len+=1;
			maxVal = Math.max(maxVal, arr[ind]);

			int sum = (len * maxVal) + memoization(ind+1, k, arr, dp);
			maxAns = Math.max(maxAns, sum);
		}

		return dp[i] = maxAns;
	}


	private int tabulation(int k, int[] arr, int[] dp){
		
		for(int i=arr.length-1; i>=0; i--){
			int len = 0, maxVal = 0, maxAns = 0;
			for(int ind = i; ind<Math.min(arr.length, i+k); ind++){
				len+=1;
				maxVal = Math.max(maxVal, arr[ind]);
	
				int sum = (len * maxVal) + dp[ind+1];
				maxAns = Math.max(maxAns, sum);
			}
	
			dp[i] = maxAns;
		}

		return dp[0];
	}


	public static void main(String[] args) {
		PartitionArrayForMaxSum obj =new PartitionArrayForMaxSum();
		int[] arr = {1, 15, 7, 9, 2, 5, 10};
		System.out.println(obj.maxSum(arr, 3));
	}
}
