def CombinationSumTaking1Times(arr, k, ind, result):
	if ind == len(arr):
		if k == 0:
			print(result)
		return

	
	result.append(arr[ind]) # taking 
	CombinationSumTaking1Times(arr, k - arr[ind], ind + 1, result)
	result.pop(-1) # not taking
	CombinationSumTaking1Times(arr, k, ind + 1, result)

def CombinationSumTakingNTimes(arr, k, ind, result):
	if ind >= len(arr):
		if k == 0:
			print(result)
		return

	if k >= 0:
		result.append(arr[ind]) # taking 
		CombinationSumTakingNTimes(arr, k - arr[ind], ind, result)
		result.pop(-1) # not taking
	CombinationSumTakingNTimes(arr, k, ind + 1, result)


def CombinationSum(arr, k):
	# CombinationSumTaking1Times(arr, k, 0, [])
	CombinationSumTakingNTimes(arr, k, 0, [])

arr = [2,3,6,7]
CombinationSum(arr, 7)