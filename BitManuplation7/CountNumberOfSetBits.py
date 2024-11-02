def CountNumberOfSetBits(n):
	count = 0
	while n!=0:
		count += 1 if n&1 else 0
		n>>=1
	return count

print(CountNumberOfSetBits(15))


def countBits(n: int):
    result = []

    for i in range(0, n+1):
        count = 0
        while i>0:
            count += 1
            i = i & i-1
        result.append(count)
    return result

print(countBits(10))