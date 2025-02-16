// https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

public class CountALLSubSetWithSumK{
	public int perfectSum(int[] nums, int target) {
        Integer[][] dp = new Integer[nums.length][target+1];
        
        return recursion(0, nums, target, dp);
    }


    public int recursion(int i, int[] nums, int target, Integer[][] dp){
        if(i==nums.length){
            return target == 0 ? 1: 0;
        }
        
        if(dp[i][target] != null) return dp[i][target];
        
        int take = target>=nums[i] ? recursion(i+1, nums, target - nums[i], dp) : 0;
        int notTake = recursion(i+1, nums, target, dp);
        
        return dp[i][target] = take+notTake;
    }
}