class RemoveDuplicateFromSorted:

	 def removeDuplicates(self, head):
        
        current = head
        prev = None
        
        while current:
            if prev and prev.data == current.data:
                prev.next = current.next
            else:
                prev = current
            current = current.next
        
        return head