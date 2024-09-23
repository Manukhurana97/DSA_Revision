from collections import deque

class TreeNode:
	def __init__(self, val, left=None, right=None):
		self.val = val
		self.left = left
		self.right = right

class BoundDryOfBinaryTree:
	def printBoundary(self, root):
		result = [root.val]

		self.getLeftElement(root.left, result)
		self.getLeaf(root, result)
		self.getRightElement(root.right, result)

		return result


	#  get left elements 
	def getLeftElement(self, node, result): # level order triversal and get the first element
		
		if not node: return 

		queue = deque([node])

		while queue:
			size = len(queue)
			tempArr = []
			for _ in range(size):
				current = queue.popleft()
				if not self.isLeaf(current): tempArr.append(current.val)

				if current.left: queue.append(current.left)
				if current.right: queue.append(current.right)
			
			if tempArr: result.append(tempArr[0])


	#  get leafs
	def getLeaf(self, node, result):
		if not node:
			return

		if node and self.isLeaf(node): result.append(node.val)
		self.getLeaf(node.left, result)
		self.getLeaf(node.right, result)


	# right elements
	def getRightElement(self, node, result): # level order triversal and get the last element
		
		if not node: return 

		queue = deque([node])
		auxResult = []

		while queue:
			size = len(queue)
			tempArr = []
			for _ in range(size):
				current = queue.popleft()
				if not self.isLeaf(current): tempArr.append(current.val)

				if current.left: queue.append(current.left)
				if current.right: queue.append(current.right)
			
			if tempArr: auxResult.append(tempArr[-1])

		for i in auxResult[::-1]:
			result.append(i)


		

	def isLeaf(self, node):
		return node and not node.left and not node.right


root = TreeNode(1)
root.left = TreeNode(2)
root.left.left = TreeNode(3)
root.left.left.right = TreeNode(4)
root.left.left.right.left = TreeNode(5)
root.left.left.right.right = TreeNode(6)
root.right = TreeNode(7)
root.right.right = TreeNode(8)
root.right.right.left = TreeNode(9)
root.right.right.left.left = TreeNode(10)
root.right.right.left.right = TreeNode(11)

obj = BoundDryOfBinaryTree()
print(obj.printBoundary(root)) # 1, 2, 3, 4, 5, 6, 10, 11, 9, 8, 7
