class DiameterOfBinaryTree:
	def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if not root:        
            return 0

        maxheight = [1]
        self.getMaxHeight(root, maxheight)
        return maxheight[0]


    def getMaxHeight(self, root, height):
        if not root: return 0

        left  = self.getMaxHeight(root.left, height)
        right = self.getMaxHeight(root.right, height)

        height[0] = max(height[0], left + right)

        return 1 + max(left, right)