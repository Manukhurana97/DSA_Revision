# https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

class AllNodesDistanceKInBinaryTree:


	# change the input , by removing the connection of prev parent/ target node
	def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        
        if not root: return []
        
        parentMap = {}
        self.computeParents(root, parentMap, None)

        result = []        

        # get from parents
        currentTarget = target
        prevTarget = None

        while currentTarget and k>=0:

            self.getBottomNodes(currentTarget, k, result)

            prevTarget = currentTarget
            currentTarget = parentMap[currentTarget]
            k-=1

            if currentTarget and prevTarget: # breaking the connection of prevous target node
                if currentTarget.left == prevTarget: currentTarget.left = None
                if currentTarget.right == prevTarget: currentTarget.right = None

        return result


    def computeParents(self, root, parentMap, parent):
        # queue = deque([root])

        # while queue:
        #     size = len(queue)
        #     for _ in range(size):
        #         currentNode = queue.pop();
                
        #         if currentNode.left:
        #             parentMap[currentNode.left] = currentNode
        #             queue.append(currentNode.left)
                
        #         if currentNode.right:
        #             parentMap[currentNode.right] = currentNode
        #             queue.append(currentNode.right)

        if not root: return 
        parentMap[root] = parent

        self.computeParents(root.left, parentMap, root)
        self.computeParents(root.right, parentMap, root)



    def getBottomNodes(self, root, k, result):
        if not root or k < 0: return
        if k == 0: 
            result.append(root.val)
            return

        self.getBottomNodes(root.left, k-1, result)
        self.getBottomNodes(root.right, k-1, result)


# ------------------------------------------------------------------------------------------------


# Use visited to keep the track of visited nodes

# All Nodes Distance K in Binary Tree
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        
        if not root: return []
        
        parentMap = {}
        self.computeParents(root, parentMap, None)

        result = []  
        visited = set()      

        # get from parents
        currentTarget = target
        prevTarget = None

        while currentTarget and k>=0:
        	if currentTarget not in visited:
            	self.getBottomNodes(currentTarget, k, result, visited)
            currentTarget = parentMap[currentTarget]
            k-=1

            

        return result


    def computeParents(self, root, parentMap, parent):
        # queue = deque([root])

        # while queue:
        #     size = len(queue)
        #     for _ in range(size):
        #         currentNode = queue.pop();
                
        #         if currentNode.left:
        #             parentMap[currentNode.left] = currentNode
        #             queue.append(currentNode.left)
                
        #         if currentNode.right:
        #             parentMap[currentNode.right] = currentNode
        #             queue.append(currentNode.right)

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