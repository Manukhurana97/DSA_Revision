class TwoSum:
	def findTarget(self, root: Optional[TreeNode], k: int) -> bool:


        valSet = set()
        queue = deque([root])

        while queue:

            size = len(queue)
            for _ in range(size):
                root = queue.popleft()
                
                if (k - root.val) in valSet: return True

                valSet.add(root.val) 

                if root.left:  queue.append(root.left)
                if root.right:  queue.append(root.right)
            
        return False