# https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1

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