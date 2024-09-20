class InvertTree:

	def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return root
        
        self.dfs(root)
        return root


    def dfs(self, root):
        if not root: return

        if root: 
            root.left , root.right = root.right, root.left

        self.dfs(root.left)
        self.dfs(root.right)


# ---------------------------------------------------------------------------------------


	def invertTree1(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return root
        
        if root: 
            root.left , root.right = root.right, root.left

        self.invertTree(root.left)
        self.invertTree(root.right)
        return root        