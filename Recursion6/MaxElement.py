def getMaxElement(arr, n):
	if(n == 0): return arr[0]
		
	no = getMaxElement(arr, n-1)

	return max(no, arr[n-1])



arr = [1,2,3,7,4,5,11]
print(getMaxElement(arr, len(arr)))