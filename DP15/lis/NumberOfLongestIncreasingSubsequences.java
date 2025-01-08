// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

public class NumberOfLongestIncreasingSubsequences{


	/** 
	 * number of combinations we can formed for the longest seusequece
	 * eg : [1,2,4,3,5], max id 5 with len 4 , we can have in in 2 order [{1,2,4,5}, {1,2,3,5}]
	 * */
	
	public int longestIncSubSequence(int[] nums) {
        
        return tabulation(nums);
    }


    private int tabulation(int[] nums){
        int n = nums.length, maxLen = 0;
        int[] dp = new int[n];
        int[] count = new int[n];
        
        for(int i=0; i<n; i++){
            dp[i] = 1;
            count[i] = 1;
        }

        for(int i=0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if(nums[i] > nums[prev] && dp[i] < dp[prev]+1){
                    count[i] = count[prev];
                    dp[i] = dp[prev]+1;
                }else if(nums[i] > nums[prev] && dp[i] == dp[prev]+1)
                    count[i] += count[prev];
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int numOfLIS = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                numOfLIS += count[i];  // Accumulate the number of LIS of maximum length
            }
        }

        return numOfLIS;
    }





	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequences obj = new NumberOfLongestIncreasingSubsequences();
		int[] arr = {1,2,3,5,4,7};
		System.out.println(obj.longestIncSubSequence(arr));
	}

}