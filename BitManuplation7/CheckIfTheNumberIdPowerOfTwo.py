def checkIfPowerOfTwo(n):
	
	count = 0;

	while n>0:
		count += 1 if (n & 1 == 1) else 0
		n >>=1

	return count == 1

print(checkIfPowerOfTwo(12))
print(checkIfPowerOfTwo(16))
