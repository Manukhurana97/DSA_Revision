def merge(arr, start, mid, end, count):
	i = start
	j = mid+1
	result = []

	while i <= mid and j <= end:
		if arr[i] < arr[j]:
			result.append(arr[i])
			i += 1
		else:
			count += mid - i + 1
			result.append(arr[j])
			j += 1

	while i <= mid:
		result.append(arr[i])
		i += 1

	while j <= end:
		result.append(arr[j])
		j += 1

	for i in range(len(result)):
		arr[start+i] = result[i]

	return count



def divide(arr, start, end, count):
	if start >= end: return count

	mid = (start + end) // 2
	count = divide(arr, start, mid, count)
	count = divide(arr, mid + 1, end, count)
	return merge(arr, start, mid, end, count)

	


def CountInversion(arr):
	return divide(arr, 0, len(arr)-1, 0)
	

arr = [5, 3, 2, 4, 1]
print(CountInversion(arr))
