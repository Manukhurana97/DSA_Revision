# https://leetcode.com/problems/construct-string-from-binary-tree/description/

class ConstructStringFromBinaryTree:
	def tree2str(self, root: Optional[TreeNode]) -> str:
        result = []

        def preorder(root): # root, left, right
            if not root: return
            
            result.append('('+str(root.val))
            if not root.left and root.right: result.append("()")

            preorder(root.left)
            preorder(root.right)
            result.append(")")

        preorder(root)
        return "".join(result)[1:-1]