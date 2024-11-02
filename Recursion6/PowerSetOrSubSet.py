# power set

class PowerSetOrSubSet:

    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for num in nums:
            newSubset = [cur  + [num] for cur in result]
            result.extend(newSubset)

        return result


# subset
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.powerset(0, nums, [], result)
        return result

    def powerset(self, i, nums, aux, result):
        if i==len(nums):
            result.append(aux[:])
            return

        aux.append(nums[i])
        self.powerset(i+1, nums, aux, result)
        aux.pop()
        self.powerset(i + 1, nums, aux, result)

    

        