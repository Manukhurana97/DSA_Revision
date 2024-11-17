# https://leetcode.com/problems/word-search-ii/description/
class WordSearch2:

    # Time : 4^r*c, Space : O(2(r*c))
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
        if word in words and word not in result: 
            result.append(word)
        
        visited[row][col] = 1
        self.dfs(row - 1, col, board, words, result, word, visited)
        self.dfs(row, col - 1, board, words, result, word, visited)
        self.dfs(row + 1, col, board, words, result, word, visited)
        self.dfs(row, col + 1, board, words, result, word, visited)
        visited[row][col] = 0


# --------------------------------------------------------------------------------------------------

# create a trie on words 
class TrieNode:

    def __init__(self):
        self.childrens = {}
        self.isEnd = False

    def addWord(self, word):
        current = self
        for c in word:
            if c not in current.childrens:
                current.childrens[c] = TrieNode()
        
            current = current.childrens[c]
        current.isEnd = True


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = TrieNode()
        for w in words: root.addWord(w)

        rows, cols = len(board), len(board[0])
        result, visited = set(), set()
    
        # peform dfs on all charin board and if its in trie
        def dfs(row, col, node, word):
            if (row < 0 or col < 0 or row >= rows or col >= cols or 
                (row, col) in visited or  board[row][col] not in node.childrens): 
                return                 
            
            # update status
            visited.add((row, col))
            node = node.childrens[board[row][col]]
            word += board[row][col]
            
            # If we find a word
            if node.isEnd:
                result.add(word)

            # Explore all 4 directions
            dfs(row - 1, col, node, word)  # Up
            dfs(row + 1, col, node, word)  # Down
            dfs(row, col - 1, node, word)  # Left
            dfs(row, col + 1, node, word)  # Right

            # Backtrack
            visited.remove((row, col))

        #  for each char 
        for r in range(rows):
            for c in range(cols):
                dfs(r, c, root, '')

        return list(result)


