def Factorial(x, y):
	if x == 0: return y

	return Factorial(x-1, x+y)

print(Factorial(5, 2))