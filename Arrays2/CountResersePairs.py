
# Time: O(N^2), Space O(1)
def countReversePairs(arr):
	
	count = 0

	for i in range(len(arr)):
		for j in range(i+1, len(arr)):
			count += 1 if(arr[i]>2*arr[j]) else 0

	return count





print(countReversePairs([1,3,2,3,1]))