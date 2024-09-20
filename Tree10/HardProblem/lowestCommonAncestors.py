# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/	

class lowestCommonAncestors:
	def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if p == root or q == root: return root
        
        ancestorMap = {root: None}
        pLevel, qLevel = self.getLevel(root, p, q, ancestorMap)
       
        while(q and pLevel<qLevel):
            q = ancestorMap[q]
            qLevel-=1
        while(p and pLevel>qLevel):
            p = ancestorMap[p]
            pLevel-=1
        
        if p == None or q == None : return None
        if p == q: return p


        while(p and q and p!=q):
            p = ancestorMap[p]
            q = ancestorMap[q]
        

        return p if p == q else None



    def getLevel(self, root, p, q, ancestorMap):

        queue = deque([root])
        pLevel = qLevel = -1
        level = 1

        while queue:
            size = len(queue)

            for _ in range(size):
                currentNode = queue.popleft()
                
                if p == currentNode: pLevel = level
                if q == currentNode: qLevel = level

                if currentNode.left:
                    ancestorMap[currentNode.left] = currentNode
                    queue.append(currentNode.left)
                
                if currentNode.right:
                    ancestorMap[currentNode.right] = currentNode
                    queue.append(currentNode.right)
            level +=1

        return pLevel, qLevel

