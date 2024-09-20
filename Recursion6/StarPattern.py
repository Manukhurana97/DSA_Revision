def StarPattern(x):
	if x == 0: return
	StarPattern(x-1)
	for i in range(0, x):
		print("*", end = '')
	print()

	

StarPattern(5)
