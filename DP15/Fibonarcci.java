import java.util.*;

public class Fibonarcci{

	public void getFibonacciSeries(int n){

		int[] dp = new int[n+1];
		List<Integer> result = new ArrayList<>();

		for(int i=0; i<n; i++){
			// result.add(memoization(i, dp));
			// result.add(tabulation(i, dp));
			result.add(spaceOptimization(i));
		}

		System.out.println(result);
	}


	private int memoization(int n, int[] dp){
		if (n == 0) return 0;
        if (n == 1) return 1;

		if (dp[n] != 0) return dp[n];


		dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
		return dp[n];
	}


	private int tabulation(int n, int[] dp){
		if (n == 0) dp[0] = 0;
        if (n == 1) dp[1] = 1;

        for(int i=2; i<=n; i++){
        	dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
	}

	private int spaceOptimization(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;

		int prev = 0;
		int current = 1;

		for(int i=2; i<=n;i++){
			int temp = current;
			current += prev;
			prev = temp;
		}

		return current;
	}



	public static void main(String[] args) {
		Fibonarcci obj = new Fibonarcci();
		obj.getFibonacciSeries(5);
	}
}