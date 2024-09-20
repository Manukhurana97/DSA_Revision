def printNumber(n):
	if(n == 0 ): return
	printNumber(n - 1)
	print(n, end = ",, ")


def printNumberInReverse(n):
	if(n ==0 ): return
	print(n, end = ", ")
	printNumberInReverse(n-1)


def sumOfNaturalNumber(n):
	if n == 1: return n 

	return n + sumOfNaturalNumber(n-1)


def fibonarcci(n: int):
	if n == 0: return 0
	if n == 1 or n == 2: return 1

	return fibonarcci(n - 1) + fibonarcci(n - 2)

def factor(n):
	if n ==1: return n

	return n * factor(n-1)


def power(a, b):
	if (b == 1): return a

	return a * power(a, b-1);




print(printNumber(6))
print(printNumberInReverse(6))
print(sumOfNaturalNumber(6))
print(fibonarcci(6))
print(factor(6))
print(power(3, 3))

