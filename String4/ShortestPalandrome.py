# https://leetcode.com/problems/shortest-palindrome/
class ShortestPalandrome:
	def shortestPalindrome(self, s: str) -> str:
        n = len(s)
        
        rev_s = s[::-1]
        new_s = s + '#' + rev_s
        print(new_s)
        
        lps = [0] * len(new_s)
        j = 0
        for i in range(1, len(new_s)):
            while j>0 and new_s[i] != new_s[j]:
                j = lps[j-1]
            
            if new_s[j] == new_s[i]:
                j+=1
                lps[i] = j
            
        print(lps)
        
        max_prefix_length = lps[-1]
        to_add = rev_s[:n-max_prefix_length]
        return to_add+s

