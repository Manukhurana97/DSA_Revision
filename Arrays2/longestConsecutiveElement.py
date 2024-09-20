
# Space: O(N^2), Time: O(1)
def longestConsecutiveElement(arr):
	largestSequence = 0;

	for i in range(0, len(arr)):
		prev = arr[i]
		count = 1
		for j in range(i+1, len(arr)):
			if prev > arr[j]:
				break

			count+=1
			prev = arr[j]

		largestSequence = max(largestSequence, count)
	return largestSequence


# Space: O(NlogN), Time: O(1)
def longestConsecutiveElement1(arr):
	arr.sort()

	longestSeq = 1
	currentSeq = 1
	for i in range(1, len(arr)):		
		if (arr[i-1] +1) != arr[i]:
			longestSeq = max(longestSeq, currentSeq)
			currentSeq = 0;
		currentSeq+=1
	longestSeq = max(longestSeq, currentSeq)

	return longestSeq

# Space: O(N), Time: O(1)
def longestConsecutiveElement2(arr):
	largestSequence = 1;
	i=1
	j=0
	n=len(arr)

	while(i < n):
		if arr[i] < arr[i - 1]:
			largestSequence = max(largestSequence, i-j)
			j=i # reset start
		i+=1

	largestSequence = max(largestSequence, i-j)
	return largestSequence




print(longestConsecutiveElement([100,200,1,2,3,4,]))
print(longestConsecutiveElement1([100,200,1,2,3,4,]))
print(longestConsecutiveElement2([100,200,1,2,3,4,]))