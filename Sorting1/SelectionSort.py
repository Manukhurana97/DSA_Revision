# selection sort: selecting and comparing the element and moving the smallest element in start 

def selectionSort(arr):

	for i in range(0, len(arr)):
		ind = i
		for j in range(i+1, len(arr)):
			if arr[j]<arr[ind]:
				ind = j;
		if ind != i:
			arr[i], arr[ind] = arr[ind], arr[i]
	return arr;


print(selectionSort([5,4,3,2,1]))
