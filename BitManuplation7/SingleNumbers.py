# Time O(2n), Space: O(n)
def singleNumberInDuplet1a(arr):
	map = {}
	for i in arr:
		map[i]  = 1 + (map[1] if i in map else 0)

	for i, j in map.items():
		if j == 1: return i

	return -1
		
def singleNumberInDuplet1b(arr):
	xor = 0
	for i in arr:
		xor ^= i

	return xor


arr = [1,2,3,3,2]
print("singleNumberInDuplet1a ",singleNumberInDuplet1a(arr))
print("singleNumberInDuplet1b ", singleNumberInDuplet1b(arr))



# ----------------------------------------------------------------

# use map : Time: O(2n), Space: O(n)
def singleNumberInTriplet1a(arr):
	map = {}
	for i in arr:
		map[i]  = 1 + (map[i] if i in map else 0)

	for i, j in map.items():
		if j == 1: return i

	return -1

# sort : O(nLogn), Space: O(n)
def singleNumberInTriplet1b(arr):
	arr.sort()
	n = len(arr)
	i = 1

	while i < n:
		if arr[i - 1] != arr[i] or arr[i] != arr[i + 1]:
			if arr[i - 1] == arr[i]: return arr[i + 1]
			return arr[i-1]
		i+=3

	return arr[len(arr)-1]



def singleNumberInTriplet1c(arr):
	map = {}
	for i in arr:
		index=0
		while i != 0:
			if i & 1 == 1:
				map[index] = 1 + map[index] if index in map else 0
			index+=1
			i>>=1
	
	result = 0
	index-=1
	for k, v in map.items():
		if v % 3 != 0:
			result |= 1<<index
		index -= 1

	return result


arr = [1,1,1,2,3,3,3]
print("singleNumberInTriplet1a ", singleNumberInTriplet1a(arr))
print("singleNumberInTriplet1b ", singleNumberInTriplet1b(arr))
print("singleNumberInTriplet1c ", singleNumberInTriplet1c(arr))



# ----------------------------------------------------------------


def SingleNumber2a(arr):
	map = {}
	for i in arr:
		map[i] = 1 + (map[i] if i in map else 0)

	for k, v in map.items():
		if v == 1:
			print(k, end = ',')



def SingleNumber2b(arr):
    xor = 0
    for i in arr:
        xor ^= i

    # index = 0
    # while xor != 0 and xor & 1 == 0:
    #     index += 1
    #     xor >>= 1

    index = (xor & (xor - 1)) 

    evenXor, oddXor = 0, 0
    for i in arr:
        if (i >> index) & 1:
            oddXor ^= i
        else:
            evenXor ^= i

    return evenXor, oddXor




arr = [2,4,2,14,3,7,7,3, 3]
print(SingleNumber2a(arr))
print(SingleNumber2b(arr))

