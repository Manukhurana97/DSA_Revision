# Insertion sort: considering fist element is sorted and comparing other with first n sorted element

def InsertionSort(arr):
	for i in range(1, len(arr)):
	 	curr = arr[i]
	 	j = i-1;
	 	while(j>=0 and arr[j]>curr):
	 		arr[j+1] = arr[j]
	 		j-=1;
	 	arr[j+1] = curr

	return arr


print(InsertionSort([5,4,3,2,1]))