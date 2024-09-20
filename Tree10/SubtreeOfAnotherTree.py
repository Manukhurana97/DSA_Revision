class SubtreeOfAnotherTree:
	def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        queue = deque([root])

        while queue: 
            size = len(queue)

            for _ in range(size):
                current = queue.popleft()

                if current.val == subRoot.val and self.validate(current, subRoot): 
                    return True

                if current.left: queue.append(current.left)
                if current.right: queue.append(current.right)

        return False

        

    def validate(self, root, subroot):
        if not root and not subroot: return True
        if not root or not subroot or root.val !=subroot.val: return False

    
        return self.validate(root.left, subroot.left) and self.validate(root.right, subroot.right)
