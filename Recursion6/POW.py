class POW:
	def myPow(self, x: float, n: int) -> float:
        if n>0: return self.myPowPos(x, n)
        return self.myPowNeg(x, n)

    def myPowPos(self, x: float, n: int):
        if n <= 0: return 1

        return self.myPowPos(x*x, n-1)
    
    def myPowNeg(self, x: float, n: int):
        if n >= 0: return 1

        return self.myPowNeg(x, n+1) / x


    # ----------------------------------------------------

    #  if even the increment else multiple
    # 2^10 -> 4^5 -> 16^2 * 4 -> 256^1*4
    # 2^10 -> 4^4 * 4^1 -> 16^2 -> 256^1
    def myPow1(self, x: float, n: int) -> float:
        
        isNeg = False
        if n < 0:
            isNeg = True 
            n *= -1
        response = 1
        
        while n>0:
            if n%2 == 0:
                x *= x
                n//=2
            else:
                response *= x
                n-=1

        if isNeg:  return 1/response
        return response