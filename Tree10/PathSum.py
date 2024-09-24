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

# ----------------------------------------------------------------------

    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root: return False
        
        def dfs(root, target):
            if not root:  return False
            if not root.left and not root.right: 
                return target == root.val

            return dfs(root.left, target - root.val) or dfs(root.right, target - root.val)
        
        
        return dfs(root, targetSum)