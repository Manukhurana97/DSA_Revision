class DeleteANode:

	# find a node
	# get the immediate next successor
	# if node has left tree, move that to immediate next successor left bottom
	def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root: return None

        if root.val == key: 
            if not root.left and not root.right: return None
            if not root.left: return root.right
            if not root.right: return root.left
            return self.replaceNewNode(root, root, root.left)

        if root.val > key:
            root.left = self.deleteNode(root.left, key)
        else: root.right = self.deleteNode(root.right, key)

        return root

    def replaceNewNode(self, root, prev, left):
        # get immediate next node
        while root and prev.val>=root.val: 
            prev = root
            root = root.right if root.right else root.left

        # move left of parent 
        current = root
        while current.left:
            current = current.left
        
        current.left = left

        return root


# --------------------------------------------------------------------------


# find the next min on right 
# replace the value and perform delete on next successor
def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root: return None

        if root.val == key: 
            if not root.left: return root.right
            if not root.right: return root.left
            
            successor = self.getNextSuccessor(root.right)
            root.val = successor.val
            root.right = self.deleteNode(root.right, successor.val)


        if root.val > key: root.left = self.deleteNode(root.left, key)
        else: root.right = self.deleteNode(root.right, key)


        return root

    def getNextSuccessor(self, root):
        # get next successor node
        while root.left: root = root.left

        return root