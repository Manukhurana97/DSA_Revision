# Time: O(N^4), Space: O(N)
def fourSum(arr):
	n = len(arr)
	result = []

	for i in range(n):
		for j in range(i+1, n):
			for k in range(j+1, n):
				for l in range(k+1, n):
					if arr[i] + arr[j] + arr[k] + arr[l] == 0:
						aux = [arr[i], arr[j], arr[k], arr[l]]
						aux.sort()
						if aux not in result:
							result.append(aux)

	return result;


# Time: O(N^3* NlogN), Space: O(N)
def fourSum1(arr):
	n = len(arr)
	result = []

	

	for i in range(n):
		for j in range(i+1, n):
			seen = set()
			for k in range(j+1, n):
				rem = 0 - arr[i] - arr[j] - arr[k]
				if rem in seen:
					aux = [arr[i], arr[j], arr[k], rem]
					aux.sort()
					if aux not in result:
						result.append(aux)
				else:
					seen.add(arr[k]);
	return result



# Time: O(N^3 + NlogN), Space: O(N)
def fourSum2(arr):
	n = len(arr)
	result = []

	arr.sort()

	for i in range(n):
		for j in range(i+1, n):

			k = j+1
			l = n-1

			while(k < l):
				aux = [arr[i], arr[j], arr[k], arr[l]]
				qurd = arr[i] + arr[j] + arr[k] + arr[l]

				if qurd == 0 :
					if aux not in result:
						result.append(aux)
					k+=1
					l-=1
				elif qurd>0:
					l-=1
				else:
					k+=1
	return result




print(fourSum([1,0,-1,0,-2,2]))
print(fourSum1([1,0,-1,0,-2,2]))
print(fourSum2([1,0,-1,0,-2,2]))

