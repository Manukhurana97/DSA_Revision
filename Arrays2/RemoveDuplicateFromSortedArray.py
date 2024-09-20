
# approach : create an aux array, and check the prev element 

def removeDuplicateFromSortedArray1(arr):
	aux = [arr[0]]
	prev = arr[0]

	for i in range(1, len(arr)-1):
		if prev != arr[i]:
			aux.append(arr[i])
			prev = arr[i]


	return aux


def removeDuplicateFromSortedArray2(arr):
	if not arr: 
		return []

	ind = 1;
	for i in range(1, len(arr) - 1):
		if arr[i - 1] != arr[i]:
			arr[ind] = arr[i];
			ind += 1;

	return arr[: ind]

print(removeDuplicateFromSortedArray1([1,1,1,2,2,3,3,3,3,4,4]))
print(removeDuplicateFromSortedArray2([1,1,1,2,2,3,3,3,3,4,4]))
