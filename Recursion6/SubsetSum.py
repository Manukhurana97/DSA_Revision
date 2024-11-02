def SubsetSumHelper(arr, index, sum, result):
	if index == len(arr):
		result.append(sum)
		return

	SubsetSumHelper(arr, index + 1, sum + arr[index], result)
	SubsetSumHelper(arr, index + 1, sum, result)

def SubsetSum(arr):
	result = []
	SubsetSumHelper(arr, 0, 0, result)
	result.sort()
	return result



# -----------------------------------------------------------------------------


	def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for num in nums:
            newSubset = [cur  + [num] for cur in result]
            result.extend(newSubset)

        return result


arr = [2,3]
print(SubsetSum(arr))