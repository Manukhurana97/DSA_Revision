from heapq import heappush, heappop


# approach 1: sort the array and get the 2 last element : Time: O(n log n), Space: O(1)
def SecondLargest1(arr):
	if(len(arr)>1):
		arr.sort()
		return arr[len(arr)-2]
	return -1


# approach 2: create a priority queue and store only 2 element, after all the element is parse, the top element is 2 largest elmnt : Time O(N log k), Space: O(log 2)
def SecondLargest2(arr):
	# head / priority queue
	h = []
	for i in arr:
		heappush(h, i)
		if(len(h)>2):
			heappop(h)
	return h[0]

# approach 3: find the first largest element , the again find the largest element but this time it need to be less then first largest : O(2N) Space: O(1)
def findlargestElement(arr, smallerthen):
	largestElement = -10**9;
	for i in arr: 
		if i<smallerthen:
			largestElement = max(i, largestElement)
	return largestElement


def SecondLargest3(arr):
	firstLarger = findlargestElement(arr, 10**9)
	return findlargestElement(arr, firstLarger)



# approach 4: in one pass compare both element : O(2N) Space: O(1)
def SecondLargest4(arr):
	larger = arr[0]
	secLarger = -1;

	for i in arr:
		if(i>larger):
			secLarger = larger
			larger = i
		elif(i<larger and i> secLarger):
			secLarger = i
		


	return secLarger;


print(SecondLargest1([2,5,1,3,0]))
print(SecondLargest2([2,5,1,3,0]))
print(SecondLargest3([2,5,1,3,0]))
print(SecondLargest4([2,5,1,3,0]))



