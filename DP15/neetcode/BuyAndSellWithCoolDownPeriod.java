// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

public class BuyAndSellWithCoolDownPeriod{
	public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        // return recursion(0, true, prices, dp);
        return tabulation(n, prices, dp);
    }


    private int recursion(int i, boolean canBuy, int[] prices, int[][] dp){
        if(i >= prices.length) return 0;

        if(dp[i][canBuy ? 1 : 0] != 0) return dp[i][canBuy ? 1 : 0];

        int profit = 0;
        if(canBuy){
            profit = Math.max(-prices[i] + recursion(i+1, false, prices, dp), recursion(i+1, true, prices, dp));
        }else{
            profit = Math.max(prices[i] + recursion(i+2, true, prices, dp), recursion(i+1, false, prices, dp));
        }


        return dp[i][canBuy ? 1 : 0] = profit;
    }


    private int tabulation(int n, int[] prices, int[][] dp){
        
        for(int i=n-1; i>=0; i--){
           dp[i][1] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
           dp[i][0] = Math.max(prices[i] + dp[i+2][1], dp[i+1][0]);
        }

        return dp[0][1]; 
    }
}