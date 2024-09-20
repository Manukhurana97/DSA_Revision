class kthSmallestElement:

	# get the inorder triversal of tree and return inorder[k-1]
	def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        inorder = []
        self.inorderTreverse(root, inorder)
        return inorder[k-1]

    def inorderTreverse(self, root, inorderArr):
        if not root: return None

        self.inorderTreverse(root.left, inorderArr)
        inorderArr.append(root.val)
        self.inorderTreverse(root.right, inorderArr)


#-----------------------------------------------------------------

# store just the height of tree
def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        curr = root

        while stack or curr:
            while curr:
                stack.append(curr)
                curr = curr.left

            curr = stack.pop()
            k-=1

            if k==0: return curr.val

            curr = curr.right
        return -1