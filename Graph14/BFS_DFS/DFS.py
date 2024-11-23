class DFS:

	def triversal(self, adj):
		result, visited = [], set()

		def dfs(current, adj):
			result.append(current)
			visited.add(current)

			# visiting all the neighbours
			for neighbors in adj[current]:
				if neighbors not in visited:
					dfs(neighbors, adj)


		dfs(0, adj)
		return result

obj = DFS()
adj = [[1,3],[0,1],[1,3], [0, 2], [4, 8], [1, 7, 9], [6, 8], [7], [6]]

print(obj.triversal(adj))

# 0 -> 2, 6
# 1 > 1 3 4