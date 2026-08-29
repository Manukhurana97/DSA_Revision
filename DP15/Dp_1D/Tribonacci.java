// https://leetcode.com/problems/n-th-tribonacci-number/

public class Tribonacci {
	public int tribonacci(int n) {
        // Integer[] dp = new Integer[n+1];
        // return recursion(n, dp);

        return tabulation(n);
    }

    public int recursion(int i, Integer[] dp) {
        if(i <= 1) return i;
        if(i == 2) return 1;
        if(dp[i] != null) return dp[i];

        return dp[i] = recursion(i-1, dp) + recursion(i-2, dp) + recursion(i-3, dp);
    }

    public int tabulation(int n) {
        if(n <= 1) return n;
        if(n == 2) return 1;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }
}