// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

public class BestTimeToBuyAndSellStockCoolDown{

	public int getMaxprofit(int[] arr){
		// return recursion(0, true, arr);

		int[][] dp = new int[arr.length+2][2];
		// return memoization(0, true, arr, dp);

		// return tabulation(arr, dp);
		return tabulation1(arr, dp);
	}


	/**
	 * 1. express everything in tearms of index
	 * 2. explore all possibilities
	 * 3. return sum/max/min/....
	 * 4. base case
	 * */
	private int recursion(int index, boolean canBuy, int[] prices){
		if(index >= prices.length) return 0;

		if(canBuy){
			return Math.max(-prices[index] + recursion(index+1, false, prices), recursion(index+1, true, prices));
		}else{
			return Math.max(prices[index] + recursion(index+2, true, prices), recursion(index+1, false, prices));
		}
	}


	private int memoization(int index, boolean canBuy, int[] prices, int[][] dp){
		if(index >= prices.length) return 0;

		if(dp[index][canBuy ? 1 : 0] != 0) return dp[index][canBuy ? 1 : 0];

		if(canBuy){
			return dp[index][canBuy ? 1: 0] = Math.max(-prices[index] + memoization(index+1, false, prices, dp), memoization(index+1, true, prices, dp));
		}else{
			return dp[index][canBuy ? 1: 0] = Math.max(prices[index] + memoization(index+2, true, prices, dp), memoization(index+1, false, prices, dp));
		}
	}

	/**
	 * 1. base case
	 * 2. convert changing parameter into reverse loop
	 * 3. copy recurence 
	 * */
	private int tabulation(int[] prices, int[][] dp){
		int n = prices.length;

		for(int index=n-1; index>=0; index--){
			for(int canBuy=0; canBuy<2; canBuy++){
				if(canBuy==1){
					dp[index][canBuy] = Math.max(-prices[index] + dp[index+1][0], dp[index+1][1]);
				}else{
					dp[index][canBuy] = Math.max(prices[index] + dp[index+2][1], dp[index+1][0]);
				}
			}
		}

		return dp[0][1];
	}


	private int tabulation1(int[] prices, int[][] dp){
		int n = prices.length;

		for(int index=n-1; index>=0; index--){
			dp[index][1] = Math.max(-prices[index] + dp[index+1][0], dp[index+1][1]);
			dp[index][0] = Math.max(prices[index] + dp[index+2][1], dp[index+1][0]);
		}

		return dp[0][1];
	}


	/* space optimization is not possible/difficult are having index, index-1, index-2*/

	public static void main(String[] args) {
		BestTimeToBuyAndSellStockCoolDown obj = new BestTimeToBuyAndSellStockCoolDown();
		int[] arr = {1,5,1,10,3,12};
		System.out.println(obj.getMaxprofit(arr));
	}
}