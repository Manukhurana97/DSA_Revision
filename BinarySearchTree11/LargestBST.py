class TreeNode:
	def __init__(val, left = None, right = None):
		this.val = val
		this.left = left
		this.right = right

class Node:
	def __init__(minVal, maxVal, maxSize):
		this.minVal = minVal
		this.maxVal = maxVal
		this.maxSize = maxSize

class LargestBST:
	def largestBst(root):
		def largestBsthelper(root):
			if not root:
				return Node

			Node left = self.largestBsthelper(root.left)
			Node right = self.largestBsthelper(root.right)

			if left.val < root.val < right.val: # its a bst
				return Node(Math.min(root.val, left.val), 
					Math.max(root.val, right.val), left.maxSize + right.maxSize + 1)

			return Node(float('-inf'), float('inf'), Math.max(left.maxSize, right.maxSize))
		return largestBsthelper(root).maxSize
	