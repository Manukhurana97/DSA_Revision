// https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

public class CountALLSubSetWithSumK{
	public int perfectSum(int[] nums, int target) {
        int[][] memo = new int[nums.length+1][target+1];
        
        // return recursion(0, nums, target, memo);
        
        return tabulation(nums, target, memo);
    }
    
    private int recursion(int i, int[] nums, int target, int[][] memo){
        if(target < 0) return 0;
        if(i == nums.length){
            return target == 0 ? 1 : 0;
        }
        
        if(memo[i][target] != 0) return memo[i][target];
        
        int take = target >= nums[i] ? recursion(i+1, nums, target-nums[i], memo)  :  0;
        int notTake = recursion(i+1, nums, target, memo);
        
        return memo[i][target] = take+notTake;
    }
    
    
    private int tabulation(int[] nums, int target, int[][] memo) {
        int n = nums.length;
        
        memo[n][0] = 1;
        
        for(int i=n-1; i>=0; i--) {
            for(int t=0; t<=target; t++) {
                int take = t >= nums[i] ? memo[i+1][t-nums[i]]  :  0;
                int notTake = memo[i+1][t];
                
                memo[i][t] = take+notTake;
            }
        }
        
        return memo[0][target];
    }
}