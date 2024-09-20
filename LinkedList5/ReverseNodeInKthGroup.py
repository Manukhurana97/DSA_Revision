    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k <= 1: return head 

        prev = dummyNode = ListNode(None)
        current = head
        
        while current :
            kth = self.getKthNode(current, k) # get kth (last node) node
            
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


# 1 2 3 4 | 5 :: current = start = 1, last = end = 4
# 1-> 4 -> 5 -> 6,  current = 2, last = 4
# 2 -> 1 -> 4 -> 5 -> 6, current = 2, last = 1
# 3 -> 2 -> 1-> 4 -> 5 -> 6, last = 3, c = 4
    def reverse(self, start, end):
        last = end
        current = start
        while current != end:
            nextNode = current.next
            current.next = last
            last = current
            current = nextNode

        return last, start
