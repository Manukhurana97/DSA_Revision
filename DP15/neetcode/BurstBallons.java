public class BurstBallons{
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i: nums) list.add(i);
        list.add(1);

        int[][] dp = new int[n+2][n+2];

        // return recursion(1, n, list, dp);

        // return tabulation(list, dp);

        return spaceOptimization(list);
    }

    private int recursion(int i, int j, List<Integer> list, int[][] dp){
        if(i>j) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        int maxProfit = 0;
        for(int ind=i; ind<=j; ind++){
            // trick is: start from last instead of first (i-1 * ind * j+1) + left() + right()
            maxProfit = Math.max(maxProfit, list.get(i-1) * list.get(ind) * list.get(j+1) +  recursion(i, ind-1, list, dp) + recursion(ind+1, j, list, dp));
        }

        return dp[i][j] = maxProfit;
    }



    private int tabulation(List<Integer> list, int[][] dp){
        int n = list.size()-2;

        for(int i=n; i>=1; i--){
            for(int j=0; j<=n; j++){
                if(i>j) continue;

                int maxProfit = 0;
                for(int ind=i; ind<=j; ind++){
                    // trick is: start from last instead of first (i-1 * ind * j+1) + left() + right()
                    maxProfit = Math.max(maxProfit, list.get(i-1) * list.get(ind) * list.get(j+1) +  dp[i][ind-1] + dp[ind+1][j]);
                }

                dp[i][j] = maxProfit;
            }
        }

        return dp[1][n];
    }


    
}
