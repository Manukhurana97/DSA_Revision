// at max 2 transactions (2 times buy and sell)
public class BestTimeToBuyAndSellStock3{

	private int maxProfit(int[] arr, int k){
		if(k==0) return 0;

		// return recursion(0, true, arr, k);

		int[][][] dp = new int[arr.length+1][2][k+1];
		// return memoization(0, true, arr, k, dp);

		// return tabulation(arr, k, dp);

		return spaceOptimization(arr, k);
	}


	/**
	 * 1. represent everything in terms of index
	 * 2. explore all possibilities
	 * 3, return max profit
	 * 4. base case
	 * */
	private int recursion(int index, boolean canBuy, int[] arr, int transactionLeft){
		if(index == arr.length) return 0;

		if(transactionLeft == 0) return 0;

		int profit = 0;
		if(canBuy){
			profit = Math.max(-arr[index] + recursion(index+1, false, arr, transactionLeft), recursion(index+1, true, arr, transactionLeft));
		}else{
			profit = Math.max(arr[index] + recursion(index+1, true, arr, transactionLeft-1), recursion(index+1, false, arr, transactionLeft));
		}

		return profit;
	}


	private int memoization(int index, boolean canBuy, int[] arr, int transactionLeft, int[][][] dp){
		if(index == arr.length) return 0;

		if(transactionLeft == 0) return 0;

		if(dp[index][canBuy ? 1 : 0][transactionLeft] != 0) return dp[index][canBuy ? 1 : 0][transactionLeft];

		int profit = 0;
		if(canBuy){
			profit = Math.max(-arr[index] + memoization(index+1, false, arr, transactionLeft, dp), memoization(index+1, true, arr, transactionLeft, dp));
		}else{
			profit = Math.max(arr[index] + memoization(index+1, true, arr, transactionLeft-1, dp), memoization(index+1, false, arr, transactionLeft, dp));
		}

		return dp[index][canBuy ? 1 : 0][transactionLeft] = profit;
	}


	/**
	 * 1. base case
	 * 2. changing parameter to loop
	 * 3. copy recurrence
	 * 
	 * */
	private int tabulation(int[] arr, int k, int[][][] dp){
		int n = arr.length;

		for(int index=n-1; index>=0; index--){
			for(int canBuy = 0; canBuy<2; canBuy++){
				for(int transactionLeft=1; transactionLeft<=k; transactionLeft++){
					int profit = 0;
					if(canBuy==1){
						profit = Math.max(-arr[index] + dp[index+1][0][transactionLeft], dp[index+1][1][transactionLeft]);
					}else{
						profit = Math.max(arr[index] + dp[index+1][1][transactionLeft-1], dp[index+1][0][transactionLeft]);
					}

					dp[index][canBuy][transactionLeft] = profit;
				}
			}
		}
		
		return dp[0][1][k];
	}


	private int spaceOptimization(int[] arr, int k){
		int n = arr.length;

		int[][] next = new int[2][k+1];
		int[][] curr = new int[2][k+1];

		for(int index=n-1; index>=0; index--){
			for(int canBuy = 0; canBuy<2; canBuy++){
				for(int transactionLeft=1; transactionLeft<=k; transactionLeft++){
					int profit = 0;
					if(canBuy==1){
						profit = Math.max(-arr[index] + next[0][transactionLeft], next[1][transactionLeft]);
					}else{
						profit = Math.max(arr[index] + next[1][transactionLeft-1], next[0][transactionLeft]);
					}

					curr[canBuy][transactionLeft] = profit;
				}
			}
			next = curr.clone();
		}
		
		return next[1][k];
	}


	

 
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock3 obj =new BestTimeToBuyAndSellStock3();
		int[] arr = {7,1,5,3,60,4,10,10,30};
		System.out.println(obj.maxProfit(arr, 2));
	}
}