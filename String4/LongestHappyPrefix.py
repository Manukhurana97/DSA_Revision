class LongestHappyPrefix:
    # KMP  algorithm
	def longestPrefix(self, s: str) -> str:
        n, j = len(s), 0
        lps = [0] * n # longest palandrome substring
        
        for i in range(1, n):
            while j>0 and s[j] != s[i]:
                j = lps[j-1]

            if s[j] == s[i]:
                j+=1
                lps[i] = j
        
        
        return s[:lps[-1]]