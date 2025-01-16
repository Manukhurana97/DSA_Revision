// https://leetcode.com/problems/house-robber/

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        // return recursion(n-1, nums);

        int[] dp = new int[n+1];
        // return memoization(n-1, nums, dp);

        // return tabulation(nums, dp);

        return spaceOptimization(nums);
    }

    private int recursion(int i, int[] nums){
        if(i<0) return 0;

        int rob = nums[i] + recursion(i-2, nums);
        int notRob  = recursion(i-1, nums);

        return Math.max(rob, notRob);
    }


    private int memoization(int i, int[] nums, int[] dp){
        if(i<0) return 0;

        if(dp[i] != 0) return dp[i];

        int rob = nums[i] + memoization(i-2, nums, dp);
        int notRob  = memoization(i-1, nums, dp);

        return dp[i] = Math.max(rob, notRob);
    }


    private int tabulation(int[] nums, int[] dp){
        int n = nums.length;
        dp[0] = nums[0];

        for(int i=1; i<n; i++){
            int rob = nums[i] +  (i-2 >=0 ? dp[i-2] : 0);
            int notRob  = dp[i-1];

            dp[i] = Math.max(rob, notRob);
        }

        return dp[n-1];
    }


    private int spaceOptimization(int[] nums){
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;

        for(int i=1; i<n; i++){
            int rob = nums[i] +  (i-2 >=0 ? prev2 : 0);
            int notRob  = prev1;

            int curr = Math.max(rob, notRob);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}


