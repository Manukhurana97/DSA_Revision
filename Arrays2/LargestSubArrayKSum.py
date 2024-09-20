# approach 1: create 2 form loop and get the sum from 1 to i to n-1 if sum math k get the size, return the max size Time O(n^2), Space O(1)
# approach 2: using hashMap , Time O(n), Space O(n)
# approach 3: using 2 pointer , Time O(n), Space O(1)

def largestSubArrayKSum1(arr, k):
	max_len = 0
	for i in range(len(arr)):
		sum = arr[i];
		max_len = max(max_len,1)
		for j in range(i+1, len(arr)):
			sum+=arr[j]	
			if(sum == k):
				max_len = max(max_len, (j-i+1))

	return max_len


def largestSubArrayKSum2(arr, k):
	map = {}
	sum=0
	max_len = 0
	for i in range(0, len(arr)):
		sum+=arr[i]

		if(arr[i] == k):
			max_len = max(max_len, 1)

		if(sum == k):
			max_len = max(max_len,i+1)

		if (k-sum) in map:
			max_len = max(max_len, i-map[k-sum])

		if(sum) not in map:
			map[sum]=i;

	return max_len


def largestSubArrayKSum3(arr: [int], k: int) ->int:
	i = 0
	j = 0
	sum = arr[0]
	max_len = 0;

	while(j<len(arr)):

		while i <= j and sum > k :
			sum -= arr[i]
			i+=1;
		
		if sum == k: max_len = max(max_len, j - i + 1)
		
		sum+=arr[j]
		j+=1

	return max_len

	


print(largestSubArrayKSum1([2,3,5,1,9], 10))
print(largestSubArrayKSum2([2,3,5,1,9], 10))
print(largestSubArrayKSum3([2,3,5,1,9], 10))