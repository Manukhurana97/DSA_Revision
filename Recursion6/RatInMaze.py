def RatInMazeHelper(maze, r, c, s, result, visited):
	if r == len(maze)-1 and c == len(maze[0])-1 :
		result.append(s)
		return

	if r - 1 >= 0 and maze[r - 1][c] != 0 and visited[r - 1][c] == 0:
		visited[r - 1][c] = 1
		RatInMazeHelper(maze, r - 1, c , s +'U', result, visited)
		visited[r - 1][c] = 0

	if r + 1 < len(maze) and maze[r + 1][c] != 0 and visited[r + 1][c] == 0:
		visited[r + 1][c] = 1
		RatInMazeHelper(maze, r + 1, c , s +'D', result, visited)
		visited[r + 1][c] = 0

	if c - 1 >= 0 and maze[r][c - 1] != 0 and visited[r][c - 1] == 0:
		visited[r][c -1] = 1
		RatInMazeHelper(maze, r, c - 1 , s +'L', result, visited)
		visited[r][c -1] = 0

	if c + 1 < len(maze[0]) and maze[r][c + 1] != 0 and visited[r][c + 1] == 0:
		visited[r][c + 1] = 1
		RatInMazeHelper(maze, r, c+1 , s +'R', result, visited)
		visited[r][c + 1] = 0


def RatInMaze(maze):
	resultPaths = []
	visited = [[0 for j in range(len(maze[0]))] for i in range(len(maze))]
	visited[0][0] = 1
	RatInMazeHelper(maze, 0, 0, '', resultPaths, visited)
	return resultPaths;

maze = [
[1, 0, 0, 0], 
[1, 1, 0, 1], 
[1, 1, 0, 0], 
[0, 1, 1, 1]]
print(RatInMaze(maze))