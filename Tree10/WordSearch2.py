class WordSearch2:
	def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:

        result = []
        charSet = {word[0] for word in words}
       
        row = len(board)
        col = len(board[0])
        visited = [([0] * col) for i in range(row)]

        for r in range (row):
            for c in range (col):
                if board[r][c] in charSet:
                    self.dfs(r, c, board, words, result, "", visited)
        
        return result


    def dfs(self, row, col, board, words, result, word, visited):
        if row < 0 or col < 0 or row >= len(board) or col >= len(board[0]) or visited[row][col] == 1: return 

        word += board[row][col]
        if word in words: result.append(word)
        
        visited[row][col] = 1
        self.dfs(row - 1, col, board, words, result, word, visited)
        self.dfs(row, col - 1, board, words, result, word, visited)
        self.dfs(row + 1, col, board, words, result, word, visited)
        self.dfs(row, col + 1, board, words, result, word, visited)
        visited[row][col] = 0