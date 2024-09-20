def RemoveLastSetBit(n):

	i = 1
	while n & i == 0:
		i<<=1


	return n & (~i)

def RemoveLastSetBit1(n):
	return n & n-1

print(RemoveLastSetBit(12))
print(RemoveLastSetBit1(12))#1010