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



#   public int myAtoi(String s) {
#     int i = 0, n = s.length();

#     // WhiteSpace
#     while(i < n && s.charAt(i) == ' ') {
#         i+=1;
#     }

#     // sign
#     boolean isNeg = false;
#     if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
#         isNeg = (s.charAt(i) == '-');
#         i+=1;
#     }

#     // zero
#     while(i<n && s.charAt(i) == '0'){
#         i+=1;
#     }

#     long result = 0;

#     while(i != n && s.charAt(i) -'0' >= 0 && s.charAt(i) - '0' <= 9) {
#         int digit = s.charAt(i) - '0';
#         result = result *10 + digit;
        

#         if(result > Integer.MAX_VALUE ){
#             return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
#         }
        
#         i+=1;
#     }

#     return (int) (isNeg ? -result : result);
# }
# 
# 