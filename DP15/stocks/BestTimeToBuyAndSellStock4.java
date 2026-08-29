// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

public class BestTimeToBuyAndSellStock4 {
	public int maxProfit(int k, int[] prices) {
        // Integer[][][] dp = new Integer[prices.length][2][k+1];
        // return recursion(0, true, prices, k, dp);

        // return tabulation(prices, k);

        return spaceOptimization(prices, k);
    }

    public int recursion(int i, boolean canBuy, int[] prices, int k, Integer[][][] dp) {
        if(i == prices.length) return 0;
        if(k <= 0) return 0;

        if(dp[i][canBuy?1:0][k] != null) return dp[i][canBuy?1:0][k];

        if(canBuy) {
            return dp[i][canBuy?1:0][k] = Math.max(-prices[i] + recursion(i+1, false, prices, k, dp), recursion(i+1, true, prices, k, dp));
        } else {
            return dp[i][canBuy?1:0][k] = Math.max(prices[i] + recursion(i+1, true, prices, k-1, dp), recursion(i+1, false, prices, k, dp));
        }
    }

    public int tabulation(int[] prices, int t) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][t+1];

        for(int i=n-1; i>=0; i--) {
            for(int k=1; k<=t; k++){
                dp[i][1][k] = Math.max(-prices[i] + dp[i+1][0][k], dp[i+1][1][k]);
                dp[i][0][k] = Math.max(prices[i] + dp[i+1][1][k-1], dp[i+1][0][k]);
            }
        }

        return dp[0][1][t];
    }

    public int spaceOptimization(int[] prices, int t) {
        int n = prices.length;
        int[][] prev = new int[2][t+1];
        int[][] curr = new int[2][t+1];


        for(int i=n-1; i>=0; i--) {            
            for(int k=1; k<=t; k++){
                curr[1][k] = Math.max(-prices[i] + prev[0][k], prev[1][k]);
                curr[0][k] = Math.max(prices[i] + prev[1][k-1], prev[0][k]);

                prev = curr;
            }
        }

        return prev[1][t];
    }
}