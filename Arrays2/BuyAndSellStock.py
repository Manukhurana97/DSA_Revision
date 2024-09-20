
# run 2 for loop and compare the element and find the max diff pair, Time: O(N^2), Space: O(1)
def maxProfit1(prices) -> int:
	maxProfit = 0
	for i in range(len(prices)):
		for j in range(i, len(prices)):
			if i!=j and j>i:
				maxProfit = max(maxProfit, prices[j]-prices[i])
	return maxProfit


# find the max array (from reverse), Time: O(2N), Space: O(n)
def maxProfit2(prices) -> int:
	maxArr = [0] * len(prices)
	maxTillNow = 0

	for i in range(len(prices)-1, -1, -1):
		if prices[i] > maxTillNow:
			maxTillNow = prices[i] 
		maxArr[i] = maxTillNow 


	# calculate difference 
	maxProfit = 0
	for i in range(0, len(prices)):
		maxProfit = max(maxProfit, (maxArr[i] - prices[i]))

	return maxProfit

# get the index of min and max element: Time O(N), Space O(1)
def maxProfit3(prices) -> int:
	minTillNow  = 0
	maxTillNow = 0
	result = 0
	for current in range(len(prices)):
		if(prices[current]<prices[minTillNow]):
			minTillNow = current
			if(maxTillNow<minTillNow):
				maxTillNow = minTillNow
		if(prices[current]>prices[maxTillNow]):
			maxTillNow = current

		result = max(result, (prices[maxTillNow] - prices[minTillNow]))
	return result

# kadenes algo
def maxProfit4(prices) -> int:
	minTillNow  = prices[0]
	maxTillNow = 0
	
	for price in prices:
		minTillNow = min(minTillNow, price)
		maxTillNow = max(maxTillNow, price-minTillNow)		

	return maxTillNow
		

print(maxProfit1([7,1,5,3,6,4]), end = ", ")
print(maxProfit2([7,1,5,3,6,4]), end = ", ")
print(maxProfit2([1,2]), end = ", ")
print(maxProfit3([7,1,5,3,6,4]), end = ", ")
print(maxProfit3([1,2]), end = ", ")
print(maxProfit4([7,1,5,3,6,4]), end = ", ")