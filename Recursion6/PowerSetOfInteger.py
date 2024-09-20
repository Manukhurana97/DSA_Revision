def PowerSetOfInteger(no):
	result = []

	inp = []

	def getSubset(no, i, n, arr):
		if i == n:
			result.append(arr.copy())
			return;

		arr.append(no % 10)
		getSubset(no//10, i + 1, n, arr)
		arr.pop(-1)
		getSubset(no, i + 1, n, arr)


	getSubset(no, 0, len(str(no)), [] )
	return result


print(PowerSetOfInteger(123))
