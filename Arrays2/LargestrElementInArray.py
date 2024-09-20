# approach 1: search the array using linear search and find the element, Time: O(N), Space: O(1)
# approach 2: sort the array and get the last element, Time: O(NlogN), Space O(1)

# Time: O(N^2)
def largestElementInArray1(arr):
	largestElement = -10^9;
	for i in arr: 
		largestElement = max(i, largestElement)

	return largestElement;

# Time: O(NlogN)
def largestElementInArray2(arr):
	arr.sort()
	return arr[-1]



print(largestElementInArray1([2,5,1,3,0]))
print(largestElementInArray2([2,5,1,3,0]))
