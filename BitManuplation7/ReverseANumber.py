class ReverseANumber:
	def reverse(self, x: int) -> int:
        MIN = -2147483648  # -2^31,
        MAX = 2147483647  #  2^31 - 1
        no = 0
        isNeg = True if x<0 else False
        if isNeg: x*=-1
        
        for i in range(len(str(x))):
            no = no * 10 + x%10
            x//=10
            
        no *= (-1 if isNeg else 1)
        if not (MIN < no < MAX): return 0
        return no