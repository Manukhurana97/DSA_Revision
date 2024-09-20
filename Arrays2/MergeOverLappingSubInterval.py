# if 2 element of last in result is greater then first element in next then replace last of max(last[2], next[2])
# else append next in result

# Time O(N), Space O(N)
def mergeOverLappingSubInterval(arr):
	result = [] 
	result.append(arr[0])

	for i in range(1, len(arr)):

		last = result[-1]
		if last[1]>=arr[i][0]:
			last[1] = max(arr[i][1], last[1]);
		else:
			result.append(arr[i])
			

	return result





print(mergeOverLappingSubInterval([[1,3], [2,6], [8,11],[10, 13]]))
print(mergeOverLappingSubInterval([[1,4], [4,5]]))	
print(mergeOverLappingSubInterval([[1,4], [5,5]]))	 	 