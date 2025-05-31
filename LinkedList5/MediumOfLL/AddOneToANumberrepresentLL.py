# https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1

class Node:
	def __init__(self, data=0):
		self.data = data
		self.next = None

class AddOneToANumberrepresentLL:

	def addOne(self,head):
		no = 0
		current = head

		# Step 1: Extract the number from the linked list
		while current:
			no = no * 10 +current.data
			current = current.next

		no+=1
		current = prev = head

		for i in str(no):
			if not current: prev.next = current = Node()
			current.val = int(i)
			prev = current
			current = current.next

		return head


node = Node(9)
node.next = Node(9)
node.next.next = Node(9)

obj = AddOneToANumberrepresentLL()
head = obj.addOne(node)

while head:
	print(head.val, end=", ")
	head = head.nextsud



# ------------------------------------------------------------------------------------------------------------------------



# 		public Node addOne(Node head) {
        
#         head = reverse(head);
        
#         Node current = head;
#         int carry = 1;
        
#         while(current != null){
#             int sum = current.data + carry;
#             current.data = sum % 10;
#             carry = sum / 10;
            
#             if (carry == 0) break;
            
#             if(current.next == null && carry != 0){
#                 current.next = new Node(carry);
#                 carry = 0;
#             }
            
#             current = current.next;
#         }
        
        
#         return reverse(head);
#     }
    
#     public Node reverse(Node head){
#         Node prev = null;
#         Node current = head;
        
#         while(current != null){
#             Node next = current.next;
#             current.next = prev;
#             prev = current;
#             current = next;
#         }
        
#         return prev;
#     }