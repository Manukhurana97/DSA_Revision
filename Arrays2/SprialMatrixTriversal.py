

# [
# 	[1,2,3,4],
# 	[5,6,7,8],
# 	[9,10,11,12],
# 	[13,14,15, 16]
# ]
def spiralMatrixTraversal(arr):
    left, right = 0, len(arr[0])
    up, down = 0, len(arr)
    n = len(arr) * len(arr[0])

    result = []

    while(len(result)<n):
        for i in range(left, right):
            result.append(arr[up][i])
        up += 1
        
        for i in range(up, down):
            result.append(arr[i][right-1])
        right-=1

        if up < down:
            for i in range(right -1, left -1, -1):
                result.append(arr[down-1][i]);
            down -= 1;

        if left<right:
            for i in range(down - 1, up - 1, -1):
                result.append(arr[i][left]);
            left+=1


    return result



print(spiralMatrixTraversal([
	[1,2,3,4],
	[5,6,7,8],
	[9,10,11,12],
	[13,14,15, 16]]))



# 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.