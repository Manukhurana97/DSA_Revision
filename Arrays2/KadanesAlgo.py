
# run 2 for loop and get the sum of each element and find the max, Time : O(N^2), Space O(1)
def kadanesAlgo1(arr):
	maxSum = 0
	for i in range(len(arr)):
		ss = arr[i]
		for j in range(i, len(arr)):
			if(i != j):
				ss+=arr[j]
				maxSum = max(maxSum, ss)
	return maxSum


# as soon as the sum <0 start again, else increment the sum
def kadanesAlgo2(arr):
	maxSum = 0
	ss = 0
	for i in range(len(arr)):
		ss += arr[i]

		maxSum = max(maxSum, ss)

		if(ss<0): ss=0
		
	return maxSum


# print the subarray
def kadanesAlgo3(arr):
	maxSum = 0
	noSum = 0
	startInd = 0
	endInd = 0
	for i in range(len(arr)):
		if noSum == 0: startInd = i
		noSum += arr[i]

		if noSum>maxSum:
			maxSum = noSum
			endInd = i

		if(noSum<0): noSum=0
		
	for i in range(startInd, endInd+1):
		print(arr[i], end = ", ")


print(kadanesAlgo1([-2,1,-3,4,-1,2,1,-5,4]))
print(kadanesAlgo2([-2,1,-3,4,-1,2,1,-5,4]))
kadanesAlgo3([-2,1,-3,4,-1,2,1,-5,4])