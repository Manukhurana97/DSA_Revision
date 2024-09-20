def AllPermutation(str):
	
	result = []
	def getAllPermutations(str, i, n, arr):
		
		if i == n:
			if len(arr)>0:
				result.append(arr.copy())
			return

		arr.append(str[i])
		getAllPermutations(str, i + 1, n, arr)

		arr.pop(-1)
		getAllPermutations(str, i + 1, n, arr)


	def getAllPermutations1(str, i, n, arr):
		if i == n:
			result.append(''.join(arr))
			return

		for ind in range(i, len(str)):
			arr.append(str[ind])
			getAllPermutations(str, ind + 1, n, arr)
			arr.pop(-1)



	getAllPermutations1(str, 0, len(str), [])
	return result


print(AllPermutation("abc"))