
# Time: O(N^2), Space O(1)
def countReversePairs(arr):
	
	count = 0

	for i in range(len(arr)):
		for j in range(i+1, len(arr)):
			count += 1 if(arr[i]>2*arr[j]) else 0

	return count

# ----------------------------------------------------------------------------------------------- 


def countReversePairs1(arr):
	return mergeSort(arr, 0, len(arr) - 1)

def mergeSort(arr, start, end):
	if start>=end: return 0

	mid = start + (end - start) // 2

	count = mergeSort(arr, start, mid)
	count += mergeSort(arr, mid+1, end)
	count += countWhileMerging(arr, start, mid, end)
	merge(arr, start, mid, end)
	return count

def countWhileMerging(arr, start, mid, end):
	count = 0
	j = mid+1
	for i in range(start, mid+1):
		while j<=end and arr[i]>2*arr[j]:
			j+=1;
		count = j - (mid+1)
	return count 


def merge(arr, start, mid, end):
	i, j = start, mid+1
	count = 0
	temp = []

	while i<=mid and j<=end:	
		if arr[i] < arr[j]:
			temp.append(arr[i])
			i+=1
		else:
			temp.append(arr[j])
			j+=1

	while i<=mid:
		temp.append(arr[i])
		i+=1

	while j<=end:
		temp.append(arr[j])
		j+=1


	for i in range(len(temp)):
		arr[i+start] = temp[i]

	return count





print(countReversePairs([1,3,2,3,1]))
print(countReversePairs1([1,3,2,3,1]))