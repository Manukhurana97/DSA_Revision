import java.util.*;

public class HouseRobber{

	public int houseRober(int n, int[] valueInHouse){

		// return dfs(n - 1, valueInHouse);
		
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);

		// return memorization(n - 1, valueInHouse, dp);

		// return tabulation(n - 1, valueInHouse, dp);

		return spaceOptimization(n-1, valueInHouse);
	}

	private int dfs(int n, int[] valueInHouse){
		if(n < 0) return 0;

		int take = valueInHouse[n] +  dfs(n-2, valueInHouse) ;
		int notTake = dfs(n-1, valueInHouse);

		return Math.max(take, notTake);
	}


	private int memorization(int n, int[] valueInHouse, int[] dp){
		if(n < 0) return 0;

		if(dp[n] != -1) return dp[n];

		int take = valueInHouse[n] +  memorization(n-2, valueInHouse, dp) ;
		int notTake = memorization(n-1, valueInHouse, dp);

		dp[n] =  Math.max(take, notTake);
		return dp[n];

	}

	private int tabulation(int n, int[] valueInHouse, int[] dp){
		if(n == 0) return 0;
		if(n == 1) return valueInHouse[1];
		dp[0] = valueInHouse[0];


		for(int i=1; i<=n; i++){
			int take = valueInHouse[i] +  (i-2 >=0 ? dp[i-2] : 0);
			int notTake = dp[i-1];

			dp[i] =  Math.max(take, notTake);
		
		}
		return dp[n];
	}

	private int spaceOptimization(int n, int[] valueInHouse){
		if(n == 0) return 0;
		if(n == 1) return valueInHouse[1];
		
		int prev1 = valueInHouse[0];
		int prev2 = 0;

		for(int i=1; i<=n; i++){
			int current = Math.max(valueInHouse[i] + prev2, prev1);
			prev2 = prev1;
			prev1 = current;
		}

		return prev1;
	}


	public static void main(String[] args) {
		HouseRobber obj = new HouseRobber();

		int[] arr = {2, 7, 9, 3, 1};
		System.out.println(obj.houseRober(arr.length, arr));
	}
}