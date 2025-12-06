// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

public class BestTimeToBuyAndSellStockWithTransactionFee{

	private int getProfit(int[] arr, int fee){
		// return recursion(0, true, arr, fee);

		int[][] dp = new int[arr.length+1][2];
		// return memoization(0, true, arr, fee, dp);

		// return tabulation(arr, fee, dp);

		return spaceOptimization(arr, fee);
	}

	/**
	 * 1. Express everything in teams of index
	 * 2. Explore all possibilites
	 * 3. Return min/max/sum
	 * 4. Base case
	 * */
	private int recursion(int index, boolean canBuy, int[] arr, int fee){
		if(index == arr.length) return 0;

		if(canBuy){
			return Math.max(-arr[index] + recursion(index+1, false, arr, fee), recursion(index+1, true, arr, fee));
		}else{
			return Math.max(arr[index] - fee + recursion(index+1, true, arr, fee), recursion(index+1, false, arr, fee));
		}
	}

	
	private int memoization(int index, boolean canBuy, int[] arr, int fee, int[][] dp){
		if(index == arr.length) return 0;

		if(dp[index][canBuy?1:0] != 0) return dp[index][canBuy?1:0];

		if(canBuy){
			return dp[index][canBuy?1:0] = Math.max(-arr[index] + memoization(index+1, false, arr, fee, dp), memoization(index+1, true, arr, fee, dp));
		}else{
			return dp[index][canBuy?1:0] = Math.max(arr[index] - fee + memoization(index+1, true, arr, fee, dp), memoization(index+1, false, arr, fee, dp));
		}
	}


	/**
	 * 1. base case
	 * 2. convert the changing parameter in reverse loop
	 * 3. copy recurence 
	 * */
	private int tabulation(int[] arr, int fee, int[][] dp){
		int n = arr.length;

		for(int index=n-1; index>=0; index--){
			for(int canBuy=0; canBuy<2; canBuy++){
				if(canBuy==1){
					dp[index][canBuy] = Math.max(-arr[index] + dp[index+1][0], dp[index+1][1]);
				}else{
					dp[index][canBuy] = Math.max(arr[index] - fee + dp[index+1][1], dp[index+1][0]);
				}
			}
		}
		return dp[0][1];
	}


	private int spaceOptimization(int[] arr, int fee){
		int n = arr.length;
		int[] ahread = new int[2];
		int[] curr = new int[2];

		for(int index=n-1; index>=0; index--){
			for(int canBuy=0; canBuy<2; canBuy++){
				if(canBuy==1){
					curr[canBuy] = Math.max(-arr[index] + ahread[0], ahread[1]);
				}else{
					curr[canBuy] = Math.max(arr[index] - fee + ahread[1], ahread[0]);
				}
			}
			ahread = curr;
		}
		return ahread[1];
	}


	public static void main(String[] args) {
		BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();
		int[] arr = {1,3,2,8,4,9};
		System.out.println(obj.getProfit(arr, 2));
	}
}