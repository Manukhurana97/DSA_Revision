class BFS:
	def triversal(self, adj):
		result, visited = [], set(0)
		queue = deque([0])

		while queue:
			current = queue.popleft()
			result.append(current)

			for neighbors in adj[current]:
				if neighbors not in visited:
					queue.append(neighbors)
					visited.append(neighbors)

		return result

