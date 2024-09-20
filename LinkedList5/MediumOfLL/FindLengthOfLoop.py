class Node{

	def __init__(self, val):
		val = val
		self.val = x
		self.next = None
}

class FindLengthOfLoop:
		
	def countNodesinLoop(head):
		node = getLoopStartingPoint(head)

		if head is None: return -1

		count = 0
		current = node.next

		while(current != node):
			count += 1
			current = current.next

		return count


	def getLoopStartingPoint(head):
		if not head or not head.next : return None
   
    	slow, fast = head, head

        while fast and fast.next :
            fast = fast.next.next
            slow = slow.next

            if fast == slow:
                break
        
        else :
            return None


        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next
        
        return slow
