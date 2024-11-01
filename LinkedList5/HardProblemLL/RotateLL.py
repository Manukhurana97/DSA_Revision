    # Time: O(n+n), Space: O(1)
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k == 0: return head
        
        # count the length of list
        l = 0
        current = head
        while current:
            l+=1
            current = current.next

        k = k % l;
        if k == 0: return head
        
        return self.rotate(head, (l-k))

        

    def rotate(self, head, l):
        current = head
        prev = None

        # till breaking point
        for _ in range(0, l):
            prev = current
            current = current.next

        prev.next = None # break connection
        newHead = current       

        while current.next:
            # prev = current
            current = current.next
            
        current.next = head
        
        return newHead



# --------------------------------------------------------------
def rotateRight1(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
    if not head or not head.next or k == 0:
        return head
    
    l, current = 1, head
    while current.next:
        l += 1
        current = current.next
    
    k %= l
    if k == 0:
        return head
    
    current.next = head
    for _ in range(l - k):
        current = current.next
    
    new_head = current.next
    current.next = None
    
    return new_head
