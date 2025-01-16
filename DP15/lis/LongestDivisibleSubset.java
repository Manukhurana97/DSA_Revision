// https://leetcode.com/problems/largest-divisible-subset/description/

import java.util.*;

public class LongestDivisibleSubset{

	public List<Integer> getLongestDivisibleSubSet(int[] arr){
		int n = arr.length;
		Arrays.sort(arr);

		// return recursion(0, -1, arr);

		// int[][] dp = new int[n+1][n+1];
		// return memoization(0, -1, arr, dp);

		// return tabulation(arr, dp);

		// return spaceOptimization(arr);
		return spaceOptimizationPrint(arr);
	}


	private int recursion(int index, int prev, int[] arr){
		if(index == arr.length) return 0;

		int notTake = recursion(index+1, prev, arr);
		int take = 0;
		if(prev == -1 || arr[index] % arr[prev] == 0){
			take = 1 + recursion(index+1, index, arr);
		}

		return Math.max(notTake, take);
	}


	private int memoization(int index, int prev, int[] arr, int[][] dp){
		if(index == arr.length) return 0;

		if(dp[index][prev+1] != 0) return dp[index][prev+1];

		int notTake = memoization(index+1, prev, arr, dp);
		int take = 0;
		if(prev == -1 || arr[index] % arr[prev] == 0){
			take = 1 + memoization(index+1, index, arr, dp);
		}

		return dp[index][prev+1] = Math.max(notTake, take);
	}


	private int tabulation(int[] arr, int[][] dp){	
		int n = arr.length;

		for(int index = n-1; index>=0; index--){
			for(int prev = index-1; prev>=-1; prev--){
				int notTake = dp[index+1][prev+1];
				int take = 0;
				if(prev == -1 || arr[index] % arr[prev] == 0){
					take = 1 + dp[index+1][index];
				}

				dp[index][prev+1] = Math.max(notTake, take);
			}
		}

		return dp[0][0];
	}



	private int spaceOptimization(int[] arr){
		int n = arr.length;

		
		int[] next = new int[n+1];

		for(int index = n-1; index>=0; index--){
			int[] curr = new int[n+1];
			for(int prev = index-1; prev>=-1; prev--){
				int notTake = next[prev + 1];
				int take = 0;
				if (prev == -1 || arr[index] % arr[prev] == 0) {
                	take = 1 + next[index];
            	}

				curr[prev + 1] = Math.max(notTake, take);
			}

			next = curr;
		}

		return next[0];
	}


	// Time: O(n^2 + n), Space O(2n)
	private List<Integer> spaceOptimizationPrint(int[] arr){
		int maxIndex = 0, n = arr.length;
		int[] dp = new int[n]; 
		int[] hash = new int[n]; 
		Arrays.fill(dp, 1);

		for(int i=0; i<n; i++){
			hash[i] = i;
		}	

		for(int i=0; i<n; i++){
			for(int prev = 0; prev<i; prev++){
				if(arr[i] % arr[prev] == 0 && dp[i]<dp[prev] + 1){
					dp[i] = dp[prev] + 1;
					hash[i] = prev;

				}
			}
			if(dp[i] > dp[maxIndex]){
				maxIndex = i;
			}
		}


		// Backtrack to find the LIS
		List<Integer> result = new ArrayList<>();
		while(hash[maxIndex] != maxIndex){
			result.add(arr[maxIndex]);
			maxIndex = hash[maxIndex];
		}
		result.add(arr[maxIndex]);  // Add the last element

        Collections.reverse(result);

		return result;
	}


	public static void main(String[] args) {
		LongestDivisibleSubset obj = new LongestDivisibleSubset();
		int[] arr = {1, 4, 7, 8, 16};
		System.out.println(obj.getLongestDivisibleSubSet(arr));
	}
}