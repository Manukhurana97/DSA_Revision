from typing import List

# Time: O(N^2), Space O(1)
def RearrangeArrayElementBySign(arr):
	for i in range(len(arr)):
		if i%2 == 0:
			if arr[i] < 0:
				flag = False
				for j in range(i, len(arr)):
					if arr[j] > 0 :
						flag = True
						arr[i], arr[j] = arr[j], arr[i]
						break;
				if flag == False:
					break
		else:
			if arr[i]>0:
				flag = False
				for j in range(i, len(arr)):
					if arr[j] < 0 :
						flag = True
						arr[i], arr[j] = arr[j], arr[i]
						break
				if flag == False:
					break
	return arr

		

# Time: O(N), Space O(N)
def RearrangeArrayElementBySign2(arr: List[int])-> List[int]:
	
	pos = []
	neg = []

	for i in arr:
		if i<0: neg.append(i)
		else: pos.append(i)

	i = j = ind = 0
	arr = []

	while i<len(pos) and j<len(neg):
		if ind%2 == 0: 
			arr.append(pos[i])
			ind+=1
			i+=1

		else:
			arr.append(neg[j])
			ind += 1
			j += 1

	while i<len(pos):
		arr.append(pos[i])
		i+=1
	while j < len(neg):
		arr.append(neg[j])
		j += 1

	return arr



# Time: O(N), Space O(1)
def RearrangeArrayElementBySign3(arr):
	n = len(arr)
	pos = 0
	neg = 1

	while pos<n and neg<n:
		while pos < n and arr[pos]>=0:
			pos += 2
		while neg < n and arr[neg]<0:
			neg+=2

		if pos<n and neg < n:
			arr[pos], arr[neg] = arr[neg], arr[pos]

	return arr




print("1 ",RearrangeArrayElementBySign([1,2,-4,-5]))
print("1 ",RearrangeArrayElementBySign([1,2,-3,-1,-2,-3]))


print("2 ",RearrangeArrayElementBySign2([1,2,-4,-5]))
print("2 ",RearrangeArrayElementBySign2([1,2,-3,-1,-2,-3]))


print("3 ",RearrangeArrayElementBySign3([1,2,-4,-5]))
print("3 ",RearrangeArrayElementBySign3([1,2,-3,-1,-2,-3]))