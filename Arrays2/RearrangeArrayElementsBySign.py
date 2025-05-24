# user 2 for loop , first for loop to check if the element is in position and second is to get the element in position ,
# Time : O(N^2) , Space O(1)
def rearrangeArrayElementsBySign1(arr):
	for i in range(len(arr)):
		if(i % 2 == 0 and arr[i] < 0):
			for j in range(i, len(arr)):
				if arr[j]>0 :
					arr[i], arr[j] = arr[j], arr[i]
		elif(i % 2 == 1 and arr[i] > 0):
			for j in range(i, len(arr)):
				if arr[j]<0:
					arr[i], arr[j] = arr[j], arr[i]

	return arr


# use 2 array for storing positive and negative element, run a for loop and store both positive and negative element, run a loop again and to place the element in place
# Time : O(2N) , Space O(N)
def rearrangeArrayElementsBySign2(arr):
	pos = [] # n/2
	neg = [] # n/2

	for i in arr:
		if i>0:pos.append(i)
		else: neg.append(i)

	for i in range(len(arr)):
		if(i%2==0): arr[i] = pos[i//2]
		else: arr[i] = neg[(i//2)]

	return arr


# instead of 2 arr use 1 array and do same as in above , Time: O(N) Space: O(N)
def rearrangeArrayElementsBySign3(arr):
	res = [0] * len(arr)

	posIndex = 0
	negIndex = 1;
	for i in range(len(arr)):
		if arr[i] >0:
			res[posIndex] = arr[i]
			posIndex+=2
		else:
			res[negIndex] = arr[i]
			negIndex+=2
	return res


def rearrangeArrayElementsBySign4(arr):
	posIndex = 0
	negIndex = 1
	n = len(arr)
	
	for i in range(n):
		if(arr[i]>0 and posIndex<n):
			arr[posIndex], arr[i] = arr[i], arr[posIndex]
			# arr.insert(posIndex, arr.pop(i))
			posIndex+=2
		elif arr[i]<0 and negIndex<n:
			# arr.insert(negIndex, arr.pop(i))
			arr[negIndex], arr[i] = arr[i], arr[negIndex]
			negIndex+=2

	return arr




print(rearrangeArrayElementsBySign1([1,2,-4,-5]))
print(rearrangeArrayElementsBySign2([1,2,-4,-5]))
print(rearrangeArrayElementsBySign3([1,2,-4,-5]))
print(rearrangeArrayElementsBySign4([1,2,-4,-5]))