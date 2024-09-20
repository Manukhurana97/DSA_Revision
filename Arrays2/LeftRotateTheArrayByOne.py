# approach 1 : take the first element in aux , move each element on left, copy the aux element in last

def LeftRotateTheArrayByOne1(arr, k): 
	
	for i in range(0, k):
		arr = rotateElementOnLeftByOne1(arr)
	return arr


def rotateElementOnLeftByOne1(arr):
	aux = arr[0]
	for i in range(1, len(arr)):
		arr[i-1] = arr[i]

	arr[len(arr)-1] = aux
	return arr; 


def LeftRotateTheArrayByOne2(arr, k):
	arr = arr + arr[:k]
	return arr[k:]

print(LeftRotateTheArrayByOne1([1,2,3,4,5], 2))
print(LeftRotateTheArrayByOne2([1,2,3,4,5], 2))
