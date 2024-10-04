import heapq

class ConnectRopes:

	def connectToMinimiseCost(self, arr):
		minQueue = []
		totalSum = 0

		# for i in arr: # o(nlogn)
		# 	heapq.heappush(minQueue, i)

		heapq.heapify(arr) # lo(n)
		minQueue = arr.copy()

		while len(minQueue) >=2: 
			cost = heapq.heappop(minQueue) + heapq.heappop(minQueue)
			totalSum += cost
			heapq.heappush(minQueue, cost)


		return totalSum

obj = ConnectRopes();
arr = [1,2,3,4,5]
print(obj.connectToMinimiseCost(arr))
