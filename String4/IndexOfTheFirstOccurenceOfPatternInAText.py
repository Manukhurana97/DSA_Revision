# https://www.geeksforgeeks.org/problems/index-of-the-first-occurrence-of-pattern-in-a-text/1

# we can also use KMP algo to optimize
class IndexOfTheFirstOccurenceOfPatternInAText:
    def findMatching(self, text, pattern):
        n, l = len(text), len(pattern)
        
        if text == pattern: return 0
        if n < l: return -1
        
        
        for i in range(0, n - l + 1):
            if text[i: i+l] == pattern:
                return i
        
        return -1