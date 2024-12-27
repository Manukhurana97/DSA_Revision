/* extension of LongestIncreasingSubSequence */

import java.util.*;

public class PrintLongestIncreasingSubSequence{

	public List<Integer> longestIncSubSequence(int[] arr){

		// return recurssion(0, -1, arr);

		// int[][] dp = new int[arr.length+1][arr.length+1];
		// for(int[] row: dp){
		// 	Arrays.fill(row, -1);
		// }

		// return memoization(0, -1, arr, dp);

		// return tabulation(arr, dp);

		// return spaceOptimization(arr);

		return tabulationPrint(arr);
	}


	private int recurssion(int index, int prev, int[] arr){
		if(index == arr.length) return 0;

		int  nottake = recurssion(index+1, prev, arr);

		int take = 0;
		if(prev == -1 || arr[index]>arr[prev]){
			take =  1 + recurssion(index+1, index, arr);
		}
		

		return Math.max(take, nottake);
	}


	private int memoization(int index, int prev, int[] arr, int[][] dp){
		if(index == arr.length) return 0;

		if(dp[index][prev+1] != -1) return dp[index][prev+1];

		int  nottake = memoization(index+1, prev, arr, dp);

		int take = 0;
		if(prev == -1 || arr[index]>arr[prev]){
			take =  1 + memoization(index+1, index, arr, dp);
		}
		

		return dp[index][prev+1] = Math.max(take, nottake);
	} 


	private int tabulation(int[] arr, int[][] dp){
		int n = arr.length;

		for(int index = n-1; index>=0; index--){
			// since prev is till -1, we will increment + 1 for prev field
			for(int prev = index-1; prev>=-1; prev--){
				int  notTake = dp[index+1][prev+1];

				int take = 0;
				if(prev == -1 || arr[index]>arr[prev]){
					take =  1 + dp[index+1][index+1];
				}

				dp[index][prev + 1] = Math.max(take, notTake);
			}
		}
		
		

		return dp[0][-0];
	} 




	// Time : O(n^2), space: O(n)

	private List<Integer> tabulationPrint(int[] arr){
		int maxIndex = 0, n = arr.length;
		int[] dp = new int[n]; 
		int[] hash = new int[n]; 
		Arrays.fill(dp, 1);

		for(int i=0; i<n; i++){
			hash[i] = i;
		}

		for(int i=0; i<n; i++){
			for(int prev = 0; prev<i; prev++){
				if(arr[prev] < arr[i] && dp[i]<dp[prev] + 1){
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
		PrintLongestIncreasingSubSequence obj = new PrintLongestIncreasingSubSequence();
		int[] arr = {10, 9, 2, 5, 3, 7,101, 102, 103, 104, 17,18,19};
		System.out.println(obj.longestIncSubSequence(arr));
	}
}