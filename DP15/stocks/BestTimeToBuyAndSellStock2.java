// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

// can buy and sell stock multiple times
public class BestTimeToBuyAndSellStock2{

	private int maxProfit(int[] arr){

		// return recursion(0, true, arr);
		int[][] dp = new int[arr.length+1][2];
		// return memoization(0, true, arr,  dp);

		// return tabulation(arr,  dp);

		return spaceOptimization(arr);
	}

	/**
	 * 1. express everything in teams of index
	 * 2. explore all possibilities
	 * 3. sum/min/max/...
	 * 4. base case
	 * 
	 * */
	private int recursion(int index, boolean canBuy, int[] arr){
		if(index == arr.length) return 0;

		int profit = 0;
		if(canBuy){	// max(buy, notBuy)
			profit = Math.max(-arr[index] + recursion(index+1, false, arr), recursion(index+1, true, arr));
		}
		else{ // max(sell, notSell)
			profit = Math.max(+arr[index] + recursion(index+1, true, arr), recursion(index+1, false, arr));
		}

		return profit;
	}


	private int memoization(int index, boolean canBuy, int[] arr, int[][] dp){
		if(index == arr.length) return 0;

		if(dp[index][canBuy ? 1 : 0] != 0) return dp[index][canBuy ? 1 : 0];

		int profit = 0;
		if(canBuy){	// max(buy, notBuy)
			profit = Math.max(-arr[index] + memoization(index+1, false, arr, dp), memoization(index+1, true, arr, dp));
		}
		else{ // max(sell, notSell)
			profit = Math.max(+arr[index] + memoization(index+1, true, arr, dp), memoization(index+1, false, arr, dp));
		}

		return dp[index][canBuy ? 1 : 0] = profit;
	}


	/**
	 * 1. base case
	 * 2. changing parameters to loop
	 * 3. copy the recurance 
	 * */
	private int tabulation(int[] arr, int[][] dp){
		int n = arr.length;

		dp[n][0] = dp[n][1] = 0;

		for(int index=n-1; index>=0; index--){
			for(int canBuy = 0; canBuy<2; canBuy++){
				int profit = 0;
				if(canBuy == 1){ // max(buy, notBuy)
					profit = Math.max(-arr[index] + dp[index+1][0], dp[index+1][1]);
				}
				else{ // max(sell, notSell)
					profit = Math.max(+arr[index] + dp[index+1][1], dp[index+1][0]);
				}

				dp[index][canBuy] = profit;
			}
		}

		return dp[0][1];
	}


	// time : O(n), Space: O(1)
	private int spaceOptimization(int[] arr){
		int n = arr.length;

		int[] prev = new int[2];
		int[] curr = new int[2];

		prev[0] = curr[0] = 0;

		for(int index=n-1; index>=0; index--){
			for(int canBuy = 0; canBuy<2; canBuy++){
				int profit = 0;
				if(canBuy == 1){ // max(buy, notBuy)
					profit = Math.max(-arr[index] + prev[0], prev[1]);
				}
				else{ // max(sell, notSell)
					profit = Math.max(+arr[index] + prev[1], prev[0]);
				}

				curr[canBuy] = profit;
			}
			prev = curr;
		}

		return prev[1];
	}



	public static void main(String[] args) {
		BestTimeToBuyAndSellStock2 obj =new BestTimeToBuyAndSellStock2();
		int[] arr = {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(arr));
	}
}