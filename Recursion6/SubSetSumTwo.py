from typing import List

class subsetSum:
    def subsetsWithDupHelper(self, nums, index, arr, result):
        if index == len(nums):
            if arr not in result:
                result.append(arr.copy())
            return
        
        arr.append(nums[index])
        self.subsetsWithDupHelper(nums, index + 1, arr, result)
        arr.pop(-1)
        self.subsetsWithDupHelper(nums, index + 1, arr, result)


    def subsetsWithDupHelper1(self, nums, index, arr, result):
        if index == len(nums):
            result.append(arr.copy())
            
        
        for i in range(index, len(nums)):
            if i>index and nums[i-1] == nums[i] : continue
            
            arr.append(nums[i])
            self.subsetsWithDupHelper1(nums, i + 1, arr, result)
            arr.pop(-1)



    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        result = []
        # nums.sort()
        self.subsetsWithDupHelper1(nums, 0, [], result)
        return result


nums = [1, 2, 2]
obj = subsetSum()
print(obj.subsetsWithDup(nums))
