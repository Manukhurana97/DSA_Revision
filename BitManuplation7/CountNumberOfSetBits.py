def CountNumberOfSetBits(n):
	count = 0
	while n!=0:
		count += 1 if n&1 else 0
		n>>=1
	return count

print(CountNumberOfSetBits(15))