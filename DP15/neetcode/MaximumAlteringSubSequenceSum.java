// https://leetcode.com/problems/maximum-alternating-subsequence-sum/

// its similar to stock to stock buy and sell (jus opposite, sell and buy)
public class MaximumAlteringSubSequenceSum {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        // long[][] dp = new long[n+1][2];
        // return recursion(n-1, true, nums, dp);

        // return tabulation(nums);

        return spaceOptimization(nums);
    }

    // similar to stock buy and sell
    private long recursion(int i, boolean canAdd, int[] nums, long[][] dp){
        if(i<0) return 0;

        if(dp[i][canAdd ? 1: 0] != 0) return dp[i][canAdd ? 1: 0];

        long profit = 0;
        if(canAdd){
            profit = Math.max(nums[i] + recursion(i-1, false, nums, dp), recursion(i-1, true, nums, dp)); // sell 
        }else{
            profit = Math.max(-nums[i] + recursion(i-1, true, nums, dp), recursion(i-1, false, nums, dp)); // buy
        }

        return dp[i][canAdd ? 1: 0] = profit;
    }


    private long tabulation(int[] nums){
        int n = nums.length;
        long[][] dp = new long[n+1][2];

        dp[0][1] = nums[0]; // Adding the first number
        
        for(int i=1; i<n; i++){
            dp[i][1]  = Math.max(nums[i] + dp[i-1][0], dp[i-1][1]);
            dp[i][0] = Math.max(-nums[i] + dp[i-1][1], dp[i-1][0]);        
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    private long spaceOptimization(int[] nums){
        int n = nums.length;
        long[] curr = new long[2];
        long[] prev = new long[2];
        

        prev[1] = nums[0]; // Adding the first number
        
        for(int i=1; i<n; i++){
            curr[1]  = Math.max(nums[i] + prev[0], prev[1]);
            curr[0] = Math.max(-nums[i] + prev[1], prev[0]);    

            prev = curr;    
        }

        return Math.max(prev[0], prev[1]);
    }
}