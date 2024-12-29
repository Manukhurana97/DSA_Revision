/**
 * Rules for partition Dp: (solve a problem in a pattern) (there are multiple ways to solve and ask for the best way to solve)
 * 
 * 	1. start with entire block / array, always represent by (i {start}, j{points})
 * 		1.1 Base case: when (i == j): no of operation will be zero;
 * 	2. try all partitions. (run a loop to try all partitions)
 * 	3. return best possible partitions
 * */ 

public class MatrixMultiplicationChain{

	private  int matrixmultiplication(int[] arr, int n){

		// return recursion(1, n-1, arr);

		int[][] dp = new int[n][n];
		// return memoization(1, n-1, arr, dp);
		
		return tabulations(arr, dp);
	}

	
	private int recursion(int i, int j, int[] arr){

		if(i == j) return 0;

		int minSum = Integer.MAX_VALUE;

		// Try all possible partitions between i and j
		for(int k=i; k<j; k++){ //O(~N)
			// Calculate cost for splitting at k
			int step = arr[i-1] * arr[k] * arr[j] + recursion(i, k, arr) + recursion(k+1, j, arr); //O(N^2)

			minSum = Math.min(minSum, step);
		}

		return minSum;
	}


	// Time: O(N^3), Space: O(2N)
	private int memoization(int i, int j, int[] arr, int[][] dp){

		if(i == j) return 0;

		int minSum = Integer.MAX_VALUE;

		if(dp[i][j] != 0) return dp[i][j];

		// Try all possible partitions between i and j
		for(int k=i; k<j; k++){
			// Calculate cost for splitting at k
			int step = arr[i-1] * arr[k] * arr[j] + memoization(i, k, arr, dp) + memoization(k+1, j, arr, dp);

			minSum = Math.min(minSum, step);
		}

		return dp[i][j] = minSum;
	}


	// Time: O(N^3), Space: O(N)
	private int tabulations(int[] arr, int[][] dp){
		int n = arr.length;

		for(int i=n-1; i>=1; i--){
			for(int j=i+1; j<n; j++){

				int minSum = Integer.MAX_VALUE;
				// Try all possible partitions between i and j
				for(int k=i; k<j; k++){
					// Calculate cost for splitting at k
					int step = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];

					minSum = Math.min(minSum, step);
				}

				dp[i][j] = minSum;
			}
		}

		return dp[1][n-1];
	}

	public static void main(String[] args) {
		MatrixMultiplicationChain obj = new MatrixMultiplicationChain();
		int[] arr = {10, 20, 30, 40, 50};
		System.out.println(obj.matrixmultiplication(arr, arr.length));
	}
}  