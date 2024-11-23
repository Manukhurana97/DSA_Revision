class BFS:
	def triversal(self, adj):
		result, visited = [], set(0)
		queue = deque([0])

		while queue:
			current = queue.popleft()
			result.append(current)

			# all the neighbour of current node and storing them in queue
			for neighbors in adj[current]:
				if neighbors not in visited:
					queue.append(neighbors)
					visited.append(neighbors)

		return result

