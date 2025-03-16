# https://leetcode.com/problems/shortest-palindrome/

class Shortestpalandome:


	def shortestPalindrome(self, s: str) -> str:
        def isPalandrome(val):
            left, right = 0, len(val)-1
            while left<=right:
                if val[left] != val[right]: return False
                left += 1
                right -= 1

            return True
        
        l = len(s)
        if l == 0 or isPalandrome(s): return s
        
        a = b =  s[::-1] + s
        minLen, val = 1e9, 0

        # remove from first
        for i in range(0, l):
            a = a[:i]+a[i+1: ]
            if isPalandrome(a) and minLen > len(a):
                minLen = len(a)
                val = a

        # remove from last
        for i in range(l-1, 0, -1):
            b = b[:i]+b[i+1: ]
            if isPalandrome(b) and minLen > len(b):
                minLen = len(b)
                val = b
       
        return val

# ---------------------------------------------------------------------------------------------------------------------

    # using KMP algorithm
    def shortestPalindrome(self, s: str) -> str:
        n = len(s)
        
        rev_s = s[::-1]
        new_s = s + '#' + rev_s
        print(new_s)
        
        lps = [0] * len(new_s) # longest palandrome substring
        j = 0
        for i in range(1, len(new_s)):
            while j>0 and new_s[i] != new_s[j]:
                j = lps[j-1]
            
            if new_s[j] == new_s[i]:
                j+=1
                lps[i] = j
            
        
        max_prefix_length = lps[-1]
        to_add = rev_s[:n-max_prefix_length]
        return to_add+s