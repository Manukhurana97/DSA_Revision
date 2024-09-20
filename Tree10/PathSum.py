class PathSum:
	def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root: return False
        self.flag = False
        
        def dfs(root, target):
            if not root: return   

            target -= root.val
            if target == 0 and not root.left and not root.right:   self.flag = True
            
            dfs(root.left, target)
            dfs(root.right, target)
        
        dfs(root, targetSum)
        return self.flag