# https://leetcode.com/problems/flip-equivalent-binary-trees/description/

class FlipequivalentTree:
	def flipEquiv(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        if not root1 and not root2: return True
        if not root1 or not root2 or root1.val != root2.val: return False


        a = self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right) # without flip
        return a or self.flipEquiv(root1.left, root2.right) and self.flipEquiv(root1.right, root2.left) # with flip


# ------------------------------------------------------------------------------------------------------
        
    def flipEquiv1(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        if not root1 and not root2: return True
        if not root1 or not root2 or root1.val !=root2.val: return False

        if (root1.left and root2.right and root1.left.val == root2.right.val) 
        or (root1.right and root2.left and root1.right.val == root2.left.val):
            root2.left, root2.right = root2.right, root2.left
       

        return self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right)