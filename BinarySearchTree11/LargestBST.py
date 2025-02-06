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

			left = self.largestBsthelper(root.left)
			right = self.largestBsthelper(root.right)

			if left.val < root.val < right.val: # its a bst
				return Node(Math.min(root.val, left.val), 
					Math.max(root.val, right.val), left.maxSize + right.maxSize + 1)

			return Node(float('-inf'), float('inf'), Math.max(left.maxSize, right.maxSize))
		return largestBsthelper(root).maxSize


# --------------------------------------------------------------------------------------------------
	def largestBst(root):
		self.largestCount = [0]

		def dfs(root, minVal, maxVal):
			if not root: 
				return 0
			if not (minVal < root.val < maxVal): 
				return 0

			left = dfs(root.left, minVal, root.val)
			right = dfs(root.right, root.val, maxVal)

			
			self.largestCount[0] = max(self.largestCount[0],  1 + left+right)
			reutrn 1 + Math.max(left, right)

		dfs(root, float('-inf'), float('inf'))
		return largestCount[0]