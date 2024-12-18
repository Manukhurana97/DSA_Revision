/* 
count the ways, find way with min/max output :: recursion can be applied

1. try to represent everything in terms of index
2. do all possible stuff on that index, acc to prob statement
3. sum all the stuff: if question ask for sum, 
   count all the stuff: if question ask for count

*/


public class CountNumberOfStair{
	public int countDistinctyWayToClimbStairs(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;

		// return recusionDFS(n);

		// int[] dp = new int[n+1];
		// return dpMemoization(n, dp);

		// return dpTabulation(n, dp);
		return spaceOptimization(n);
	}

	// time : O(n^2), Space: O(n+n{recursion space})
	private int recusionDFS(int n){
		if(n == 0) return 1;
		if(n < 0) return 0;

		return recusionDFS(n-1) + recusionDFS(n-2);
	}

	// time : O(n), Space: O(n+n{recursion space})
	private int dpMemoization(int n, int[] dp){
		if(n == 0) return 1;
		if(n < 0) return 0;

		if(dp[n] != 0) return dp[n];

		dp[n] = dpMemoization(n-1, dp) + dpMemoization(n-2, dp);
		return dp[n];
	}

	// time : O(n), Space: O(n)
	public int dpTabulation(int n, int[] dp){
		dp[0] = 1;

		for(int i=1; i<=n; i++){
			dp[i] = dp[i - 1] + (i-2 < 0 ? 0 : dp[i - 2]);

		}
		return dp[n];
	}

	// time : O(n), Space: O(1)
	public int spaceOptimization(int n){
		if(n == 0) return 0;

		int prev1 = 1;
		int prev2 = 0;

		for(int i=1; i<=n; i++){
			int current  = prev1 + prev2;
			prev2 = prev1;
			prev1 = current;
		}

		return prev1;
	}

	public static void main(String[] args) {
		CountNumberOfStair obj = new CountNumberOfStair();
		System.out.println(obj.countDistinctyWayToClimbStairs(5));
	}
}