def sort(arr, start, mid, end):
	i = start
	j = mid+1
	result = []

	while i <= mid and j <= end:
		if arr[i] <= arr[j]:
			result.append(arr[i])
			i += 1
		else:
			result.append(arr[j])
			j += 1
	while i <= mid:
		result.append(arr[i])
		i += 1
	while j <= end:
		result.append(arr[j])
		j += 1

	for k in range(len(result)):
		arr[start + k] = result[k]

	return arr

	for k in range(len(arr)):
		arr[start + k] = result[k]



def mergeSort(arr, start, end):
	if start >= end: return arr

	mid = start + (end - start) // 2
	mergeSort(arr, start, mid)
	mergeSort(arr, mid + 1, end)
	sort(arr, start, mid, end)

	return arr
	



arr = [5,8,3,2,1]
print(mergeSort(arr, 0, len(arr)-1))