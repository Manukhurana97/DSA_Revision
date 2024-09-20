# bubble sort: comparing each element and moving larger element in back

def bubbleSort(arr):
	for i in range (0, len(arr)):
		for j in range (1, len(arr)-i):
			if arr[j-1]>arr[j]:
				arr[j-1], arr[j] = arr[j], arr[j-1];
	return arr;

print(bubbleSort([5,4,3,2,1]))