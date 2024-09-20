# // consider the element on first or last as the piviot element 
# // move all the element smaller from pivot to left and greater to right
# // move the pivot to its place
# // repeat this process for all the left and right element

# // 7,2,3,6,4
# // pivot: 4 :  2,7,3,6,4 :: 2,



def quickSort(low, high, arr):
	if(low <= high):
		index = findPivotElement(low, high, arr)	
		quickSort(low, index - 1, arr)
		quickSort(index + 1, high, arr)
	return arr

	

def findPivotElement(low, high, arr):
	j = low - 1
	pivot = arr[high]
	for i in range(low, high):
		if(arr[i]<pivot):
			arr[j + 1], arr[i] = arr[i], arr[j + 1]
			j += 1
	
	# move the pivot to its place
	arr[j + 1], arr[high] = arr[high], arr[j + 1 ]
	return j + 1



print(quickSort(0, 4, [1, 7,2,3,6,4]))






