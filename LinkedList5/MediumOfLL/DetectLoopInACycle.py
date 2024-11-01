class DetectLoopInACycle:

	# using extra space
	# Time : O(N), Space: O(N)
	def hasCycle(self, head: Optional[ListNode]) -> bool:
        current = head
        ss = set()

        while(current):
            if current in ss:
                return True
            ss.add(current)
            current = current.next
        return False


     # Time: O(N), Space: O(1)
    def hasCycle(self, head: Optional[ListNode]) -> bool:

        if not head: return False

        fast = head.next;
        slow = head;


        while fast != slow and fast and fast.next:
            fast = fast.next.next;
            slow = slow.next;
        
        return fast == slow;

    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head: return False
        fast, slow = head, head

        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow: return True

        else : return None

