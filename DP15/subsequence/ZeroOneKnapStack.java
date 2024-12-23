public class ZeroOneKnapStack{
	private int maxProfit(int w, int[][] arr){

		// return recursion(arr.length - 1, w, arr);


		int[][] dp = new int[arr.length][w+1];
		// return memoization(arr.length - 1, w, arr, dp);

		// return tabulation(w, arr, dp);

		// return spaceOptimization(w, arr);
		
		return spaceOptimization1(w, arr);
	}

	private int recursion(int index, int wt, int[][] arr){
		if(index < 0 || wt == 0) return 0;

		int notTake = recursion(index-1, wt, arr);
		int take = wt >= arr[index][0] ? arr[index][1] + recursion(index-1, wt-arr[index][0], arr) : Integer.MIN_VALUE;

		return Math.max(notTake, take);
	}


	private int memoization(int index, int wt, int[][] arr, int[][] dp){
		if(index == 0){
			if(arr[0][0] <= wt) return arr[0][1];
			return 0;
			
		}

		if(dp[index][wt] != 0) return dp[index][wt];

		int notTake = memoization(index-1, wt, arr, dp);
		int take = wt >= arr[index][0] ? arr[index][1] + memoization(index-1, wt-arr[index][0], arr, dp) : Integer.MIN_VALUE;

		return dp[index][wt] = Math.max(notTake, take);
	}


	private int tabulation(int wt, int[][] arr, int[][] dp){

		for(int w=0; w<=wt; w++){
			if(w>=arr[0][0])
				dp[0][w] = arr[0][1]; // Assign profit of the first item
		}

		for(int index=1; index<arr.length; index++){
			for(int w=0; w<=wt; w++){
				int notTake = dp[index-1][w];
				int take = w >= arr[index][0] ? arr[index][1] + dp[index-1][w-arr[index][0]] : Integer.MIN_VALUE;

				dp[index][w] = Math.max(notTake, take);
			}
		}

		return dp[arr.length-1][wt];
	}


	private int spaceOptimization(int wt, int[][] arr){

		int[] prev = new int[wt+1];
		int[] curr = new int[wt+1];

		for(int w=0; w<=wt; w++){
			if(w>=arr[0][0])
				prev[w] = arr[0][1]; // Assign profit of the first item
		}

		for(int index=1; index<arr.length; index++){
			for(int w=0; w<=wt; w++){
				int notTake = prev[w];
				int take = w >= arr[index][0] ? arr[index][1] + prev[w-arr[index][0]] : Integer.MIN_VALUE;

				curr[w] = Math.max(notTake, take);
			}
			prev = curr;
		}

		return prev[wt];
	}


	private int spaceOptimization1(int wt, int[][] arr){

		int[] prev = new int[wt+1];

		for(int w=0; w<=wt; w++){
			if(w>=arr[0][0])
				prev[w] = arr[0][1]; // Assign profit of the first item
		}

		for(int index=1; index<arr.length; index++){
			for(int w=wt; w>=0; w--){
				int notTake = prev[w];
				int take = w >= arr[index][0] ? arr[index][1] + prev[w-arr[index][0]] : Integer.MIN_VALUE;

				prev[w] = Math.max(notTake, take);
			}
			prev = prev;
		}

		return prev[wt];
	}

	public static void main(String[] args) {
		ZeroOneKnapStack obj = new ZeroOneKnapStack();
		
		int[][] arr = {{3, 30}, {2, 40}, {5, 60}};
		System.out.println(obj.maxProfit(6, arr));
	}	
}