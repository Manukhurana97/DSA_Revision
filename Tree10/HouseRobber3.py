class HouseRobber3:
	def rob(self, root: Optional[TreeNode]) -> int:
       
        result =  self.dfs(root) 
        return max(result) # max(with root, without root)

    def dfs(self, root):
        if not root: return [0, 0]
        if not root.left and not root.right: return [root.val, 0]

        left = self.dfs(root.left)
        right = self.dfs(root.right)

        withRoot = root.val + left[1] + right[1] # if taking root we cant next take direct root
        withoutRoot = max(left[0], left[1]) + max(right[0], right[1]) # max of left/right tree with/without root

        return [withRoot, withoutRoot]