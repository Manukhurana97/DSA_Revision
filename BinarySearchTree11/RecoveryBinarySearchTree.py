class RecoveryBinarySearchTree:
	def recoverTree(self, root: Optional[TreeNode]) -> None:
        queue = deque([])
        self.getInorderRootValue(root, queue)
        queue = deque(sorted(queue))
        self.updateValue(root,  queue)

    # collect inorder 
    def getInorderRootValue(self, root, queue):
        if not root:  return None
        
        self.getInorderRootValue(root.left, queue)
        queue.append(root.val)
        self.getInorderRootValue(root.right, queue)

    # update the value
    def updateValue(self, root,  queue):
        if not root:  return None
        
        self.updateValue(root.left, queue)
        root.val = queue.popleft()
        self.updateValue(root.right, queue)

# ----------------------------------------------------------------------------

	def recoverTree(self, root: Optional[TreeNode]) -> None:
       
        self.first = self.second = self.prev= None

        self.inorder(root)

        if self.first and self.second: 
            self.first.val, self.second.val = self.second.val, self.first.val

    def inorder(self, root):
        if not root: return None

        self.inorder(root.left) 
        if self.prev and self.prev.val > root.val:
            if not self.first:
                self.first = self.prev
            self.second = root

        self.prev = root
        self.inorder(root.right)