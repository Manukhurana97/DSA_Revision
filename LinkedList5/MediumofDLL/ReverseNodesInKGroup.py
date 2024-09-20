def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k <= 1: return head 

        dummyNode = ListNode(None)
        prev = dummyNode
        current = head
        
        while current :
            kth = self.getKthNode(current, k)
            
            if not kth: return dummyNode.next
            nextGroup = kth.next

            prev.next, last = self.reverse(current, nextGroup)
            prev = last
            current = nextGroup
        
        return dummyNode.next



    def getKthNode(self, head, k):
        current = head
        while current and k > 1:
            k -= 1
            current = current.next
        return current


    def reverse(self, start, end):
        prev = end
        current = start
        while current != end:
            nextNode = current.next
            current.next = prev
            prev = current
            current = nextNode

        return prev, start
