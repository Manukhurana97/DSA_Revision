class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class MergeTwoLL:
	 def mergeTwoLists(self, list1, list2):
	 	dummyNode = current = ListNode(None)

	 	while list1 and list2:
	 		if list1.val<=list2.val:
	 			current.next = list1
	 			list1 = list1.next
	 		else:
	 			current.next = list2
	 			list2 = list2.next
	 		current = current.next

	 	
	 	current.next = list1 if list1 else list2

	 	return dummyNode.next
	 		



list1=ListNode(1)
list1.next=ListNode(2)
list1.next.next=ListNode(4)

list2=ListNode(1)
list2.next=ListNode(3)
list2.next.next=ListNode(5)	
list2.next.next.next=ListNode(6)	
list2.next.next.next.next=ListNode(7)	

obj = MergeTwoLL()
result = obj.mergeTwoLists(list1, list2)

while result: 
	print(result.val)
	result = result.next