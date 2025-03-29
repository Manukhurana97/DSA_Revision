// bitonic : increasing, decreasing, increasing & decreasing

import java.util.*;

// using LIS Tabulation
public class LongestBitonicSubsequence{

	private int getLongestSequence(int[] arr){

		int n = arr.length;
		int[] dp1 = tabulation1(arr);
		int[] dp2 =	tabulation2(arr);

		int max = 0;
		for(int i=0; i<n; i++){
			max = Math.max(max, dp1[i] + dp2[i] - 1);
		}

		return max;
	}

	
	private int[] tabulation1(int[] arr){
		
		int[] dp = new int[arr.length+1];
		Arrays.fill(dp, 1);

		for(int index=0; index<arr.length; index++){
			for(int prev = 0; prev<index;prev++){
				if(arr[prev] < arr[index] && dp[index]<dp[prev]+1){
					dp[index] = dp[prev]+1;
				}
			}
		}
		return dp;
	}

	private int[] tabulation2(int[] arr){
		
		int[] dp = new int[arr.length+1];
		Arrays.fill(dp, 1);

		for (int index = arr.length - 2; index >= 0; index--) {
            for (int prev = arr.length - 1; prev > index; prev--) {
				if(arr[prev] < arr[index] && dp[index]<dp[prev]+1){
					dp[index] = dp[prev]+1;
				}
			}
		}
		return dp;
	}


	public static void main(String[] args) {
		LongestBitonicSubsequence obj = new LongestBitonicSubsequence();
		int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
		System.out.println(obj.getLongestSequence(arr));
	}
}