# https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
                                                                
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



# ----------------------------------------------------------------------

    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxVal = -1e9

        def dfs(root):
            if not root: return 0

            left = max(dfs(root.left),0)
            right = max(dfs(root.right),0)

            self.maxVal = max(self.maxVal, root.val + left+ right)

            return root.val + max(left, right)

        dfs(root)
        return self.maxVal