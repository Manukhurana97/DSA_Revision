class SegerateOddEvenInLL:

	# Time : O(N), Space: O(N)
	# def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
	# 	even = []
	# 	odd = []

	# 	count = 0
	# 	current = head
	# 	while current:
	# 		if count % 2 == 0:
	# 			even.append(current.val)
	# 		else: 
	# 			odd.append(current.val)
	# 		count+=1
	# 		current = current.next

	# 	current = head
	# 	for i in even:
	# 		current.val = i
	# 		current = current.next
	# 	for i in odd:
	# 		current.val = i
	# 		current = current.next

	# 	return head;

	def oddEvenList(self, head):
		count = 0

		evenHead = ListNode(None)
		oddHead = ListNode(None)

		even = evenHead
		odd = oddHead

		current = head

		while current :
			if count % 2 !=0:
				even.next = current
				even = even.next
			else:
				odd.next = current
				odd = odd.next
			count += 1
			current = current.next;


		even.next = None
		odd.next = evenHead.next
		return oddHead.next






