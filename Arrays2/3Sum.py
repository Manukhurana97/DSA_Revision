# time:  O(N^3), Space: O(N) 
def threeSum(arr):
	result = []
	for i in range(len(arr)):
		for j in range(i+1, len(arr)):
			for k in range(j+1, len(arr)):
				if arr[i] + arr[j] + arr[k] == 0 :
					aux = [arr[i], arr[j], arr[k]]
					aux.sort()
					if aux not in result:
						result.append(aux)
	return result


# time: O(N^2 * NlogN)), Space: O(N) 
def threeSum1(arr):
	result = []
	map = []
	for i in range(len(arr)):
		for j in range(i+1, len(arr)):
			rem = 0 - (arr[i] + arr[j])
			if rem in map:
				aux = [rem, arr[i], arr[j]]
				aux.sort()
				if aux not in result:
					result.append(aux)
			else:
				map.append(arr[i])
	return result


# time: O(NlogN + N^2), Space: O(N) 
def threeSum2(arr):
	arr.sort()

	result = []
	for i in range(len(arr)):
		j = i+1;
		k = len(arr) -1

		while(j<k):
			aux = [arr[i], arr[j], arr[k]]
			sum = arr[i] + arr[j] + arr[k]
			if sum == 0:
				if aux not in result:
					result.append(aux)
				j+=1
				k-=1
			elif sum > 0:
				k-=1
			else:
				j+=1
	return result



print(threeSum([-1,0,1,2,-1,-4]))
print(threeSum1([-1,0,1,2,-1,-4]))
print(threeSum2([-1,0,1,2,-1,-4])) # -4,-1,-1,0,1,2