class FlattenBinaryTree:

    # perform a preOrder triversal and 
	def flatten(self, root: Optional[TreeNode]) -> None:

        if not root: 
            return None 

        queue = deque([])
        self.getpreOrder(root, queue)
        queue.popleft() # to remove top
            
        current = root
        while queue:
            current.left = None
            current.right = TreeNode(queue.popleft().val)
            current = current.right
    
    def getpreOrder(self, root, queue):
        if not root: return

        queue.append(root)
        self.getpreOrder(root.left, queue)
        self.getpreOrder(root.right, queue)


# -------------------------------------------------------------------------------

	def flatten(self, root: Optional[TreeNode]) -> None:
        if not root: return 

        self.morisTreversal(root)
    
    def morisTreversal(self, root):

        while root: 
            
            if root.left:
                left = root.left

                while left.right:
                    left = left.right
                
                left.right = root.right

                root.right = root.left
                root.left = None
            
            root = root.right