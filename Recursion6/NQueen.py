def canPlaceQueen(r, c, board, size):

	# check row column
	for i in range(size):
		if board[r][i] == 1 or board[i][c] == 1: return False
	

	# check diagonals
	i = r
	j = c
	while i>=0 and j>=0:
		if board[i][j] == 1: return False
		i-=1
		j-=1
	i = r
	j = c
	while i<size and j<size:
		if board[i][j] == 1: return False
		i+=1
		j+=1
	i = r
	j = c
	while i>=0 and j<size:
		if board[i][j] == 1: return False
		i-=1
		j+=1

	i = r
	j = c
	while i<size and j>=0:
		if board[i][j] == 1: return False
		i+=1
		j-=1


	return True



def placeQueenOnBoard(board, c, size):
	if c>=size: return True

	for r in range(size):
		if canPlaceQueen(r, c, board, size):
			board[r][c] = 1
			if placeQueenOnBoard(board, c + 1, size):
				return True

			board[r][c] = 0
	return False



def NQueen(size):
	board = [[0 for i in range(size)] for j in range(size)]
	flag = placeQueenOnBoard(board, 0, size)
	return board



# ---------------------------------------------------------------------------
# for multiple result



class Solution:
    def canPlaceQueen(self, r, c, board, size):

        # check row column
        for i in range(size):
            if board[r][i] == 'Q' or board[i][c] == 'Q': return False
        
xx
        # check diagonals
        i, j = r, c
        while i>=0 and j>=0:
            if board[i][j] == 'Q': return False
            i-=1
            j-=1
        i, j = r, c
        while i<size and j<size:
            if board[i][j] == 'Q': return False
            i+=1
            j+=1
        i, j = r, c
        while i>=0 and j<size:
            if board[i][j] == 'Q': return False
            i-=1
            j+=1

        i, j = r, c
        while i<size and j>=0:
            if board[i][j] == 'Q': return False
            i+=1
            j-=1
            
        return True

    def placeQueenOnBoard(self, board, c, size,  solutions):
        if c >= size: 
            solutions.append([''.join(row) for row in board])
            return True

        for r in range(size):
            if self.canPlaceQueen(r, c, board, size):
                board[r][c] = 'Q'
                self.placeQueenOnBoard(board, c + 1, size, solutions)
                board[r][c] = '.'
        
    def solveNQueens(self, size: int) -> List[List[str]]:
        board = [['.' for _ in range(size)] for _ in range(size)]
        solutions = []
        self.placeQueenOnBoard(board, 0, size, solutions)
        return solutions



result = NQueen(4)
for i in range(4):
	print(result[i])
