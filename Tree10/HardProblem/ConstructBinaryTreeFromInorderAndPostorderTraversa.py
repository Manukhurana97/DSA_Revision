class ConstructBinaryTreeFromInorderAndPostorderTraversal:

	def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # inorder: left, root, right
        # postOrder: left right root

        if not inorder or not postorder: return None
        map_in_val = {val: ind for ind, val in enumerate(inorder)}

        return self.buildTreeHelper(inorder, postorder, 0, len(inorder) - 1, 0, len(postorder) - 1, map_in_val)


    def buildTreeHelper(self, inorder, postorder, instartInd, inendInd, postStart, postEnd, map_in_val):
        if instartInd > inendInd or postStart > postEnd: return None
        

        rootVal = postorder[postEnd]
        root = TreeNode(rootVal)

        inInd = map_in_val[rootVal]
        leftLen = inInd - instartInd


        root.left = self.buildTreeHelper(inorder, postorder, instartInd, inInd - 1, postStart, postStart + leftLen - 1, map_in_val)
        root.right = self.buildTreeHelper(inorder, postorder, inInd + 1, inendInd, postStart + leftLen,  postEnd - 1, map_in_val)


        return root