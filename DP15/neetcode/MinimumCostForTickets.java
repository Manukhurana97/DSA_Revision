// https://leetcode.com/problems/minimum-cost-for-tickets/description/

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        
        // return recursion(0, 0, days, costs, new int[]{1,7,30});

        int finalDay = 0;
        for(int i: days) finalDay = Math.max(finalDay, i);
        

        // int[][] dp = new int[n+1][finalDay+31];
        // return memoization(0, 0, days, costs, new int[]{1,7,30}, dp);

        // return tabulation(days, costs, new int[]{1,7,30}, dp);

        return spaceOptimize(days, costs, new int[]{1,7,30}, finalDay+31);
    }

    private int recursion(int ind, int validTill,  int[] days, int[] costs, int[] passValid){
        if(ind>=days.length) return 0;

        if(days[ind]<validTill) return recursion(ind+1, validTill, days, costs, passValid);

        int totalCost = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){            
            int cost = costs[i] + recursion(ind+1, days[ind]+passValid[i], days, costs, passValid);
            totalCost = Math.min(totalCost, cost);
        }

        return totalCost;
    }





    private int memoization(int ind, int validTill,  int[] days, int[] costs, int[] passValid, int[][] dp){
        if(ind>=days.length) return 0;

        if(dp[ind][validTill] != 0) return dp[ind][validTill];

        // not buy
        if(days[ind]<validTill) return memoization(ind+1, validTill, days, costs, passValid, dp);

        // buy pass
        int totalCost = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){            
            int cost = costs[i] + memoization(ind+1, days[ind]+passValid[i], days, costs, passValid, dp);
            totalCost = Math.min(totalCost, cost);
        }

        return dp[ind][validTill] = totalCost;
    }



    public int mincostTickets1(int[] days, int[] costs) {
        // Memoization table to store results of subproblems
        int[] memo = new int[days.length];
        Arrays.fill(memo, -1);

        // Recursive call with memoization
        return recursion(0, days, costs, new int[]{1, 7, 30}, memo);
    }

    private int memoization1(int ind, int[] days, int[] costs, int[] passValid, int[] memo) {
        // If all days have been covered, no cost is needed
        if (ind >= days.length) return 0;

        // If the result is already computed, return it
        if (memo[ind] != -1) return memo[ind];

        int totalCost = Integer.MAX_VALUE;

        // Try all three pass options
        for (int i = 0; i < 3; i++) {
            int j = ind;

            // Find the next day not covered by the current pass
            while (j < days.length && days[j] < days[ind] + passValid[i]) {
                j++;
            }

            // Recursively calculate cost for the remaining days
            int cost = costs[i] + recursion1(j, days, costs, passValid, memo);
            totalCost = Math.min(totalCost, cost);
        }

        // Store the result in the memoization table
        memo[ind] = totalCost;

        return totalCost;
    }



    private int tabulation(int[] days, int[] costs, int[] passValid, int[][] dp){
        int n = days.length;

        for(int ind=n-1; ind>=0; ind--){
            for(int validTill = days[n-1]; validTill>=0; validTill--){

                // not buy
                if(days[ind]<validTill){
                    dp[ind][validTill] = dp[ind + 1][validTill]; 
                    continue;
                }

                // buy pass
                int totalCost = Integer.MAX_VALUE;
                for(int i=0; i<3; i++){            
                    int cost = costs[i] + dp[ind+1][days[ind]+passValid[i]];
                    totalCost = Math.min(totalCost, cost);
                }

                dp[ind][validTill] = totalCost;
            }
        }

        return dp[0][0];
    }


    private int spaceOptimize(int[] days, int[] costs, int[] passValid, int totalDays){
        int n = days.length;

        int[] prev = new int[totalDays];

        for(int ind=n-1; ind>=0; ind--){
            int[] curr = new int[totalDays];
            for(int validTill = days[n-1]; validTill>=0; validTill--){

                // not buy
                if(days[ind]<validTill){
                    curr[validTill] = prev[validTill]; 
                    continue;
                }

                // buy pass
                int totalCost = Integer.MAX_VALUE;
                for(int i=0; i<3; i++){            
                    int cost = costs[i] + prev[days[ind]+passValid[i]];
                    totalCost = Math.min(totalCost, cost);
                }

                curr[validTill] = totalCost;
            }
            prev = curr;
        }

        return prev[0];
    }
}