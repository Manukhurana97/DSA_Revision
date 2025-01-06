import java.util.*;

public class BurstBallons{

	private int maxCoins(int[] arr){
		int n = arr.length;
		List<Integer> list = new ArrayList<>();

		list.add(1);
		for(int i: arr) list.add(i);
		list.add(1);

		// return recursion(1, n, list);

		int[][] dp = new int[n+2][n+2];
		// return memoization(1, n, list, dp);

		return tabulation(n, list, dp);

	}


	private int recursion(int i, int j, List<Integer> arr){
		if(i>j) return 0;

		int maxProfit = 0;
		for(int ind = i; ind<=j; ind++){
			// coins=list[i-1]×list[ind]×list[j+1]+left part+right part
			// we will start from last and move till 0 , inorder to make it independent, after solveing current
			// solve current + left + right
			int cost = arr.get(i-1) * arr.get(ind) * arr.get(j+1) + recursion(i, ind-1, arr) + recursion(ind+1, j, arr);
			maxProfit = Math.max(maxProfit, cost);
		}

		return maxProfit;
	}


	private int memoization(int i, int j, List<Integer> arr, int[][] dp){
		if(i>j) return 0;

		if(dp[i][j] != 0) return dp[i][j];

		int maxProfit = 0;
		for(int ind = i; ind<=j; ind++){
			int cost = arr.get(i-1) * arr.get(ind) * arr.get(j+1) + memoization(i, ind-1, arr, dp) + memoization(ind+1, j, arr, dp);
			maxProfit = Math.max(maxProfit, cost);
		}


		dp[i][j] = maxProfit;
		return maxProfit;
	}



	private int tabulation(int n, List<Integer> arr, int[][] dp){

		for(int i=n; i>=1; i--){
			for(int j=0; j<=n; j++){
				
				if(i>j) continue;

				int maxProfit = 0;
				for(int ind = i; ind<=j; ind++){
					int cost = arr.get(i-1) * arr.get(ind) * arr.get(j+1) + dp[i][ind-1] + dp[ind+1][j];
					maxProfit = Math.max(maxProfit, cost);
				}

				dp[i][j] = maxProfit;
			}
		}
		return dp[1][n];
	}

	
	public static void main(String[] args) {
		BurstBallons obj = new BurstBallons();
		int[] arr = {3, 1, 5, 8};
		System.out.println(obj.maxCoins(arr));
	}
}