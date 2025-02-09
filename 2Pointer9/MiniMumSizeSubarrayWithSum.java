// https://leetcode.com/problems/minimum-size-subarray-sum/

public class MiniMumSizeSubarrayWithSum{
	public int minSubArrayLen(int target, int[] nums) {
        
        int current = 0, start = 0, n = nums.length;
        int sum = 0, minLen = Integer.MAX_VALUE;

        while(current < n) {
            sum += nums[current];

            while(sum>=target && start<=current){
                minLen = Math.min(minLen, current-start+1);
                sum -= nums[start++];
            }

            current++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }
}