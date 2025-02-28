# https://leetcode.com/problems/subsets-ii/

from typing import List

class subsetSum:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        result = [[]]
        nums.sort()
        
        def recursion(i, list):
            if(i == n):
                if list not in result:
                    result.append(list[:])
                return


            
            list.append(nums[i])
            recursion(i+1, list)
            list.pop(-1);
            recursion(i+1, list)

        
        recursion(0, [])
        return result
        

    def subsetsWithDup1(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        result = []
        nums.sort()
        
        def recursion(i, list):
            result.append(list[:])


            for j in range(i, n):
                if j > i and nums[j] == nums[j-1]: continue 
                
                list.append(nums[j])
                recursion(j+1, list)
                list.pop(-1);

        
        recursion(0, [])
        return result


nums = [1, 2, 2]
obj = subsetSum()
print(obj.subsetsWithDup(nums))
