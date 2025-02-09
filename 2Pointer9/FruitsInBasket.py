# https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1

class FruitsInBasket:
	def totalFruits(self,arr):
		# 2 bucket : each holds a unique fruits with inf quantity
		bucket = {}
		
		current = last = 0
		n = len(arr)
		fruitCount = maxFruitCount = 0
		
		while current < n:      
			if arr[current] in bucket: 
				bucket[arr[current]] += 1
			else:
				bucket[arr[current]] = 1
				
			fruitCount +=1
			
			while(len(bucket)>2):
				if(bucket[arr[last]] == 1):
					del bucket[arr[last]]
				else :
					bucket[arr[last]] -=1
				
				last+=1
				fruitCount -=1
				
			current+=1
			maxFruitCount = max(maxFruitCount, fruitCount)
		
		return maxFruitCount




# public static int totalElements(Integer[] arr) {
#        Map<Integer, Integer> map = new HashMap<>();
        
#        int n = arr.length, count = 0, maxLen = 0;
#        int current = 0, last = 0;
#        
#        while(current<n){
#            map.put(arr[current], map.getOrDefault(arr[current], 0)+1);
#            count +=1;
#            
#            while(map.size()>2 && last<current){
#                if(map.get(arr[last]) > 1){
#                    map.put(arr[last], map.get(arr[last])-1);
#                }else{
#                    map.remove(arr[last]);
#                }
#                last++;
#                count-=1;
#            }
#            
#            maxLen = Math.max(maxLen, count);
#            current++;
#        }
#        
#        return maxLen;
#    }
# 



obj = FruitsInBasket()
result1 = obj.totalFruits([1, 2, 1])
result2 = obj.totalFruits([0, 1, 2, 2])
result3 = obj.totalFruits([1, 2, 3, 2, 2])
result4 = obj.totalFruits([3, 3, 3, 3])
result5 = obj.totalFruits([1, 2, 1, 2, 1, 2, 1, 2])

print(result1)  # Output: 3
print(result2)  # Output: 3
print(result3)  # Output: 4
print(result4)  # Output: 4
print(result5)  # Output: 8