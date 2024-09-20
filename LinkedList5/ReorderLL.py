class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class ReorderList:
	# Time: O(2N), Space : O(N)
	# we have use map to store the element, we can use stack also
	def reorderList(self, head):
	        map = {}
	        current = head
	        index = 0
	        while current:
	            map[index]=current
	            index+=1
	            current = current.next

	        
	        current = head
	        length = index
	        index = 0
	        while current and index <= length//2 :
	            next = current.next

	            node = map[length - index -1]
	            node.next = current.next
	            current.next = node
	            
	            current = next
	            index +=1
	        current.next = None

	        return head


	# Time: O(2N), Space : O(1)
	def reorderList1(self, head):

		# find center
		fast = head
		slow = head
		while fast and fast.next:
			fast = fast.next.next
			slow = slow.next

		next = slow.next
		slow.next = None
		current = next

		# reverse the half
		dummyNode = ListNode(None) 
		while current:
			next = current.next
			current.next = dummyNode.next
			dummyNode.next = current
			current = next



		# combine 
		current1 = head
		current2 = dummyNode.next
		while current1 and current2:
			next1 = current1.next
			next2 = current2.next

			current2.next = current1.next
			current1.next = current2

			current1 = next1
			current2 = next2
		
		return head



# 0 1 2 3 4 5 6 : 0 6 1 5 2 4 3
head = ListNode(0)
head.next = ListNode(1)
head.next.next = ListNode(2)
head.next.next.next = ListNode(3)
head.next.next.next.next = ListNode(4)
head.next.next.next.next.next = ListNode(5)
head.next.next.next.next.next.next = ListNode(6)

obj = ReorderList()

node = obj.reorderList1(head)
while node:
	print(node.val, end = " ")
	node = node.next