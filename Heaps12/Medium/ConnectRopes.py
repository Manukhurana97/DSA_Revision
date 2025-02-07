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



# --------------------------------------------------------------------------------------------------

# import java.util.PriorityQueue;

# class ConnectRopes {
#     public int connectToMinimiseCost(int[] arr) {
#         PriorityQueue<Integer> minQueue = new PriorityQueue<>();
#         int totalSum = 0;
        
#         // Add all elements to the min-heap
#         for (int num : arr) {
#             minQueue.offer(num);
#         }
        
#         // Process the heap until only one element remains
#         while (minQueue.size() >= 2) {
#             int cost = minQueue.poll() + minQueue.poll();
#             totalSum += cost;
#             minQueue.offer(cost);
#         }
        
#         return totalSum;
#     }
    
#     public static void main(String[] args) {
#         ConnectRopes obj = new ConnectRopes();
#         int[] arr = {1, 2, 3, 4, 5};
#         System.out.println(obj.connectToMinimiseCost(arr));
#     }
# }
