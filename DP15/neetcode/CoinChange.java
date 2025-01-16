// https://leetcode.com/problems/coin-change/

public class CoinChange{

	public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        Arrays.sort(coins);

    //    int result  = recursion(n-1, coins, amount);

        // int[][] dp = new int[n][amount+1];
        // int result  = memoization(n-1, coins, amount, dp);

        // int result  = tabulation(coins, amount, dp);

        int result = spaceOptimization(coins, amount);

       return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int recursion(int i, int[] coins, int amount){
        if(amount == 0) return 0;
        if(i == 0) return amount%coins[i] == 0 ? amount/coins[i] : Integer.MAX_VALUE;

        int notTake = recursion(i-1, coins, amount);

        int take = Integer.MAX_VALUE;
        if(amount >= coins[i]){
            int result = recursion(i, coins, amount-coins[i]);
            if(result != Integer.MAX_VALUE){
                take = 1 + result;
            }
        }

        return Math.min(take, notTake);
    }


    private int memoization(int i, int[] coins, int amount, int[][] dp){
        if(amount == 0) return 0;
        if(i == 0) return amount%coins[i] == 0 ? amount/coins[i] : Integer.MAX_VALUE;

        if(dp[i][amount] != 0) return dp[i][amount];

        int notTake = memoization(i-1, coins, amount, dp);

        int take = Integer.MAX_VALUE;
        if(amount >= coins[i]){
            int result = memoization(i, coins, amount-coins[i], dp);
            if(result != Integer.MAX_VALUE){
                take = 1 + result;
            }
        }
        

        return dp[i][amount] = Math.min(take, notTake);
    }


    private int tabulation(int[] coins, int target, int[][] dp){
        int n = coins.length;
        
        for(int amount = 0; amount<=target; amount++) 
            dp[0][amount] = amount%coins[0] == 0 ? amount/coins[0] : Integer.MAX_VALUE;


        for(int i=1; i<n; i++){
            for(int amount = 0;amount<=target; amount++){
                
                int notTake = dp[i-1][amount];
                
                int take = Integer.MAX_VALUE;
                if(amount >= coins[i]){
                    int result = dp[i][amount-coins[i]];
                    if(result != Integer.MAX_VALUE){
                        take = 1 + result;
                    }
                }
                

            dp[i][amount] = Math.min(take, notTake);
            }
        }

        return dp[n-1][target];
    }


    private int spaceOptimization(int[] coins, int target){
        int n = coins.length;

        int[] prev = new int[target+1];
        
        for(int amount = 0; amount<=target; amount++) 
            prev[amount] = amount%coins[0] == 0 ? amount/coins[0] : Integer.MAX_VALUE;


        for(int i=1; i<n; i++){
            // int[] curr = new int[target+1];
            for(int amount = 0;amount<=target; amount++){
                
                int notTake = prev[amount];
                int take = Integer.MAX_VALUE;
                if(amount >= coins[i]){
                    int result = prev[amount-coins[i]];
                    if(result != Integer.MAX_VALUE){
                        take = 1 + result;
                    }
                }
                

                prev[amount] = Math.min(take, notTake);
            }
            // prev = curr;
        }

        return prev[target];
    }
}