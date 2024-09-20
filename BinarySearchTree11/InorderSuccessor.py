class TreeNode:
	def __init__(self, val, left = None, right = None):
		self.val = val
		self.right = right
		self.left = left

class InorderSuccessor:
	
	# create array of inorder treversal
	# get inorderArr[ith + 1] 

	# Time: O(n + n) : O(n), Space: O(n + n) : O(n)
	def getSuccessor(self, root, val):
		inorder = []

		self.inOrder(root, inorder)

		index = inorder.index(val)
		return inorder[index+1]


	def inOrder(self, root, arr):
		if not root: return 

		self.inOrder(root.left, arr)
		arr.append(root.val)
		self.inOrder(root.right, arr)


# ------------------------------------------------------------------------------------------
	# Time: O(n + n) : O(n), Space: O(n + n) : O(n)
	def getSuccessor1(self, root, val):
		inorder = []
		
		while root or inorder:
			while root:
				inorder.append(root)
				if root.val == val: break
				root = root.left

			root = inorder.pop()
			
			if val == root.val:
				
				if root.right:  
					root = root.right
					while root.left:
						root = root.left
					return root.val
					
				if inorder: return inorder.pop().val
				
				return None
			
			root = root.right


# ------------------------------------------------------------------------------------------

	def getSuccessor2(self, root, val):
		successor = None

		while root:
			if val < root.val:
				successor = root
				root = root.left
			elif val > root.val:
				root = root.right
			else: # if value found 
				if root.right: 
					successor = root.right
					while successor.left:
						successor = successor.left
				break



		return successor.val if successor else None




obj = InorderSuccessor()

root = TreeNode(5)
root.left = TreeNode(3)
root.left.left = TreeNode(2)
root.left.right = TreeNode(4)
root.left.left.left = TreeNode(1)
root.right = TreeNode(7)
root.right.left = TreeNode(6)
root.right.right = TreeNode(9)
root.right.right.left = TreeNode(8)
root.right.right.right = TreeNode(10)

val = 3
print(obj.getSuccessor(root, val),  obj.getSuccessor1(root, val), obj.getSuccessor2(root, val))
