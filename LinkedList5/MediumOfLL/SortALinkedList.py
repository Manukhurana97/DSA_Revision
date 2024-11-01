class SortALinkedList:

	# Time : O(N^2)
	def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        current = head
        while current:
            next = current.next
            while next:
                if next.val < current.val:
                    current.val, next.val = next.val, current.val

                next = next.next;
            current = current.next
        return head


	# Time : O(2N + NlogN), Space: O(N)
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        arr = []

        current = head
        while current:
            arr.append(current.val)
            current = current.next

        arr.sort()

        current = head
        for i in arr:
            current.val = i
            current = current.next

        return head


    # Time : O(NlogN), Space: O(1)
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        if not head or not head.next:
            return head

        left = head
        right = self.getMid(head)
        temp = right.next
        right.next = None
        right = temp

        left = self.sortList(left)
        right = self.sortList(right)
        return self.merge(left, right)


    
    def getMid(self, head):
        fast = head.next
        slow = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        return slow
    
    def merge(self, left, right):
        
        dummy = ListNode(None)
        current = dummy

        while left and right:
            if left.val < right.val:
                current.next = left
                left = left.next
            else:
                current.next = right
                right = right.next
            current = current.next
            current.next = None

        while left :
            current.next = left
            left = left.next
            current = current.next
            current.next = None

        while right:
            current.next = right
            right = right.next
            current = current.next
            current.next = None
        
            
        return dummy.next

