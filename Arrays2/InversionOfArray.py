import math


# Time: O(N^2), Space: O(1)
def inserversionOfArray(arr):
	count = 0

	for i in range(len(arr)):
		for j in range(i+1, len(arr)):
			count += 1 if arr[i] > arr[j] else 0

	return count


# merge sort
def inserversionOfArray1(arr):
	return mergeSort(arr, 0, len(arr)-1)



def mergeSort(arr, start, end):

	count = 0

	if(start<end):
		mid = math.floor((start + end) / 2)

		count+=mergeSort(arr, start, mid)
		count+=mergeSort(arr,  mid + 1, end)
		count+=merge(arr, start, mid, end)

	return count;


def merge(arr: [int], start: int, mid: int, end: int) -> int:

	i = start
	j = mid + 1
	count = 0
	temp = []

	while i<=mid and j<=end :
		if arr[i]<=arr[j]:
			temp.append(arr[i])
			i+=1
		else:
			count += (mid - i+1)
			temp.append(arr[j])
			j+=1

	while i<=mid:
		temp.append(arr[i])
		i+=1

	while j<=end :
		temp.append(arr[j])
		j+=1
		
	arr = temp
	temp.clear()

	return count;



	



print(inserversionOfArray([1,2,3,4,5]))
print(inserversionOfArray([5,4,3,2,1]))


print(inserversionOfArray1([1,2,3,4,5]))
print(inserversionOfArray1([5,4,3,2,1]))