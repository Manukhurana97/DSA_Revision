def pow(x, n):
	result = 1
	isNeg = False

	if n<0:
		isNeg = True
		n*=-1

	while n > 0:
		if n & 1 == 0:
			x *= x
			n//=2
		else:
			result *=x
			n-=1

	return  float(1/result) if isNeg else result

print(pow(2, 10))
print(pow(2, -2))


