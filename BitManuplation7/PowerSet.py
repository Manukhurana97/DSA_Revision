# print all subset
def powerSet(n):
	result = [[]]

	for elem in n:
	    result += [x + [elem] for x in result]

	return result


# Time : O(2^n * 31)
def powerSet1(n):
	noOfSets = 1<<len(n) # 2**n
	result = []

	for i in range(noOfSets):
		ind = 0
		tempArr = []
		while i!=0:
			if i&1 == 1:
				tempArr.append(n[ind])
			ind+=1
			i>>=1
		result.append(tempArr[::])
	return result



print(powerSet([1, 2, 3]))
print(powerSet1([1, 2, 3]))
