def SortArray(arr, start, end):
	if start >= end: 
		return arr

	arr[start], arr[end] = arr[end], arr[start]

	return SortArray(arr, start + 1, end -1)


def SortArray1(arr, n):
	if n <=1: return 

	SortArray1(arr, n-1)

	last = arr[n-1]
	j = n-2

	while j >= 0 and arr[j] > last:
		arr[j+1] = arr[j]
		j-=1
	arr[j + 1] = last


def SortArray2(arr,  n):
	if n <= 1: retu<n 


	SortArray2(arr, n-1)

	if arr[n-1] < arr[n-2]:
		arr[n-1], arr[n-2] = arr[n-2], arr[n-1]


# [4, 5, 3, 2, 1] 
# [3, 4, 5, 2, 1]
# [2, 3, 4, 5, 1]
# [1, 2, 3, 4, 5]
# [1, 2, 3, 4, 5]


	


arr = [5,4,3,2,1]
# SortArray(arr, 0, len(arr)-1)
# SortArray1(arr, len(arr))
SortArray2(arr, len(arr))
print(arr)
