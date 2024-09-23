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