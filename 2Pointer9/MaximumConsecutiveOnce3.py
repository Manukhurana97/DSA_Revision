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
            
            j+=1
            maxOnes = max(maxOnes, j - i)

        return maxOnes
            

nums = [1, 1, 0, 0, 1, 1, 0, 1, 1, 1]
k = 2
obj = MaximumConsecutiveOnce3()
result = obj.longestOnes(nums, k)
print(result)  # Output: 6