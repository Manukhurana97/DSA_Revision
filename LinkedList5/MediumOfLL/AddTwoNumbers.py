class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class AddTwoNumbers:

    def addTwoNumbers(self, l1, l2): 
        
        dummyNode = ListNode(None)
        dummy = dummyNode

        carry = 0

        while l1 and l2:
            sum = l1.val + l2.val + carry
            dummy.next = ListNode(sum % 10)
            carry = sum // 10;

            l1 = l1.next
            l2 = l2.next
            dummy = dummy.next
        
        while l1:
            sum = l1.val + carry
            dummy.next = ListNode(sum%10)
            carry = sum//10;

            l1 = l1.next
            dummy = dummy.next

        while l2:
            sum = l2.val + carry
            dummy.next = ListNode(sum%10)
            carry = sum//10;

            l2 = l2.next
            dummy = dummy.next
        
        while carry >0:
            dummy.next = ListNode(carry%10)
            carry//=10


        return dummyNode.next

node1 = ListNode(2)
node1.next = ListNode(4)
node1.next.next = ListNode(3)

node2 = ListNode(5)
node2.next = ListNode(6)
node2.next.next = ListNode(4)

obj = AddTwoNumbers()
head = obj.addTwoNumbers(node1, node2);


while head:
    print(head.val)
    head = head.next
