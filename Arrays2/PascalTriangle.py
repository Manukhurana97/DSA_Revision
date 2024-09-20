# 			1
#         1   1
#       1   2   1
#     1   3   3   1
#   1   4   6   4   1 


# Time: O(N^2), Space : O(N)
def pascalTriangle(n, r, c):

	# if r==1:
	# 	if c<1 or c>1 : return -1
	# 	return 1
	# if c==2:
	# 	if c<0 or c<1 : return -1

	arr = [1, 1]
	aux = []
	for i in range(0, r):
		for j in range(0, i+1):
			aux.append(1 if j == 0 or j == i else (arr[j-1] + arr[j]))
		arr = aux.copy()
		# print(aux)
		aux.clear()


	return arr[c-1]


# Time: O(r+c+(r-c)), Space O(1)
def pascalTriangle1(n, r, c):
	# (r-1)C(c-1) = r!/c!*(r-c)! :: 5-1 C 3-1 : 4C2: 4*3/2: 6

	row = col = r_c = 1

	for i in range(1, r-1): row*=i
	for i in range(1, c-1): col*=i
	for i in range(1, (r-c)): r_c*=i

	return row//(col*r_c)


	# update
	for i in range(r, (r-c)-1, -1):
		row*=i
		row//=r_c
		r_c+=1

	return row


def pascalTriangleRow(n, row):
	result = [];
	for colInd in range(1, row+1):
		result.append(pascalTriangle1(n, row, colInd))
	return result




print(pascalTriangle(5, 5, 3))
print(pascalTriangle(1, 1, 1))
print(pascalTriangle(2, 2, 2))


print(pascalTriangle1(5, 5, 3))
print(pascalTriangle1(1, 1, 1))
print(pascalTriangle1(2, 2, 2))


for i in range(1, 7):
	print(pascalTriangleRow(i, i))