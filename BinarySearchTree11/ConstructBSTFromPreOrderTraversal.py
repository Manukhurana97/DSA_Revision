class ConstructBSTFromPreOrderTraversal:

	def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        if not root: return None
        
        return self.constructTree(preorder, float("-inf"), float("inf"))

    def constructTree(self, preorder, minV, maxV):
        if not preorder: return
        
        if not (minV < preorder[0] < maxV): return
        
        node = TreeNode(preorder.pop(0))

        node.left = self.constructTree(preorder, minV, node.val)
        node.right = self.constructTree(preorder, node.val, maxV)

        return node