class Node:
    def __init__(self, order=0, treeNode=None):
        self.order = order
        self.treeNode = treeNode

class MaximumWidthOfBinaryTree:

	# order is just an index of node
	# 		1
	#     2   3
	#   4       7
	# 8           15 
	# 2n          2n+1   
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        
        queue = deque([Node(0, root)])
        maxPossibleWidth = 1

        while queue:
            size = len(queue)
            for _ in range(size):
                node = queue.popleft()
                currentNode = node.treeNode

                if currentNode.left: queue.append(Node(node.order * 2, currentNode.left)) 
                if currentNode.right: queue.append(Node(node.order * 2 + 1, currentNode.right))
            
            if queue:
                maxPossibleWidth = max(maxPossibleWidth, queue[-1].order - queue[0].order + 1)
        return maxPossibleWidth

