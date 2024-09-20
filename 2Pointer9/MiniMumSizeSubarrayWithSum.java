public class MiniMumSizeSubarrayWithSum{
	public int minSubArrayLen(int target, int[] nums) {
        long sum = 0;
        int right = 0, left = 0, n = nums.length, minSubArrSum = Integer.MAX_VALUE;;

        while(right < n){
            sum += nums[right];

            while(left <= right && sum > target){
                minSubArrSum = Math.min(minSubArrSum, (right - left + 1));
                sum -= nums[left++];
            }       

            right++;
        }

        return minSubArrSum == Integer.MAX_VALUE ? 0 : minSubArrSum;
    }
}