// continuation of BestTimeToBuyAndSellStock3,  at max 2 transactions ( times buy and sell)

/* using transaction as index key*/
public class BestTimeToBuyAndSellStock4{

	private int maxProfit(int[] arr, int k){
		if(k==0) return 0;

		// return recursion(0, arr, 0, k);

		int[][] dp = new int[arr.length+1][2*k+1];
		// return memoization(0, arr, 0, k, dp);

		// return tabulation(arr, k, dp);

		return spaceOptimization(arr, k);
	}


	/**
	 * 1. represent everything in terms of index
	 * 2. explore all possibilities
	 * 3, return max profit
	 * 4. base case
	 * */
	private int recursion(int index, int[] arr, int transactionLeft, int k){
		if(index == arr.length || transactionLeft == 2*k) return 0;

		int profit = 0;
		if(transactionLeft %2==0){
			profit = Math.max(-arr[index] + recursion(index+1, arr, transactionLeft+1, k), recursion(index+1, arr, transactionLeft, k));
		}else{
			profit = Math.max(arr[index] + recursion(index+1,  arr, transactionLeft+1, k), recursion(index+1, arr, transactionLeft, k));
		}

		return profit;
	}


	private int memoization(int index, int[] arr, int transactionLeft, int k, int[][] dp){
		if(index == arr.length || transactionLeft == 2*k) return 0;

		if(dp[index][transactionLeft] != 0) return dp[index][transactionLeft];

		int profit = 0;
		if(transactionLeft %2==0){
			profit = Math.max(-arr[index] + memoization(index+1, arr, transactionLeft+1, k, dp), memoization(index+1, arr, transactionLeft, k, dp));
		}else{
			profit = Math.max(arr[index] + memoization(index+1,  arr, transactionLeft+1, k, dp), memoization(index+1, arr, transactionLeft, k, dp));
		}

		return dp[index][transactionLeft]= profit;
	}


	/**
	 * 1. base case
	 * 2. changing parameter to loop
	 * 3. copy recurrence
	 * 
	 * */
	private int tabulation(int[] arr, int k, int[][] dp){
		int n = arr.length;

		for(int index=n-1; index>=0; index--){
			for(int transactionLeft=2*k-1; transactionLeft>=0; transactionLeft--){
				int profit = 0;
				if(transactionLeft %2==0){
					profit = Math.max(-arr[index] + dp[index+1][transactionLeft+1], dp[index+1][transactionLeft]);
				}else{
					profit = Math.max(arr[index] + dp[index+1][transactionLeft+1], dp[index+1][transactionLeft]);
				}

				dp[index][transactionLeft] = profit;
			}
			
		}
		
		return dp[0][0];
	}


	private int spaceOptimization(int[] arr, int k){
		int n = arr.length;

		int[] curr = new int[2*k+1];
		int[] next = new int[2*k+1];

		for(int index=n-1; index>=0; index--){
			for(int transactionLeft=2*k-1; transactionLeft>=0; transactionLeft--){
				int profit = 0;
				if(transactionLeft %2==0){
					profit = Math.max(-arr[index] + next[transactionLeft+1], next[transactionLeft]);
				}else{
					profit = Math.max(arr[index] + next[transactionLeft+1], next[transactionLeft]);
				}

				curr[transactionLeft] = profit;
			}
			next = curr;
			
		}
		
		return next[0];
	}
	

 
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock4 obj =new BestTimeToBuyAndSellStock4();
		int[] arr = {7,1,5,3,60,4,10,10,30};
		System.out.println(obj.maxProfit(arr, 2));
	}
}