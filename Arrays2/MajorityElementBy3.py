# Space: O(n^2), Time: O(1)
def majorityElement(arr):
	for i in range(len(arr)):
		count=0
		for j in range(len(arr)):
			if arr[j] == arr[i]:
				count+=1


		if count > len(arr) // 3:
			return arr[i]

	return -1


# Space: O(NlogN), Time: O(1)
def majorityElement1(arr):
	arr.sort()

	count = 1
	prev = arr[0]
	for i in range(1, len(arr)):
		if arr[i] == prev:
			count+=1
		else:
			if count>len(arr)//3:
				return prev
			else:
				count = 1
				prev = arr[i]
	return -1				


# Time: O(n) , Space O(n)
def majorityElement2(arr):
	n = len(arr)
	aux = {}

	for i in range(n):
		if arr[i] in aux: 
			aux[arr[i]] +=1
			if aux[arr[i]] > n // 3:
				return arr[i]
		else: 
			aux[i] = 1

	return -1


# Time: O(n), Space O(1) : moose voting algo
# there are 2 element who can have value == /3
def majorityElement3(arr):
	el1 = el2 = c1 = c2 = 0

	for i in arr:
		if c1 == 0 and i != el2:
			el1 = i
			c1 = 1
		elif c2 == 0 and i != el1:
			el2 = i
			c2 = 1
		elif i == el1:
			c1 += 1
		elif i == el2:
			c2 += 1
		else:
			c1 -= 1
			c2 -= 1

	result = []

	c1 = c2 = 0

	for i in arr:
		if i == el1:
			c1 += 1
		if i == el2:
			c2 += 1

	n = len(arr)//3
	if c1>n:
		result.append(el1)
	if c2>=n:
		result.append(el2)

	return result 







print(majorityElement([1,2,2,3,2]))
print(majorityElement1([1,2,2,3,2]))
print(majorityElement2([1,2,2,3,2]))
print(majorityElement3([1,2,2,3,2]))