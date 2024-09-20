
# Time : O(2^n), Space : O(n) recursion space
def countSubArraySumEqualsK(arr, k):
	return countSubArraySumEqualsKRecurssion(0, 0, arr, k)


def countSubArraySumEqualsKRecurssion(sum,  i, arr, k):
	if i == len(arr):
		return 1 if sum == k else 0

	count = 0
	count += countSubArraySumEqualsKRecurssion(sum + arr[i], i + 1, arr, k)
	count += countSubArraySumEqualsKRecurssion(sum, i + 1, arr, k)
	return count

	

# Time : O(n^2), Space : O(1)
def countSubArraySumEqualsK1(arr, k):
	n = len(arr)
	count = 0
	for i in range(n):
		sum = 0
		for j in range(i, n):
			sum +=arr[j]

			if(sum == k): count+=1

	return count;

# using 2 pointer , so the sum and if the sum is greater the k , run a loop and remove the element till it beacame <=
# Time O(n), Space O(1)
def countSubArraySumEqualsK2(arr, k):

	n = len(arr)
	sum = 0
	count = 0
	left = 0
	right = 0

	while(right<n):
		sum += arr[right]

		while(sum > k and left <= right):
			sum-=arr[left]
			left+=1

		if(sum == k): count+=1

		right+=1

	return count



print(countSubArraySumEqualsK([3,1,2,4], 6))
print(countSubArraySumEqualsK([1,2,3], 3))


print(countSubArraySumEqualsK1([3,1,2,4], 6))
print(countSubArraySumEqualsK1([1,2,3], 3))


print(countSubArraySumEqualsK2([3,1,2,4], 6))
print(countSubArraySumEqualsK2([1,2,3], 3))