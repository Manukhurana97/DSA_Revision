# https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

class DeleteTheMiddleNodeOfaLL:

	def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:

        if not head.next:
            return None

        fast = head
        slow = head
        prev = None

        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next

       
        prev.next = slow.next
        return head