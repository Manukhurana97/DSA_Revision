public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        if(n == 1) {
            return target % nums[0] == 0 ? target / nums[0] : 0;
        }

        int[] dp = new int[target+1];
        // return recursion(target, nums, dp);

        return tabulation(target, nums, dp);
    }


    private int recursion(int target, int[] nums, int[] dp){
        if(target == 0) return 1;
        if( target < 0) return 0;

        if(dp[target] != 0) return dp[target];

        int count = 0;
        for(int i : nums)
            count += recursion(target - i, nums, dp);
                
        return dp[target] = count;
    }


    private int tabulation(int target, int[] nums, int[] dp){
        for(int i : nums) dp[0] = 1;

        for(int t=1; t<=target; t++){
            int count = 0;
            for(int i : nums){
                count += t-i >=0 ? dp[t - i] : 0;
            }
            dp[t] = count;
        }

        return dp[target];
    }
}