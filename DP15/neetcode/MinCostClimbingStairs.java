// https://leetcode.com/problems/min-cost-climbing-stairs/description/

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] costs) {
        int n = costs.length;
        int[] dp = new int[n+1];

        // return Math.min(recursion(n-1, costs, dp), recursion(n-2, costs, dp));

        // return Math.min(tabulation(n-1, costs, dp), tabulation(n-2, costs, dp));


        return spaceOptimization(n, costs);

        
    }

    private int recursion(int n, int[] costs, int[] dp){
        if(n==0 || n==1) return costs[n];

        if(dp[n] != 0) return dp[n];
        
        return dp[n] = costs[n] + Math.min(recursion(n-1, costs, dp), recursion(n-2, costs, dp));
    }


    private int tabulation(int n, int[] costs, int[] dp){
        dp[0] = costs[0];
        dp[1] = costs[1];

        for(int i=2; i<=n; i++)
            dp[i] = costs[i] + Math.min(dp[i-1], dp[i-2]);

        return dp[n];
    }

    
    private int spaceOptimization(int n, int[] costs){
        int prev2 = costs[0], prev1 = costs[1];

        for (int i = 2; i < n; i++) {
            int current = costs[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }

        // The result is the minimum cost to reach the top from either of the last two steps
        return Math.min(prev1, prev2);
    }
    
}