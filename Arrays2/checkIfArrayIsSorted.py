def checkIfArrayIsSorted(arr):
	prev = arr[0]
	for i in range(1, len(arr)):
		if(prev>arr[i]) :
			return False;
		else:
			prev = arr[i]
	return True

print(checkIfArrayIsSorted([1,2,3,4,5,4]))