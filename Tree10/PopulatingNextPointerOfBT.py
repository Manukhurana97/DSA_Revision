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


    # 1 queue
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return None

        queue = deque([root])

        while queue:
            size = len(queue)            
            for i in range(size):
                currentNode = queue.popleft()

                if i< size - 1 and queue:
                    currentNode.next = queue[0]

                if currentNode.left:
                    queue.append(currentNode.left)
                if currentNode.right: 
                    queue.append(currentNode.right)

        return root

    # No Queue
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return None

        leftMost = root

        while leftMost.left:
            head = leftMost

            while head:
                head.left.next = head.right 
                if head.next: head.right.next = head.next.left
                head = head.next
                
            leftMost = leftMost.left

        return root
        
        