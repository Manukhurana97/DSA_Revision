class Node:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next


class SortLLZeroOneTwo:

	def segerate(self, head):
		if not head:
			return None

		arr = []

		current = head
		while current :
			arr.append(current.val)
			current = current.next

		arr.sort()

		current = head
		for i in arr:
			current.val = i
			current = current.next

		return head


	def segerate1(self, head):
		if not head:
			return None

		dummyZero = Node(None)
		dummyOne = Node(None)
		dummyTwo = Node(None)
		one = dummyOne
		zero = dummyZero
		two = dummyTwo


		current = head
		while current :
			if current.val == 0:
				zero.next = current
				zero = zero.next
			elif current.val == 1:
				one.next = current
				one = one.next
			else:
				two.next = current
				two = two.next
			current = current.next

		current = head

		# zero = dummyZero.next
		# while zero: 
		# 	current.val = zero.val
		# 	zero = zero.next
		# 	current = current.next

		# one = dummyOne.next
		# while one: 
		# 	current.val = one.val
		# 	one = one.next
		# 	current = current.next

		# two = dummyTwo.next
		# while two: 
		# 	current.val = two.val
		# 	two = two.next
		# 	current = current.next


		# return head

		zero.next = dummyOne.next
		dummyOne.next = dummyTwo.next
		return dummyZero.next


head = Node(1)
head.next = Node(2)
head.next.next = Node(0)
head.next.next.next = Node(1)
head.next.next.next.next = Node(2)
head.next.next.next.next.next = Node(0)


obj = SortLLZeroOneTwo()
head = obj.segerate(head)
while head:
	print(head.val, end = ', ')
	head = head.next

