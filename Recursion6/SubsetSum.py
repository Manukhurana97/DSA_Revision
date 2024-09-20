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


arr = [2,3]
print(SubsetSum(arr))