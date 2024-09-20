def largestSubArrayWithSum(arr):

	result = []
	maxLen = 0
	
	for i in range(len(arr)):
		sum = arr[i]
		for j in range(i+1, len(arr)):
			sum+=arr[j]
			# aux = arr[i:j+1]
			# if sum == 0 and aux not in result:
				# maxLen = max(maxLen, len(aux))
				# result.append(aux)
			if(sum == 0):
				maxLen = max(maxLen, j-i+1)

	return maxLen


# intution: if total sum = n and first 5 terms sum is also n the n-5 (remaining terms) sum is 0
def largestSubArrayWithSum1(arr):

	map = {} # storing sum:index
	sum = 0
	maxLen = 0


	for current in range(len(arr)):
		sum += arr[current]

		if sum == 0 :
			maxLen = current+1
		elif sum in map:
			maxLen = max(maxLen, current - map[sum]) #max(maxLen,  n - 5)
		else:
			map[sum] = current
	return maxLen



print(largestSubArrayWithSum([9, -3, 3, -1, 6, -5]))
print(largestSubArrayWithSum1([9, -3, 3, -1, 6, -5]))