def KthBitIsSetOrNot(n, k):
	i = 1
	i<<=k

	return n & i>0
    
print('Check: ', KthBitIsSetOrNot(4, 0))
print('Check: ', KthBitIsSetOrNot(4, 2))
print('Check: ', KthBitIsSetOrNot(500, 3))


def setKthBit(n, k):
	i=1
	i<<=k

	return n | i


print('Set: ', setKthBit(4, 0))
print('Set: ',setKthBit(4, 2))
print('Set: ',setKthBit(500, 3))


def clearIthBit(n, k):
	i=1
	i<<=k
	return n & (~i)

print('clear: ',clearIthBit(13, 2))


def toggleIthbit(n, k):
	i=1
	i<<=k
	return n ^ i


print('toggle: ',clearIthBit(13, 2))
print('toggle: ',clearIthBit(4, 2))