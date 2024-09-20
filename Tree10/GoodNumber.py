class GoodNumber:
	def goodNodes(self, root: TreeNode) -> int:
        if not root: return 0
        
        return self.dfs(root, float('-inf'))

    def dfs(self, root, maxTillNow):
        if not root: return 0

        count = 1 if root.val>=maxTillNow else 0 
        
        count += self.dfs(root.left, max(maxTillNow, root.val))
        count += self.dfs(root.right, max(maxTillNow, root.val))

        return count

# ------------------------------------------------------------------------------------


	def goodNodes(self, root: TreeNode) -> int:
        count = 0

        def dfs(root, maxTillNow):
            nonlocal count
            if not root: return 

            if root.val>=maxTillNow:
                count +=1 
            
            dfs(root.left, max(maxTillNow, root.val))
            dfs(root.right, max(maxTillNow, root.val))

        
        dfs(root, float('-inf'))
        return count 
