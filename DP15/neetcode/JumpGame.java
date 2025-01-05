// https://leetcode.com/problems/jump-game/
public class JumpGame{
	public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        
        // Boolean[] dp = new Boolean[nums.length+1];
        // return recursion(0, nums, dp);

        // return tabulation(nums);

        return spaceOptimization(nums);
    }

    private boolean recursion(int i, int[] nums, Boolean[] dp){
        if(i>=nums.length-1) return true;

        if(dp[i] != null) return dp[i];

        for(int ind = 1; ind<=nums[i]; ind++){
            if(recursion(i+ind, nums, dp)) 
                return dp[i] = true;
        }

        return dp[i] = false;
    }


    private boolean tabulation(int[] nums){
        int n = nums.length;

        boolean[] dp = new boolean[n+1];
        dp[n-1] =  true;

        for(int i=n-2; i>=0; i--){
            for(int ind = 1; ind<=nums[i]; ind++){
                if(i + ind >= n-1 || dp[i+ind]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }



    public boolean spaceOptimization(int[] nums) {
        int maxIndex = 0;
        for(int i=0; i<nums.length; i++){
            if(i>maxIndex) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if(maxIndex >= nums.length-1) return true;
        }

        return false;
    }
}