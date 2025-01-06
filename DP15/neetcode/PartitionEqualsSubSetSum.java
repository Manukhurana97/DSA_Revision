// https://leetcode.com/problems/partition-equal-subset-sum/

public class PartitionEqualsSubSetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        for(int i: nums) sum += i;

        if(sum%2 != 0) return false;

        // Boolean[][] dp = new Boolean[n][sum/2+1];
        // return recursion(n-1, sum/2, nums, dp);

        // return tabulation(sum/2, nums);

        // return spaceOptimization(sum/2, nums);

        return spaceOptimization1(sum/2, nums);
    }


    private boolean recursion(int i, int target, int[] nums, Boolean[][] dp){
        if(target == 0) return true;
        if(i < 0 || target < 0) return false; 

        if(dp[i][target] != null) return dp[i][target];

        boolean notTake = recursion(i-1, target, nums, dp);
        boolean take = recursion(i-1, target-nums[i], nums, dp);

        return dp[i][target] = take || notTake;
    }


    private boolean tabulation(int t, int[] nums){
        int n = nums.length;
        boolean[][] dp = new boolean[n][t+1];

        for(int i=0; i<n; i++) dp[i][0] = true;


        for(int i=1; i<n; i++){
            for(int target = 0; target<=t; target++){
                boolean notTake = dp[i-1][target];
                boolean take = target - nums[i] >=0 ? dp[i-1][target-nums[i]] : false;

                dp[i][target] = take || notTake;
            }
        }

        return dp[n-1][t];
    }


    private boolean spaceOptimization(int t, int[] nums){
        int n = nums.length;
        boolean[] prev = new boolean[t+1];

        prev[0] = true;


        for(int i=1; i<n; i++){
            boolean[] curr = new boolean[t+1];
            for(int target = 0; target<=t; target++){
                boolean notTake = prev[target];
                boolean take = target - nums[i] >=0 ? prev[target-nums[i]] : false;

                curr[target] = take || notTake;
            }

            prev = curr;
        }

        return prev[t];
    }


    private boolean spaceOptimization1(int t, int[] nums){
        int n = nums.length;
        boolean[] prev = new boolean[t+1];

        prev[0] = true;


        for(int i=1; i<n; i++){
            for(int target = t; target>=0; target--){
                boolean notTake = prev[target];
                boolean take = target - nums[i] >=0 ? prev[target-nums[i]] : false;

                prev[target] = take || notTake;
            }

        }

        return prev[t];
    }
}