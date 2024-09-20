
def getPivot(arr, low, high):
	j = low
	pivot = arr[high]
	for i in range(low, high):
		if arr[i] <= pivot:
			arr[j], arr[i] = arr[i], arr[j]
			j += 1
	arr[j], arr[high] = arr[high], arr[j]

	return j



def QuickSort(arr, start, end):
	if start>=end: return arr;

	pivotIndex = getPivot(arr, start, end)
	QuickSort(arr, start, pivotIndex - 1)
	QuickSort(arr, pivotIndex + 1, end)

	return arr
	



arr = [5,8,3,2,1]
print(QuickSort(arr, 0, len(arr) - 1))
