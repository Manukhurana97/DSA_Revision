class TreeNode:
	def __init__(self, val, left=None, right=None):
		self.val = val
		self.left = left
		self.right = right

class MorrisTraversal:

	def inorder(self, root):
		result = []
		current = root

		while current:
			if not current.left: 
				result.append(current.val)
				current = current.right
			else:
				prev = current.left
				while prev.right and prev.right != current:
					prev = prev.right

				if not prev.right: # comming for the fist , create connections
					prev.right = current
					current = current.left
				else: # reached right most element , add to result and move to right
					prev.right = None
					result.append(current.val)
					current = current.right


		return result


	def preorder(self, root):
		result = []
		current = root

		while current:
			
			if not current.left:
				result.append(current.val)
				current = current.right
			else:
				prev = current.left
				while prev.right and prev.right != current:
					prev = prev.right

				if not prev.right:
					result.append(current.val)
					prev.right = current # Create a temporary link to return later
					current = current.left
				else:
					prev.right = None # Remove the temporary link
					current = current.right
		return result


#      1
#    2   3 
#   4 5 6 7

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right.left = TreeNode(6)
root.right.right = TreeNode(7)

obj = MorrisTraversal()
print(obj.inorder(root))
print(obj.preorder(root))





				

