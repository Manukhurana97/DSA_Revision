# https://leetcode.com/problems/max-consecutive-ones/description/

from typing import List

class MaximumConsecutiveOnce3:
	
	def longestOnes(self, nums: List[int], k: int) -> int:
        i = j = 0
        n = len(nums)

        if(k == n) : return n

        maxOnes = 0;

        while j < n:
            if nums[j] == 0: k-=1

            while k < 0:
                if nums[i] == 0: k+=1
                i+=1
            
            
            maxOnes = max(maxOnes, j - i + 1)
            j+=1

        return maxOnes
            

    def findMaxConsecutiveOnes1(self, nums: List[int]) -> int:
        once = maxOnce = 0;
        

        for i in nums:
            if i == 1:
                once+=1;
                maxOnce = max(once, maxOnce)
            else:
                once = 0;
        return maxOnce



nums = [1, 1, 0, 0, 1, 1, 0, 1, 1, 1]
k = 2
obj = MaximumConsecutiveOnce3()
result = obj.longestOnes(nums, k)
print(result)  # Output: 6