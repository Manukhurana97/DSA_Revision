class DeleteAllOccurrencesOfKeyInDLL:

	def deleteAllOccurOfX(self, head, x):
        # code here
        # edit the linked list
        
        current = head
        prev = None 
        
        while current:
            if current.data == x:
                if(current == head):
                    head = head.next
                else:
                    prev.next = current.next
            else:
                prev = current
            current = current.next
        
        return head