# start from m and n and reach 0 , 0

def wayInMatrix(arr, m, n):
	if m == 1 or n == 1: return 1

	return wayInMatrix(arr, m - 1, n) + wayInMatrix(arr, m, n - 1)


arr = [
[1,2,3], 
[4,5,6], 
[7,8,9]]
print(wayInMatrix(arr, 3, 3))

