# approach: compare the current element with last if they are same, increase the count 

def maxOnces(arr):
	maxI = 0
	result = 0

	for i in range(len(arr)):
		if(arr[i]==1):
			maxI += 1
		else:
			maxI = 0
		result = max(result, maxI)

	return result


print(maxOnces([1,1,0,1,1,1]))