# run a 2 for loop, 1 to get the element and 2 to check if the highest element on right,
# Time O(N^2), Space : O(N)
def leaderInArray(arr):
	result = [0] * len(arr)

	for i in range(len(arr)):
		hasMaxElement = False
		for j in range(i+1, len(arr)):
			if arr[j] > arr[i]:
				hasMaxElement = True
				break
		if hasMaxElement==False:
			result[i] = arr[i]

	return result

# use a variable to keep the track of the greatest element till now
# Time O(N), Space O(N)
def leaderInArray2(arr):
	result = [0] * len(arr)
	maxTillNow = -float('inf')

	for i in range(len(arr)-1, -1, -1):
		if arr[i]>maxTillNow:
			maxTillNow = arr[i]
			result[i] = maxTillNow

	return result

print(leaderInArray([4,7,1,0]))
print(leaderInArray2([4,7,1,0]))

