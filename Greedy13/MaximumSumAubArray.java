// https://leetcode.com/problems/maximum-subarray

// kadenes algo
public class MaximumSumAubArray{

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            sum = Math.max(nums[i], sum+nums[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

}