# use 2 pointer 
# Time O(N * MlogM), Space O(1)
def merge2SortedArrayWithoutExtraSpace(arr1, arr2):
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


	

# # shell sort
# def merge2SortedArrayWithoutExtraSpaceV2(arr1, arr2):



# [1,4,8,10], [2,3,9] :- [1,2,8,10], [4,3,9]  :- [1,2,3,10], [4,3,9]



merge2SortedArrayWithoutExtraSpace([1,4,8,10], [2,3,9])
merge2SortedArrayWithoutExtraSpaceV2([1,4,8,10], [2,3,9])

