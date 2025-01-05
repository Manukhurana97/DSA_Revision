// https://leetcode.com/problems/jump-game-ii/
public class JumpGame2{


	public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // return recursion(0, nums, dp);

        return tabulation(nums, dp);

    }

    private int recursion(int i, int[] nums, int[] dp){
        if(i>=nums.length-1) return 0;

        if(dp[i] != 0) return dp[i];

        int count = Integer.MAX_VALUE;
        for(int ind=1; ind<=nums[i]; ind++){
            if (i + ind < nums.length) {
                int result = recursion(i+ind, nums, dp);
                if(result != Integer.MAX_VALUE){
                    count = Math.min(count, 1 + result);
                }
            }
        }

        return dp[i] = count;
    }



    private int tabulation(int[] nums, int[] dp){
        int n = nums.length;
        dp[n-1] = 0;

        for(int i=n-2; i>=0; i--){
            int count = Integer.MAX_VALUE;
            for(int ind=1; ind<=nums[i]; ind++){
                if (i + ind < nums.length) {
                    int result = dp[i+ind];
                    if(result != Integer.MAX_VALUE){
                        count = Math.min(count, 1 + result);
                    }
                }
            }
            dp[i] = count;
        }

        return dp[0];
    }
   
	

	// ----------------------------------------------------------------
	public int jump(int[] nums) {
        int fartherWeCanGo = 0;
        int jumps = 0;
        int currentEnd = 0;

        if(nums.length==1) return 0;

        for(int i=0;i<nums.length;i++){
            fartherWeCanGo = Math.max(fartherWeCanGo, i + nums[i]);

            if(i == currentEnd){ // end of current jump
                jumps++;
                currentEnd = fartherWeCanGo;

                if(currentEnd >= nums.length-1) break; // if found end
            }
        }

        return jumps;
    }
}