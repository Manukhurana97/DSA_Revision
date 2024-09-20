def divide1(a, b):
	if a == 0: return 0
	if b == 0: return -1
	if a < b: return 0

	ind = 0
	while a>b:
		a-=b
		ind+=1

	return ind

def divide2(a, b):

	if a == 0: return 0
	if b == 0: return -1
	if a < b: return 0

	isNeg = ((a < 0 and b > 0) or (a > 0 and b < 0))

	ind = sum = 0;
	for i in range(31, 0, -1):
		div = (1<<i)
		if a >= div and sum <= a:
			ind += i
			a-=div
			sum += div
	return ind * (-1 if isNeg else 1)


print(divide1(43, 8))
print(divide2(43, 8))
