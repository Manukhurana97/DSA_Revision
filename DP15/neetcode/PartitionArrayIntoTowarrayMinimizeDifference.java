// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
// this code has some error

public class PartitionArrayIntoTowarrayMinimizeDifference {
    public int minimumDifference(int[] nums) {
        int n = nums.length, minSum = 0, maxSum = 0;
        
        for (int i : nums) {
            if(i<0) minSum += i;
            else maxSum += i;
        }

        int offset = -minSum; // Offset to handle negative targets
        int totalSum = maxSum - minSum; // Total range of possible sums
        
        Boolean[][] dp = new Boolean[nums.length][totalSum + 1];

        // recursion(n-1, totalSum, nums, dp, offset);

        // tabulation(totalSum, offset, nums);

        boolean[] res = spaceOptimization(totalSum, offset, nums);
        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<res.length; i++){
            if(res[i]){
                int s1 = i-offset;
                int s2 = totalSum-i-offset;

                int diff = Math.abs(s2-s1);
                minDiff = Math.min(minDiff, diff);
            }
        }

        return minDiff;

    }

    private boolean recursion(int i, int target,  int[] nums, Boolean[][] dp, int offset){
        if(target == 0) return true;
        if(i==0) return target == nums[0];

        int adjustedTarget = target + offset;
        // Check if the adjusted target is within bounds
        if (adjustedTarget < 0 || adjustedTarget >= dp[0].length) return false;

        if(dp[i][adjustedTarget] != null) return dp[i][adjustedTarget]; 

        boolean notTake = recursion(i-1, target, nums, dp, offset);
        boolean take = target >= nums[i] ? recursion(i-1, target-nums[i], nums, dp, offset) : false;

        return dp[i][adjustedTarget] = take || notTake;
    }


    private boolean tabulation(int target, int offset, int[] nums){
        int n = nums.length;
        boolean[][] dp = new boolean[n][target+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(nums[0]<=target){
            dp[0][nums[0]+offset] = true;
        }

        for(int i=1; i<n; i++){
            for(int t=0; t<=target; t++){
                int adjustedTarget = t + offset;
                // Check if the adjusted target is within bounds
                if (adjustedTarget >=0 && adjustedTarget < dp.length) {

                    boolean notTake = dp[i-1][t];
                    boolean take = t >= nums[i] ? dp[i-1][t-nums[i]] : false;

                    dp[i][adjustedTarget] = take || notTake;
                }
            }
        }

        return dp[n-1][target];
    }


    private boolean[] spaceOptimization(int target, int offset, int[] nums){
        int n = nums.length;
        boolean[] dp = new boolean[target+1];   
        dp[0] = true;
    

        for(int i=0; i<n; i++){
            for(int t=0; t<=target; t++){
                int adjustedTarget = t + offset;
                // Check if the adjusted target is within bounds
                if (adjustedTarget >=0 && adjustedTarget < dp.length) {
                    boolean notTake = dp[t];
                    boolean take = t >= nums[i] ? dp[t-nums[i]] : false;

                    dp[adjustedTarget] = take || notTake;
                }
            }
        }

        return dp;
    }
}