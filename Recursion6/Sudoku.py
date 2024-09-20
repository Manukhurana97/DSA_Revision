def canPlace(r, c, no, board):
	for i in range(0, 9):
		if board[r][i] == no or board[i][c] == no: return False

	r = r//3*3
	c = c//3*3

	for i in range(0, 3):
		for j in range(0, 3):
			if board[r + i][c + j] == no: return False

	return True

def SudokuSolver(board):
	for r in range(0, 9):	
		for c in range(0, 9):
			if board[r][c] == 0:
				for i in range(1, 10):
					if canPlace(r, c, i, board):
						board[r][c] = i
						if SudokuSolver(board): 
							return True
						board[r][c] = 0
				return False
	return True




board = [[ 5, 3, 0, 0, 7, 0, 0, 0, 0 ],
        [ 6, 0, 0, 1, 9, 5, 0, 0, 0 ],
        [ 0, 9, 8, 0, 0, 0, 0, 6, 0 ],
        [ 8, 0, 0, 0, 6, 0, 0, 0, 3 ],
        [ 4, 0, 0, 8, 0, 3, 0, 0, 1 ],
        [ 7, 0, 0, 0, 2, 0, 0, 0, 6 ],
        [ 0, 6, 0, 0, 0, 0, 2, 8, 0 ],
        [ 0, 0, 0, 4, 1, 9, 0, 0, 5 ],
        [ 0, 0, 0, 0, 8, 0, 0, 7, 9 ]]
if SudokuSolver(board):
	for r in range(0, 9):
		for c in range(0, 9):
			print(board[r][c], end=", ")
		print()