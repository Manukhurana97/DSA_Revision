# https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/


class BinaryTreeZigZag:
	def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        result = []
        queue = deque([root])
        index = 0
        
        while queue:
            tempresult = []
            size = len(queue)

            for _ in range(size):
                current = queue.popleft()
                tempresult.append(current.val)

                if current.left: queue.append(current.left)
                if current.right: queue.append(current.right)

            result.append(tempresult if index%2==0 else tempresult[::-1])    
            index += 1
                    
        return result    

# 	----------------------------------------------------------------------------------------


	def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        result = []
        queue = deque([root])
        index = 0
        
        while queue:
            tempresult = deque([])
            size = len(queue)

            for _ in range(size):
                
                current = queue.popleft()
                if index%2==0:
                    tempresult.append(current.val)
                else:
                    tempresult.appendleft(current.val)

                if current.left: queue.append(current.left)
                if current.right: queue.append(current.right)


            result.append(list(tempresult))    
            index += 1
                    
        return result   


    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        def dfs(root, level):
            if level == len(result): return

            if level%2==0:
                result[level].append(root.val) # left to right
            else:
                result[level].appendLeft(root.val) # right to left

            if node.left: dfs(root.left, level+1)
            if node.right: dfs(root.right, level+1)

        dfs(root, 0)
        return [list(level) for level in result]