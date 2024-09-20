class ListNode:
	def __init__(self, val):
		self.val = val
		self.next = None

class RemoveNthNodeFromEndOfLinkedList:

	# Time : O(N), Space : O(1)
	def removeNthFromEnd(self, head, n: int):

		if not head: return None
		if not head.next and n == 1: return None
		
		ahead = head
		current = head

		# move n set ahead
		while n > 0:
			n -= 1
			ahead = ahead.next
		
		if n > 0: return None 
		if not ahead and n == 0: 
			head = head.next
			return head

		# move remaining step
		while ahead :
			current = current.next
			ahead = ahead.next
		
	
		current.next = current.next.next

		return head

obj = RemoveNthNodeFromEndOfLinkedList()

head = ListNode(1)
head.next = ListNode(2)

head= obj.removeNthFromEnd(head, 2)

while head:
	print(head.val," ")
	head = head.next

