class BinaryTreeMaxPathSum:

	def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxSum = root.val

        def dfs(root):
            if not root: return 0

            left = max(dfs(root.left), 0)
            right = max(dfs(root.right), 0)

            self.maxSum = max(self.maxSum, root.val + left + right)
            return root.val + max(left, right) # max Path sum
        
        dfs(root)
        return self.maxSum