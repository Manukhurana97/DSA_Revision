# use for loop and compare Time: O(n^2), Space: O(1)
def majorityElement1(arr):
	for i in range(len(arr)):
		count = 1
		for j in range(len(arr)):
			if(i != j and arr[i] == arr[j]):
				count+=1

		if(count >= len(arr)//2):
			return arr[i]
	return -1;


# create a map to store the count : Time: O(n), Space: O(n)
def majorityElement2(arr):
	n = len(arr)
	maxEL = max(i for i in arr)
	count = [0]*(maxEL+1)

	for i in arr:
		count[i]+=1
		if count[i] > n//2:
			return i
	return -1


# moorse voting algo
def majorityElement3(arr):
	n = len(arr)
	count = 0
	el = 0

	for i in range(0, n):
		if(count == 0):
			count = 1
			el = arr[i]
		elif(el == arr[i]):
			count+=1;
		else:
			count-=1

	count = 0;
	for i in arr:
		if(i==el): count += 1

	return el if count>(n//2) else -1

		



print(majorityElement1([2,2,1,1,1,2,2]))
print(majorityElement2([2,2,1,1,1,2,2]))
print(majorityElement3([2,2,1,1,1,2,2]))
