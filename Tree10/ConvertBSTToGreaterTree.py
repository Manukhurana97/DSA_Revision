class ConvertBSTToGreaterTree:
	def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return None

        self.lastSum = 0

        def dfs(root, ):
            if not root: return

            dfs(root.right)

            root.val += self.lastSum
            self.lastSum = root.val
            
            dfs(root.left)


        dfs(root)

        return root