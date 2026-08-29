// https://leetcode.com/problems/maximum-subarray

class MaximumSubarray:
	def maxSubArray(self, nums: List[int]) -> int:
        result = prev = nums[0]

        for i in range(1, len(nums)):
           prev = max(prev + nums[i], nums[i])
           result = max(result, prev)
        return result