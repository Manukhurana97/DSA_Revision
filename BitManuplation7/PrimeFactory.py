class PrimeFactory:
	def isPrime(self, N):
		for i in range(2, N):
			if N%i == 0: return False

		return True
    
	def AllPrimeFactors(self, N):
		arr = []
		
		for i in range(2, N+1):
		    if N%i == 0 and self.isPrime(i):
		        arr.append(i)

		return arr

obj = PrimeFactory()
print(obj.AllPrimeFactors(10))
	    