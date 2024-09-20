class SearchInBinaryTree:
	def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        
        if not root: return None

        while root and  root.val != val:
            
            root =  root.left if val < root.val else root.right
        
        return root


# -------------------------------------------------------------------------

    def searchBST1(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:

        if not root : return None

        if root.val == val: return root

        return self.searchBST(root.left if val < root.val else root.right , val)
        