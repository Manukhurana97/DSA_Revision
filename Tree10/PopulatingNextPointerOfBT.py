# https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

class PopulatingNextPointerOfBT:

	# 2 queue
	def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return None

        queue = deque([root])

        while queue:
            size = len(queue)
            queue1 = deque()
            
            for i in range(size):
                currentNode = queue.popleft()
                

                if currentNode.left:
                    currentNode.left.next = currentNode.right
                    queue1.append(currentNode.left)
                if currentNode.right: 
                    if queue: currentNode.right.next = queue[0].left
                    queue1.append(currentNode.right)

            queue = queue1

        return root

# ------------------------------------------------------------------------ 


    # 1 queue
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return None

        queue = deque([root])

        while queue:
            size = len(queue)            
            for i in range(size):
                currentNode = queue.popleft()

                if i < size - 1 and queue: currentNode.next = queue[0]

                if currentNode.left:
                    queue.append(currentNode.left)
                if currentNode.right: 
                    queue.append(currentNode.right)

        return root

    # ------------------------------------------------------------------------ 

    # No Queue
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return None

        head = root

        while head.left:
            child = head

            while child:
                child.left.next = child.right 
                if child.next: child.right.next = child.next.left
                child = child.next
                
            head = head.left

        return root
        