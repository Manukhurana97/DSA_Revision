# https://leetcode.com/problems/string-to-integer-atoi/

def myAtoi(self, s: str) -> int:
    i = response = 0
    n = len(s)
    isNeg = False

    while i < n and s[i] == ' ': i+=1
    if i<n and (s[i] == '-' or s[i] == '+'): 
        if s[i] == '-': isNeg = True
        i+=1
    while i<n and s[i].isdigit(): 
        response = response * 10 + int(s[i])
        i+=1
            
    response = -1 * response if isNeg else response
    
    if response < -2**31: return -2**31
        
    if response > 2**31-1: return 2**31-1
    
    return response