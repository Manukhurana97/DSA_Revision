class Node:
	def __init__(self, data=0):
		self.data = data
		self.next = None

class AddOneToANumberrepresentLL:

	def addOne(self,head):
		no = 0
		current = head

		# Step 1: Extract the number from the linked list
		while current:
			no = no * 10 +current.data
			current = current.next

		no+=1
		current = prev = head

		for i in str(no):
			if not current: prev.next = current = Node()
			current.val = int(i)
			prev = current
			current = current.next

		return head


node = Node(9)
node.next = Node(9)
node.next.next = Node(9)

obj = AddOneToANumberrepresentLL()
head = obj.addOne(node)

while head:
	print(head.val, end=", ")
	head = head.next