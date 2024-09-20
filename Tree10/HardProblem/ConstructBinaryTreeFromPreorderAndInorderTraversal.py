class ConstructBinaryTreeFromPreorderAndInorderTraversal:

	def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        if not preorder or not inorder: return None

        root = TreeNode(preorder[0])
        self.constructTree(root, preorder, inorder)
        return root

    def constructTree(self, root, preorder: List[int], inorder: List[int]):
        if not preorder or not inorder: return None

        inOrderIndex = inorder.index(preorder[0])

        leftInOrder = inorder[:inOrderIndex] # inorder 
        rightInOrder = inorder[inOrderIndex+1:] # inorder

        leftPreOrder = preorder[1 : 1 + len(leftInOrder)]  # preorder, to get root at top
        rightPreOrder = preorder[1 + len(leftInOrder):] #preorder, to get root at top 

       
        if leftPreOrder:
            root.left = TreeNode(leftPreOrder[0])
            self.constructTree(root.left, leftPreOrder, leftInOrder)

        if rightPreOrder:
            root.right = TreeNode(rightPreOrder[0])
            self.constructTree(root.right, rightPreOrder, rightInOrder)

        return root


#------------------------------------------------------------------------------------------------ 

	def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        if not preorder or not inorder: return None

        inorder_index_map = {data: index for index, data in enumerate(inorder) }

        return self.constructTree(preorder, inorder, 0, len(preorder)-1, 0, len(inorder)-1, inorder_index_map)


    def constructTree(self, preorder, inorder, preStartInd, preEndInd, inStartInd, inEndInd, inorder_index_map):
        if preStartInd > preEndInd or inStartInd > inEndInd: return None

        rootvalue = preorder[preStartInd]
        root = TreeNode(rootvalue)

        inRootIndex = inorder_index_map[rootvalue]
        leftSize = inRootIndex - inStartInd # size of left array

        root.left = self.constructTree(preorder, inorder, preStartInd + 1, preStartInd + leftSize, inStartInd, inRootIndex-1, inorder_index_map)
        root.right = self.constructTree(preorder, inorder, preStartInd + leftSize+1, preEndInd, inRootIndex+1, inEndInd, inorder_index_map)

        return root