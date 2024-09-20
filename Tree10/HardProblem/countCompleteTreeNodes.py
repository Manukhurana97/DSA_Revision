class countCompleteTreeNodes:

	# O(N)
	def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root: return 0

        count = 1
        queue = deque([root])

        while queue:
            size = len(queue)

            for _ in range(size):
                currentNode = queue.popleft()

                if currentNode.left: queue.append(currentNode.left)
                if currentNode.right: queue.append(currentNode.right)
            
            count += len(queue)
    
        return count


#      1
#   2     3
#  4  5  5  6

	# O(log n)
    def countNodes(self, root: Optional[TreeNode]) -> int:
    	if not root: return 0

    	lh = self.findLeftHeight(root)
    	rh = self.findRightHeight(root)

    	if lh == rh:
    		return (1 << lh) - 1

    	return 1 + self.countNodes(root.left) + self.countNodes(root.right)


    def findLeftHeight(self, root):
    	height = 0
    	while root:
    		height += 1
    		root = root.left

    	return height

    def findRightHeight(self, root):
    	height = 0
    	while root:
    		height += 1
    		root = root.right

    	return height