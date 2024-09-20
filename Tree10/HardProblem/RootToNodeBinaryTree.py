
class TreeNode:
	def __init__(self, val = 0, left = None, right = None):
		self.val = val
		self.left = left
		self.right = right



class RootToNodeBinaryTree:
	def getPath(self, root, target):
		result = []
		
		if not root: return result
		if root.val == target: return [target]

		if self.pathHelper(root, target, result):
			return result
		return []

	# helper
	def pathHelper(self, root, target, result):
		if not root : return False

		result.append(root.val)

		if root.val == target: return True

		if self.pathHelper(root.left, target, result) or self.pathHelper(root.right, target, result): return True;
		
		result.pop()
		return False


obj = RootToNodeBinaryTree()


root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.left.right.left = TreeNode(6)
root.left.right.right = TreeNode(7)

print(obj.getPath(root, 7))


root = TreeNode(10)
root.left = TreeNode(20)
root.left.left = TreeNode(30)
root.left.left.left = TreeNode(40)
root.left.left.left.left = TreeNode(50)
root.left.left.left.left.left = TreeNode(60)

print(obj.getPath(root, 50))

