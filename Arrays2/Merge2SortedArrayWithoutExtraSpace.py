import math

# use 2 pointer 
# Time O(N * MlogM), Space O(1)
def merge2SortedArrayWithoutExtraSpaceV1(arr1, arr2):
	i = 0
	n = len(arr1)
	m = len(arr2)

	while i < n:
		if arr1[i]>arr2[0]:
			arr1[i], arr2[0] = arr2[0], arr1[i]
			arr2.sort() # sort, so that the first element is always smallest in n2
		
		i+=1
	print(arr1, arr2)



# use 2 pointer 
# Time O(N*M), Space O(1)
def merge2SortedArrayWithoutExtraSpaceV2(arr1, arr2):
	i = 0

	while i < len(arr1):
		if arr1[i]>arr2[0]:
			arr1[i], arr2[0] = arr2[0], arr1[i]
			
			j = 0
			first = arr2[j]
			while j < len(arr2) - 1 and arr2[j + 1] < first:
				arr2[j] = arr2[j + 1]
				j+=1
			arr2[j] = first

		i+=1

	print(arr1, arr2) 


	

# shell sort
def merge2SortedArrayWithoutExtraSpaceV3(arr1, arr2):
	n, m = len(arr1), len(arr2)
	gap = next_gap(n + m)

	while gap > 0:
		i = 0
		# compare the element in first array
		while i + gap < n:
			if arr1[i] > arr1[i + gap]:
				arr1[i], arr1[i + gap] = arr1[i + gap], arr1[i]
			i+=1;

		# # comparing element b/w arr1 and arr2
		j = gap - n if gap > n else 0
		while i < n and j < m:
			if arr1[i] > arr2[j]:
				arr1[i], arr2[j] = arr2[j], arr1[i]
			i+=1
			j+=1

		# # compare the element in first array
		if j<m:
			j = 0
			while j + gap < m:
				if arr2[j] > arr2[j+gap]:
					arr2[j], arr2[j+gap] = arr2[j+gap], arr2[j]
				j += 1

		gap = next_gap(gap)

		
	print(arr1+arr2)


def next_gap(l):
	if l <= 1:
		return 0

	return math.ceil(l/2)




# [1,4,8,10], [2,3,9] :- [1,2,8,10], [4,3,9]  :- [1,2,3,10], [4,3,9]



merge2SortedArrayWithoutExtraSpaceV1([1,4,8,10], [2,3,9])
merge2SortedArrayWithoutExtraSpaceV2([1,4,8,10], [2,3,9])
merge2SortedArrayWithoutExtraSpaceV3([1,4,8,10], [2,3,9])

