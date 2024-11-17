# https://leetcode.com/problems/trim-a-binary-search-tree/description/

class TrimABST:
	def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:

        while root and  ( root.val < low or root.val > high):
            root = root.right if low > root.val else root.left

        if not root: return None # while value can be 0


        queue = deque([root])
        while queue:
            size = len(queue)

            for _ in range(size):
                current = queue.popleft()
               
                
                while current and current.left and current.left.val < low:  current.left = current.left.right
                if current.left: 
                    queue.append(current.left)
                
                while current and current.right and current.right.val > high:  current.right = current.right.left
                if current.right: 
                    queue.append(current.right)

        return root


    # --------------------------------- DFS ------------------------------------------


    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
        if not root: return None


        if root.val < low: return self.trimBST(root.right, low, high)
        if root.val > high: return self.trimBST(root.left, low, high)


        root.left = self.trimBST(root.left, low, high)
        root.right = self.trimBST(root.right, low, high)

        return root
