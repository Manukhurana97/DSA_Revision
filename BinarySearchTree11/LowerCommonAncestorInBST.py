class LowerCommonAncestorInBST:
	def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        parentMap = {root: None}
        pLevel, qLevel = self.getParents(root, p, q, parentMap)


        while pLevel < qLevel and q:
            q = parentMap[q]
            qLevel-=1
        if not q: return None

        while pLevel > qLevel and p:
            p = parentMap[p]
            pLevel-=1
        if not p: return None
        
        while p and q and p != q:
            p = parentMap[p]
            q = parentMap[q]

        return p if p == q else None



    def getParents(self, root, p, q, parentMap):
        queue = deque([root])
        pLevel = qLevel = -1
        level = 0

        while queue: 
            size = len(queue)

            for _ in range(size):
                currentNode = queue.popleft()

                if p == currentNode: pLevel = level
                if q == currentNode: qLevel = level

                if currentNode.left: 
                    parentMap[currentNode.left] = currentNode
                    queue.append(currentNode.left)

                if currentNode.right: 
                    parentMap[currentNode.right] = currentNode
                    queue.append(currentNode.right)
            
            level+=1

        return pLevel, qLevel



# ------------------------------------------------------------------------

def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        while root: 
            if p.val < root.val and root.val > q.val:
                root = root.left
            elif p.val > root.val and root.val < q.val:
                root = root.right
            else: return root