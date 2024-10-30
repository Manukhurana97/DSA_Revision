class LongestConsequtiveElement:
	def longestConsecutive(self, arr: List[int]) -> int:
        if len(arr) ==0: return 0
    
        arr = sorted(set(arr))
       
        i = 1
        j = 0
        n = len(arr)
        prev = arr[0]
        maxLen = 1

        while(i < n):
            if(prev == arr[i]-1):
                maxLen = max(maxLen, i-j+1)
            else:
                j = i
            
            prev = arr[i]
            i+=1

        return maxLen

        
	def longestConsecutive(self, arr: List[int]) -> int:
        if len(arr) ==0: return 0
    
        arr = sorted(set(arr))
       
        currentLen = 1
        maxLen = 1

        for i in range(1, len(arr)):
            if(arr[i-1] == arr[i]-1):
                currentLen+=1
                maxLen = max(maxLen, currentLen)
            else:
                currentLen = 1
            
        return maxLen