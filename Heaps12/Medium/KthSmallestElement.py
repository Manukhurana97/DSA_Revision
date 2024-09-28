import heapq

class KthSmallestElement:
	def kthSmallest(self, arr, k):
		pQueue = [];

		for i in arr:
			heapq.heappush(pQueue, -i)

			if len(pQueue) > k:
				heapq.heappop(pQueue)


		return -heapq.heappop(pQueue)

obj = KthSmallestElement();

arr = [1,2,3,4,5,6,7,8,9]
print(obj.kthSmallest(arr, 3))