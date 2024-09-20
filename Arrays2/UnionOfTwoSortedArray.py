
# approach 1: compare both array , if arr1 do not contain element of arr2 , sort the element Time: O(N) + O(NlogN), Space: O(1) 
# approach 2: using 2 pointer , compare each element  Time: O(N), Space: O(n)


def UnionOfTwoSortedArray1(arr1, arr2):
	for j in range(0, len(arr2)):
		if arr2[j] not in arr1:
			arr1.append(arr2[j])

	arr1.sort()
	return arr1


def UnionOfTwoSortedArray2(arr1, arr2):
	result = [] #set
	i=0
	j=0

	while(i<len(arr1) and j<len(arr2)):
		if arr1[i] == arr2[j]:
			if not result or result[-1] != arr1[i]:
				result.append(arr1[i])
			i+=1
			j+=1
		elif arr1[i] < arr2[j]:
			if not result or result[-1] != arr1[i]:
				result.append(arr1[i])
			i+=1
		else:
			if not result or result[-1] != arr2[j]:
				result.append(arr2[j])
			j+=1


	while(i<len(arr1) ):
		if not result or result[-1] != arr1[i]:
			result.append(arr1[i])
			i+=1


	while(j<len(arr2)):
		 if not result or result[-1] != arr2[j]:
				result.append(arr2[j])
				j+=1

	return result



print(UnionOfTwoSortedArray1([1,2,3,4,5], [2,2,2,2,2,3,4,4,5]))
print(UnionOfTwoSortedArray1([1,2,3,4,5,6,8,9,10], [2,3,4,4,5,7,11,12]))
print(UnionOfTwoSortedArray2([1,2,3,4,5], [2,2,2,2,2,3,4,4,5]))
print(UnionOfTwoSortedArray2([1,2,3,4,5,6,8,9,10], [2,3,4,4,5,7,11,12]))