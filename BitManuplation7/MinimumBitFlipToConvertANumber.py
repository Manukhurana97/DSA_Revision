def MinimumBitFlipToConvertNumber(a, b):
	count = 0

	while a!=0 and b!=0:
		count += 1 if a & 1 == 1 and b & 1 == 0 or a & 1 == 0 and b & 1 == 1 else 0
		a>>=1
		b>>=1

	while a!=0:
		count += 1 if a & 1 == 1 else 0
		a>>=1

	while b!=0:
		count += 1 if b & 1 == 1 else 0
		b>>=1

	return count


# xor : if different the 1 else 0
def MinimumBitFlipToConvertNumber1(a, b):
	xor = a ^ b
	count = 0
	while xor:
		count += 1 if xor & 1 == 1 else 0
		xor >>=1

	return count

print(MinimumBitFlipToConvertNumber(10, 7)) # 1010, 0111
print(MinimumBitFlipToConvertNumber(15, 16)) # 01111 10000

print(MinimumBitFlipToConvertNumber1(10, 7))
print(MinimumBitFlipToConvertNumber1(15, 16))
