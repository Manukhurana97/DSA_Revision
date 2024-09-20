class LongestSubstringWithoutRepeatingCharacter:

	def lengthOfLongestSubstring(self, s: str) -> int:

        if s == "": return 0
        
        largestSubString = 1
        i = j = 0
        n = len(s)
        dic = set()

        while j < n:
            val = s[j]
            while i<=j and val in dic:
                dic.remove(s[i])
                i+=1

            dic.add(val)
            j+=1

            largestSubString = max(largestSubString, j - i)
            
        
        return largestSubString



    def lengthOfLongestSubstring(self, s: str) -> int:

        if s == "": return 0
        
        largestSubString = 1
        i = j = 0
        n = len(s)
        map = {}

        for j in range(n):
            if s[j] in map and map[s[j]]>=i:
                i = map[s[j]] +1
            map[s[j]] = j

            largestSubString = max(largestSubString, j - i +1)
            
        
        return largestSubString