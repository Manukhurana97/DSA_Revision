class ValidBinarySearchTree:
	def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root: return True
        
        return self.isValidBSTHelper(root, float('-inf'), float('inf'))

    def isValidBSTHelper(self, root, minval, maxval) -> bool:
        if not root: return True
        
        if not (minval < root.val < maxval): return False

        return self.isValidBSTHelper(root.left, minval, root.val) and self.isValidBSTHelper(root.right, root.val, maxval)
        