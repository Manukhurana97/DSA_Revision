class BalancedBinaryTree:
	 def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root: return True

        flag = [True]
        self.height(root, flag)
        return flag[0]
    
    def height(self, root, flag):
        if not root: return 0

        left = 1 + self.height(root.left, flag)
        right = 1 + self.height(root.right, flag)

        if abs(left - right) > 1:
            flag[0]  = False

        return max(left, right)


# --------------------------------------------------------

def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root: return True

        return self.height(root) != -1 
    
    def height(self, root):
        if not root: return 0

        left = self.height(root.left)
        if left == -1: return -1
        
        right = self.height(root.right)
        if right == -1 : return -1

        if abs(left - right) > 1:
            return -1

        return 1+ max(left, right)