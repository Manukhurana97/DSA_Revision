# there is a pattern in xor: 
# Xor of 1 :-> 1 :: n%4 == 1 : 1
# Xor of 2 :-> 3 :: n%4 == 2 : n+1
# Xor of 3 :-> 0 :: n%4 == 3 : 0
# Xor of 4 :-> 4 :: n%4 == 0 : n

# Xor of 5 :-> 1 :: n%4 == 1 : 1
# Xor of 6 :-> 5 :: n%4 == 2 : n+1
# Xor of 7 :-> 0 :: n%4 == 3 : 0
# Xor of 8 :-> 8 :: n%4 == 0 : n


def XorOfNumber(n):
	if n % 4 == 1: return 1
	if n % 4 == 2: return n+1
	if n % 4 == 3: return 0
	if n % 4 == 0: return n
	return 0


def XorOfNumberRange(n1, n2):
	return XorOfNumber(n2) ^ XorOfNumber(n1-1)



print(XorOfNumber(7))
print(XorOfNumberRange(5, 7)) 