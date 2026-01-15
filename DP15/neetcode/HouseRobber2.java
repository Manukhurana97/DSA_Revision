    // https://leetcode.com/problems/house-robber-ii/

public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        // return Math.max(recursion(0, n-2, nums), recursion(1, n-1, nums));

        // int[] dp1 = new int[n];
        // int[] dp2 = new int[n];
        // return Math.max(memoization(0, n-2, nums, dp1), memoization(1, n-1, nums, dp2));

        // return Math.max(tabulation(0, n-2, nums, dp1), tabulation(1, n-1, nums, dp2));

        return Math.max(spaceOptimization(0, n-2, nums), spaceOptimization(1, n-1, nums));
    }

    public int recursion(int n, int i, int[] nums){
        if(i<n) return 0;

        int notTake = recursion(n, i-1, nums);
        int take = nums[i] + recursion(n, i-2, nums);

        return Math.max(take, notTake);
    }


    public int memoization(int start, int end, int[] nums, int[] dp){
        if(end<start) return 0;

        if(dp[end] != 0) return dp[end];

        int notTake = memoization(start, end-1, nums, dp);
        int take = nums[end] + memoization(start, end-2, nums, dp);

        return dp[end] =  Math.max(take, notTake);
    }

    public int tabulation(int start, int end, int[] nums, int[] dp){
        if (start == end) return nums[start];
        
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        

        for(int i=start+2; i<=end; i++){
            int notTake = dp[i - 1];
            int take = nums[i] + dp[i - 2];

            dp[i] =  Math.max(take, notTake);
        }

        return dp[end];
    }


    public int spaceOptimization(int start, int end, int[] nums){
        int prev1 = 0, prev2 = 0;

        for(int i=start; i<=end; i++){
            int notTake = prev1;
            int take = nums[i] + prev2;

            int curr =  Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
    
}