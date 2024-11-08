class LongestSubstringWithoutRepeatingCharacter:

    def lengthOfLongestSubstring(self, s: str) -> int:
        longestSubStringLength = 0;

        for i in range(0, len(s)):
            map = set()
            for j in range(i, len(s)):
                val = s[j]
                if val in map:
                    longestSubStringLength = max(longestSubStringLength, j - i )
                    break
                
                map.add(val)

                
        
        return longestSubStringLength

    # --------------------------------------------------------------------

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
            if s[j] in map and map[s[j]]>=i: # abba
                i = map[s[j]] +1
            map[s[j]] = j

            largestSubString = max(largestSubString, j - i +1)
            
        
        return largestSubString