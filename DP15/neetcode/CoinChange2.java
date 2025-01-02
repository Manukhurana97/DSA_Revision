 // https://leetcode.com/problems/coin-change-ii/description/

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        // return recursion(n-1, amount, coins);

        int[][] dp = new int[n+1][amount+1];
        // return memoization(n-1, amount, coins, dp);

        return tabulation(amount, coins, dp);
    }

    private int recursion(int i, int amount, int[] coins){
        if(i == 0){
            return amount % coins[i] == 0 ? 1 : 0;
        }

        int notTake = recursion(i-1, amount, coins);
        int take = amount >= coins[i] ? recursion(i, amount-coins[i], coins) : 0;

        return  take + notTake;
    }


    private int memoization(int i, int amount, int[] coins, int[][] dp){
        if(i == 0){
            return amount % coins[i] == 0 ? 1 : 0;
        }

        if(dp[i][amount] != 0) return dp[i][amount];

        int notTake = memoization(i-1, amount, coins, dp);
        int take = amount >= coins[i] ? memoization(i, amount-coins[i], coins, dp) : 0;

        return dp[i][amount] = take + notTake;
    }


    private int tabulation(int target, int[] coins, int[][] dp){
        int n = coins.length;
        
        for(int amount = 0; amount<=target; amount++){
            dp[0][amount] = amount % coins[0] == 0 ? 1 : 0;
        }

        for(int i=1; i<n; i++){
            for(int amount = 0; amount<=target; amount++){
                int notTake = dp[i-1][amount];
                int take = amount >= coins[i] ? dp[i][amount-coins[i]] : 0;

                dp[i][amount] = take + notTake;
            }
        }

        return dp[n-1][target];
    }


    private int spaceOptimization(int target, int[] coins){
        int n = coins.length;
        int[] prev = new int[target+1];
        
        for(int amount = 0; amount<=target; amount++){
            prev[amount] = amount % coins[0] == 0 ? 1 : 0;
        }

        for(int i=1; i<n; i++){
            int[] curr = new int[target+1];
            for(int amount = 0; amount<=target; amount++){
                int notTake = prev[amount];
                int take = amount >= coins[i] ? curr[amount-coins[i]] : 0;

                curr[amount] = take + notTake;
            }
            prev = curr;
        }

        return prev[target];
    }
}