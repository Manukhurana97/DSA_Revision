class InsertNodeInBST:
	def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root: return TreeNode(val)

        self.insertIntoBSTHelper(root, val)
        return root

    def insertIntoBSTHelper(self, root: Optional[TreeNode], val: int):
        if not root: return None

        if val < root.val not root.left : 
            root.left = TreeNode(val)
            return
        if val > root.val and not root.right : 
            root.right = TreeNode(val)
            return


        return self.insertIntoBSTHelper(root.left if root.val > val else root.right , val)
        

# ----------------------------------------------------------------------------

    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root: return TreeNode(val)

        
        if root.val > val:
            root.left = self.insertIntoBST(root.left, val)
        else: root.right = self.insertIntoBST(root.right, val)

        return root