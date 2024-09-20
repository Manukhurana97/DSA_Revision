# create a aux array if arr i, j is zero update the value of aux array 
# Time Complete : O(m*n * (m+n)), Space Complexity: O(m*n) 

def setMatrixZeros(arr):
	aux = [row[:] for row in arr]

	for i in range(0, len(arr)):
		for j in range(0, len(arr[0])):
			if(arr[i][j] == 0):
				updateRowCol(i, j, aux, arr)

	return aux;

def updateRowCol(r, c, aux, arr):

	for i in range(len(arr[0])):
		aux[r][i] = 0
	for j in range(len(arr)):
		aux[j][c] = 0

	return aux


# use single row and col, Time: O(n*m + n*m), Space: O(n+m)
def setMatrixZeros1(arr):

	row = [-1]*len(arr)
	col = [-1]*len(arr[0])

	for i in range(0, len(arr)):
		for j in range(0, len(arr[0])):
			if(arr[i][j] == 0):
				row[i] = 0
				col[j] = 0


	for i in range(0, len(arr)):
		for j in range(0, len(arr[i])):
			if row[i] == 0 or col[j]==0:
				arr[i][j] = 0

	return arr


# [
	# [0,1,2,0], 
	# [3,4,5,2], 
	# [1,3,1,5]
# ]

# [
	# [1, 1, 1], 
	# [1, 0, 1], 
	# [1, 1, 1]
# ]
# use zeroth row and column as index
def setMatrixZeros2(arr):
	col0 = False
	for i in range(len(arr)):
		for j in range(len(arr[0])):
			if arr[i][j] == 0:
				if j==0:
					col0 = True
				else:
					arr[i][0] = 0
					arr[0][j] = 0
			


	for i in range(1, len(arr)):
		for j in range(1, len(arr[0])):
				if arr[i][0] == 0 or arr[0][j] == 0:
					arr[i][j] = 0


	if arr[0][0] ==0:
		for i in range(len(arr[0])): arr[0][i] = 0
	if col0:
		for i in range(len(arr)): arr[i][0] = 0

	return arr



print(setMatrixZeros([[1, 1, 1], [1, 0, 1], [1, 1, 1]]))
print(setMatrixZeros1([[1, 1, 1], [1, 0, 1], [1, 1, 1]]))
print(setMatrixZeros2([[1, 1, 1], [1, 0, 1], [1, 1, 1]]))


print(setMatrixZeros([[0,1,2,0], [3,4,5,2], [1,3,1,5]]))
print(setMatrixZeros1([[0,1,2,0], [3,4,5,2], [1,3,1,5]]))
print(setMatrixZeros2([[0,1,2,0], [3,4,5,2], [1,3,1,5]]))