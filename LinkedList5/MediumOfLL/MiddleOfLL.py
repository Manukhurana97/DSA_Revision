class ListNode:
	int val;
	Node next;

	def __init__(int val):
		this.val = val;
		this.next = null;


class findMiddleElement:

	def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = head
        fast = head

        while(fast and fast.next ):
            fast = fast.next.next
            slow = slow.next

        return slow


