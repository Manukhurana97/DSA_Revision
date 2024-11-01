# Time : O(2N), Space : O(N) // result space is not counted
def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':

        if not head: return head

        map = {}

        # create new Node and put in into map
        current = head
        while current:
            map[current] = Node(current.val)
            current = current.next
        

        # assign next and random pointer to new Node
        current = head
        while current:
        
            if current.next:
                map[current].next =  map[current.next]
            if current.random:
                map[current].random = map[current.random]

            current = current.next

        return map[head]

# Intruduce new Node after current node
# 
# Time : O(3N), Space : O(1) // result space is not counted
def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':

        if not head : return head

        # create new node in b/w
        # 1 - 2 - 3 :: 1 1 - 2 2 - 3 3
        current = head
        while current:
            newNode = Node(current.val, current.next)
            newNode.next = current.next
            current.next = newNode
            current = newNode.next


        # pointing random
        current = head
        while current:
            if current.random:
                current.next.random = current.random.next
            current = current.next.next
        
        # removing orignal

        current = head.next
        prev = head.next
        while current and current.next:
                newNext = current.next.next
                current.next = newNext
                current = newNext

        return head.next
