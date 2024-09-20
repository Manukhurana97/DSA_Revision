class FindTheInsertionPointOfLL:

	# Time: O(N^M), Space: O(1)
	def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        currentA = headA
        while currentA:
            currentB = headB
            while currentB:
                if currentA == currentB:
                    return currentA
                currentB = currentB.next
            currentA = currentA.next
        return None



    # Time: O(N + M), Space: (N)
	def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        arr = set()
        
        currentA = headA
        while currentA:
            arr.add(currentA)
            currentA = currentA.next

        currentB = headB
        while currentB:
            if currentB in arr:
                break
            currentB = currentB.next
        return currentB



    # Time: O(N + M), Space: (1)
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        currentA, currentB = headA, headB

        while currentA != currentB:

            currentA = currentA.next if currentA else headB
            currentB = currentB.next if currentB else headA

        return currentA
