from typing import List
class AllPermutations:
    def permuteHelper1(self, nums, index, arr, result, used_set):
        if index == len(nums):
            result.append(arr.copy())
            return
        
        for i in range( len(nums)):
            if i not in used_set:
                used_set.add(i)
                arr.append(nums[i])
                self.permuteHelper1(nums, index + 1, arr, result, used_set)
                used_set.remove(i)
                arr.pop()
                
    def permute1(self, nums: List[int]) -> List[List[int]]:
        result = []
        used_set = set()
        self.permuteHelper1(nums, 0, [], result, used_set)
        return result



    # ------------------------------------------------------------------------------------


    def permuteHelper2(self, nums, index, arr, result):
        if index == len(nums):
            result.append(nums.copy())
            return
        
        for i in range(index, len(nums)):
            nums[i], nums[index] = nums[index], nums[i]
            self.permuteHelper2(nums, index + 1, arr, result)
            nums[i], nums[index] = nums[index], nums[i]
                    
                


    def permute2(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.permuteHelper2(nums, 0, [], result)
        return result


input = [1,2,3]
obj = AllPermutations()
print(obj.permute1(input))
print(obj.permute2(input))