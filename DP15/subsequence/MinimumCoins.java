// https://leetcode.com/problems/coin-change/description/

public class MinimumCoins{

	public int coinChange(int[] coins, int amount) {
        // int n = coins.length;
        // long[][] dp = new long[n][amount + 1];

        // var result = recursion(n-1, amount, coins, dp);

        // var result = tabulation(amount, coins);

        var result = spaceOptimization(amount, coins);
    
        return (int)(result >= Integer.MAX_VALUE ? -1 : result);
    }

    private long recursion(int i, int amount, int[] coins, long[][] dp) {
        if(i == 0) {
            return amount % coins[i] == 0 ? amount / coins[i] : Integer.MAX_VALUE;
        }

        if(dp[i][amount] != 0) return dp[i][amount];

        long notTake = recursion(i-1, amount, coins, dp);
        long take = amount >= coins[i] ? 1 + recursion(i, amount - coins[i], coins, dp) : Integer.MAX_VALUE;

        return dp[i][amount] = Math.min(take, notTake);
    }

    private long tabulation(int amount, int[] coins) {
        int n = coins.length;
        long[][] dp = new long[n][amount+1];

        for(int a=0; a<=amount; a++) {
            dp[0][a] = (a % coins[0] == 0) ? a / coins[0] : Integer.MAX_VALUE;
        }

        for(int i=1; i<n; i++) {
            for(int a = 0; a<=amount; a++) {
                long notTake = dp[i-1][a];
                long take = (a >= coins[i]) ? 1 + dp[i][a - coins[i]] : Integer.MAX_VALUE;

                dp[i][a] = Math.min(take, notTake);
            }
        }

        return dp[n-1][amount];
    }


    private long spaceOptimization(int amount, int[] coins) {
        int n = coins.length;
        long[] prev = new long[amount+1];

        for(int a=0; a<=amount; a++) {
            prev[a] = (a % coins[0] == 0) ? a / coins[0] : Integer.MAX_VALUE;
        }

        for(int i=1; i<n; i++) {
            long[] curr = new long[amount+1];

            for(int a = 0; a<=amount; a++) {
                long notTake = prev[a];
                long take = (a >= coins[i]) ? 1 + curr[a - coins[i]] : Integer.MAX_VALUE;

                curr[a] = Math.min(take, notTake);
            }

            prev = curr;
        }

        return prev[amount];
    }



	public static void main(String[] args) {
		MinimumCoins obj = new MinimumCoins();
		int[] arr = {1,2,5};

		System.out.println(obj.coinChange(arr, 23));
	}
}