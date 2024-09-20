def CountSequencesWithSumK(arr, k, i , n):
	if i == n: return 1 if k == 0 else 0 


	count = 0;
	count += CountSequencesWithSumK(arr, k - arr[i], i + 1, n)
	count += CountSequencesWithSumK(arr, k, i + 1, n)
	return count
			
def printSebsequenceWithSumK(arr, k, i, n, result):
	if i == n: 
		if k == 0:
			print(result)
		return 


	result.append(arr[i])
	printSebsequenceWithSumK(arr, k - arr[i], i + 1, n, result)
	result.pop(-1)
	printSebsequenceWithSumK(arr, k, i + 1, n, result)


arr = [1,2,3,4,5]
print("count: ", CountSequencesWithSumK(arr, 6, 0, len(arr)))
printSebsequenceWithSumK(arr, 6, 0, len(arr), [])
