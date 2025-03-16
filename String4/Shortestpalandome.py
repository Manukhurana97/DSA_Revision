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