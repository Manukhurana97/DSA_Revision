class FindTheStartingPointInLL:

	def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        ss = set()
        current =  head

        while current:
            if current in ss:
                return current
            ss.add(current)
            current = current.next;
        return current


    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:

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