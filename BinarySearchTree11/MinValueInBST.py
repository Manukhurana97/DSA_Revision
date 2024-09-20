class Node:
	def __init__(self, data = 0, left = None, right = None):
		self.data = data
		self.left = left
		self.right = right

class MinValueInBST:
	def minValue(self, root):
		if not root: return None

		return self.getMinVal(root, root.data), self.getMaxVal(root, root.data)

# min value
	def getMinVal(self, root, minVal):
		if not root: return minVal

		return self.getMinVal(root.left if root.left else root.right, min(minVal, root.data))

# max value
	def getMaxVal(self, root, maxVal):
		if not root: return maxVal

		print(maxVal, root.data)

		return self.getMaxVal(root.right if root.right else root.left, max(maxVal, root.data))



root = Node(5)
root.left = Node(2)
root.left.left = Node(1)
root.left.right = Node(3)
root.right = Node(8)
root.right.left = Node(6)
root.right.right = Node(9)

obj = MinValueInBST()
print(obj.minValue(root))

