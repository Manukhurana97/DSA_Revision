class FindBottomLeftFirstValue:

# -------------------------------------- DFS ----------------------------------------------

	def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:

        self.maxLevel = 0
        self.bottomValue = root.val

        def dfs(root, level):
            if not root: return None

            if level > self.maxLevel:
                self.maxLevel = level
                self.bottomValue = root.val

            dfs(root.left, level+1)
            dfs(root.right, level+1)

        dfs(root, 0)

        return self.bottomValue


# -------------------------------------- BFS ----------------------------------------------


	def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:

        self.bottomLeftvalue = root.val
        queue = deque([root])

        while queue: 
            size: int = len(queue)
            list =  []
            for _ in range(size):
                currentNode = queue.popleft()

                if currentNode.left: queue.append(currentNode.left)
                if currentNode.right: queue.append(currentNode.right)
            
            if queue: self.bottomLeftvalue = queue[0].val  
        return self.bottomLeftvalue
