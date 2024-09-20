class HeightOfBinaryTree:
	def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root : return 0
        if not root.left and not root.right : return 1

        height = 1
        stack = deque([root])

        while stack:
            size = len(stack)
            for _ in range(size):
                current =  stack.popleft()
                
                if current.left: stack.append(current.left)
                if current.right: stack.append(current.right)
            
            height +=1

        return height-1



    def maxDepth(self, root: Optional[TreeNode]) -> int:
        self.maxDepth = 0

        def dfs(root, level):
            if not root: 
                self.maxDepth = max(self.maxDepth, level)
                return


            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
        
        dfs(root, 0)


        return self.maxDepth

