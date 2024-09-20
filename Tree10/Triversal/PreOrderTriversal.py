    from typing import List, Optional

class TreeNode:
	def __init__(self, val=0, left = None, right = None):
		self.left = left
		self.right = right

class PreOrderTriversal: # (root left right)
	 def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root: return result

        self.getPreOrder(root, result)

        return result
        
    def getPreOrder(self, root, result):
        if not root : return

        result.append(root.val)
        self.getPreOrder(root.left, result)
        self.getPreOrder(root.right, result)
		

# iteration
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        if not root: return root

        stack = [root]

        while stack:
            current = stack.pop()
            result.append(current.val)

            if current.right:
                stack.append(current.right)
            
            if current.left:
                stack.append(current.left)
            


        return result

