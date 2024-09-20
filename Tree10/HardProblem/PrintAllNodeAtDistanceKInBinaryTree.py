class PrintAllNodeAtDistanceKInBinaryTree:
	def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        
        if not root: return []
        
        parentMap = {}
        self.computeParents(root, parentMap, None)

        result = []  
        visited = set()      

        # get from parents
        currentTarget = target
        prevTarget = None

        while currentTarget and k >= 0:
            if currentTarget not in visited:
                self.getBottomNodes(currentTarget, k, result, visited)
            currentTarget = parentMap[currentTarget]
            k-=1

            

        return result


    def computeParents(self, root, parentMap, parent):
        if not root: return 
        parentMap[root] = parent

        self.computeParents(root.left, parentMap, root)
        self.computeParents(root.right, parentMap, root)



    def getBottomNodes(self, root, k, result, visited):
        if not root or k < 0: return
        if k == 0: 
            result.append(root.val)
            return
        visited.add(root)

        if root and root.left not in visited:
            self.getBottomNodes(root.left, k-1, result, visited)
        if root and root.right not in visited:
            self.getBottomNodes(root.right, k-1, result, visited)
