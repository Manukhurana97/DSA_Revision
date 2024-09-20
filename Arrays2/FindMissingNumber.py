# approach 1: run a for loop on N size arr and  check which element is missing  Time : O(N^2), Space: O(1)
# approach 2: get the max element and run a for loop and get the sum of all the element and subtract the sum of arr element : Time : O(2N), Space: O(1)
# approach 3: get the max element and find the sum of n elemenrt -  sum of element of an arr  : Time : O(N), Space: O(1)


# Time: O(N^2)
def FindMissingNumber1(arr):
	for i in range (1, arr[-1]):
		if i not in arr:
			return i;
	return -1;


# Time: O(2N)
def FindMissingNumber2(arr):
	sum = 0
	for i in range(1, arr[-1]+1):
		sum+=i

	for j in arr:
		sum-=j

	return sum;


# Time: O(N)
def FindMissingNumber3(arr):
	sum = (arr[-1] * (arr[-1]+1))//2
	

	for j in arr:
		sum-=j

	return sum;




# print(FindMissingNumber1([1,2,4,5]))
print(FindMissingNumber2([1,2,4,5]))