// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

import java.util.*; 

public class MinimumCostToCutTheStick{

	private int minCost(int n, int c, int[] arr){
		List<Integer> cuts = new ArrayList<>();
        for (int i : arr) cuts.add(i);
        cuts.add(0);  // Start of the stick
        cuts.add(n);  // End of the stick
		Collections.sort(cuts);

		// return recursion(1, c, cuts);

		int[][] dp = new int[c+2][c+2];
		 for (int[] row : dp) Arrays.fill(row, 0);

		// return memoization(1, c, cuts, dp);

		return tabulation(c, cuts, dp);
	}

	private int recursion(int i, int j, List<Integer> arr){
		if(i>j) return 0;

		int min = Integer.MAX_VALUE;

		for(int ind=i; ind<=j; ind++){
			int cost = arr.get(j+1) - arr.get(i-1) + recursion(i, ind-1, arr) + recursion(ind+1, j, arr);
			 min = Math.min(min, cost);
		}

		return min;
	}


	private int memoization(int i, int j, List<Integer> arr, int[][] dp){
		if(i>j) return 0;


		if(dp[i][j] != 0) return dp[i][j];

		int min = Integer.MAX_VALUE;

		for(int ind=i; ind<=j; ind++){
			int cost = arr.get(j+1) - arr.get(i-1) + memoization(i, ind-1, arr, dp) + memoization(ind+1, j, arr, dp);
			 min = Math.min(min, cost);
		}

		dp[i][j] = min;
		return min;
	}


	// Time: O(N^3), Space: O(n) 
	private int tabulation(int c, List<Integer> arr, int[][] dp){

		for(int i=c; i>=1; i--){
			for(int j=1; j<=c; j++){
				if(i>j) continue;
				int min = Integer.MAX_VALUE;
		
				for(int ind=i; ind<=j; ind++){
					int cost = arr.get(j+1) - arr.get(i-1) + dp[i][ind-1]+ dp[ind+1][j];
					 min = Math.min(min, cost);
				}
		
				dp[i][j] = min;
			}
		}

		return dp[1][c];
	}

	public static void main(String[] args) {
		MinimumCostToCutTheStick obj = new MinimumCostToCutTheStick();
		int[] arr = {1, 3, 4, 5};
		System.out.println(obj.minCost(7, arr.length, arr));
	}
}