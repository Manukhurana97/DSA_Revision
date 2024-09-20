class Node:
	def __init__(self, data = 0, left = None, right = None):
		self.data = data
		self.left = left
		self.right = right

class CeilInBST:
	def findCeil(self, root, val):
		if not root: return -1

		return self.findCeilHelper(root, val, float('inf'))


	def findCeilHelper(self, root, val, ceilVal):
		if not root: return ceilVal if ceilVal != float('inf') else -1

		if root.data == val: return root.data

		if root.data > val: 
			return self.findCeilHelper(root.left , val, min(ceilVal, root.data))
		return self.findCeilHelper(root.right , val, ceilVal)



root = Node(5)
root.left = Node(2)
root.left.left = Node(1)
root.left.right = Node(3)
root.right = Node(8)
root.right.left = Node(6)
root.right.right = Node(9)

obj = CeilInBST()
print("ceil ", obj.findCeil(root, 4))

