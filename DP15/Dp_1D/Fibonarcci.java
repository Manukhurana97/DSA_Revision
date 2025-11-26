// https://leetcode.com/problems/fibonacci-number/

import java.util.*;

public class Fibonarcci{

	public void getFibonacciSeries(int n){

		int[] dp = new int[n+1];
		List<Integer> result = new ArrayList<>();

		for(int i=0; i<n; i++){
			result.add(memoization(i, dp));
			// result.add(tabulation(i, dp));
			// result.add(spaceOptimization(i));
		}

		System.out.println(result);
	}


	private int memoization(int n, int[] dp){
		if (n <= 1) return n;

		if (dp[n] != 0) return dp[n];

		dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
		return dp[n];
	}


	private int tabulation(int n, int[] dp){
		if (n == 0) dp[0] = 0;
        if (n == 1) dp[1] = 1;

        for(int i=2; i<n; i++){
        	dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n-1];
	}

	private int spaceOptimization(int n) {
        int prev2 = 1, prev1 = 1, current = 0;

        for(int i=2; i<n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }



	public static void main(String[] args) {
		Fibonarcci obj = new Fibonarcci();
		obj.getFibonacciSeries(5);
	}
}