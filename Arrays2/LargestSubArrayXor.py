from collections import defaultdict

# use 2 for loop and calculate the xor starting from each element

# Time: O(N^2), Space: O(1)
def largestXor(arr, k):

	largestXor = 0

	for i in range(len(arr)):
		xor = arr[i]

		if xor == k:
			largestXor = max(largestXor, 1)

		for j in range(i+1, len(arr)):
			xor^=arr[j]

			if xor == k:
				largestXor = max(largestXor, (j-i))
	return largestXor


def largestXorV2(arr, k):

	largestXor = 0
	xor = 0
	map = defaultdict(int)
	map[xor] = 1
	

	for i in range(len(arr)):
		xor ^= arr[i]
		rem = k^xor

		largestXor += map[rem]

		map[xor] += 1

	return  largestXor




print(largestXor([4,2,2,6,4], 6))
print(largestXorV2([4,2,2,6,4], 6))