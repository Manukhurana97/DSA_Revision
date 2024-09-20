class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Reverse:

    def reverseList(self, head):
        dummyNode = ListNode(None)
        current = head

        while current :
            next = current.next
            current.next = dummyNode.next
            dummyNode.next = current
            current = next

        return dummyNode.next

head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)

obj = Reverse()
node = obj.reverseList(head)

while node:
    print(node.val)
    node = node.next




