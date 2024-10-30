# Time: O(N^3), Space: O(1)
def maxProductSubArray(arr):
	maxProduct = float('-inf')
	for i in range(len(arr)):
		for j in range(i+1, len(arr)):
			productTillNow  = 1
			for k in range(i, j+1):
				productTillNow *= arr[k]
				maxProduct = max(maxProduct, productTillNow)

	return maxProduct

# Time: O(N^2), Space: O(1)
def maxProductSubArray1(arr):
	maxProduct = float('-inf')
	for i in range(len(arr)):
		productTillNow = arr[i]
		for j in range(i+1, len(arr)):
			productTillNow *= arr[j]
			maxProduct = max(maxProduct, productTillNow)

	return maxProduct



# Time: O(N), Space: O(1)
def maxProductSubArray1(arr):
	maxProduct = arr[0]
	minProduct = arr[0]
	result = arr[0]
	
	for i in range(1, len(arr)):

		if arr[i] == 0:
			maxProduct = 1
			minProduct = 1
			result = max(result, 0)
			continue

		tempMax = maxProduct * arr[i]
		tempMin = minProduct * arr[i]
		
		maxProduct = max(arr[i], tempMax, tempMin)
		minProduct = max(arr[i], tempMin, tempMin)

		result = max(maxProduct, minProduct)
		

	return maxProduct


def maxProductSubArray2(arr):
    if not arr:
        return 0

    maxProduct = minProduct = result = arr[0]

    for i in range(1, len(arr)):
        if arr[i] < 0:
            maxProduct, minProduct = minProduct, maxProduct

        minProduct = min(arr[i], minProduct * arr[i])
        maxProduct = max(arr[i], maxProduct * arr[i])

        result = max(result, maxProduct)

    return result


def maxProduct(self, nums: List[int]) -> int:
    prefix, sufix = 1,1
    maxResult = max(nums)

    for i in range(0, len(nums)):
        prefix  = (prefix or 1) * nums[i]
        sufix = (sufix or 1) * nums[-1 - i]
        
        maxResult = max(prefix, sufix, maxResult)

    return maxResult




print(maxProductSubArray([1,2,3,4,5,0]), end = ", ")
print(maxProductSubArray([1,2,-3,0,-4,-5]))

print(maxProductSubArray1([1,2,3,4,5,0]), end = ", ")
print(maxProductSubArray1([1,2,-3,0,-4,-5]))

print(maxProductSubArray2([1,2,3,4,5,0]), end = ", ")
print(maxProductSubArray2([1,2,-3,0,-4,-5]))

