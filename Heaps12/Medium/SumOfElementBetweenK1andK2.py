import heapq

class SumOfElementBetweenK1andK2:

	def getElemets(self, arr, k1, k2):
		b = self.getKthElemets(arr, k1)
		a = self.getKthElemets(arr, k2)

		result = [i for i in arr if a< i<b]

		return result

	def getKthElemets(self, arr, k):
		queue = []

		for i in arr:
			heapq.heappush(queue, i)

			if len(queue) >= k:
				heapq.heappop(queue);

		return heapq.heappop(queue);

obj = SumOfElementBetweenK1andK2()
arr = [1,3,16,65,15,11]
print(obj.getElemets(arr, 3, 6))

# 