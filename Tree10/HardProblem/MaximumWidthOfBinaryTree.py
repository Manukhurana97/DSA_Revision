# https://leetcode.com/problems/maximum-width-of-binary-tree/description/

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



# ----------------------------------------------------------------------------


# class Node {
#     int order;
#     TreeNode node;

#     Node(int order, TreeNode node) {
#         this.order = order;
#         this.node = node;
#     }
# }


# class Solution {
#     public int widthOfBinaryTree(TreeNode root) {
#         int result = 1;
#         Deque<Node> queue = new LinkedList<>();
#         queue.add(new Node(0, root));

#         while(!queue.isEmpty()) {
#             int size = queue.size();
            
#             for(int i=0; i<size; i++){
#                 var current = queue.poll();

#                 if(current.node.left != null) queue.add(new Node(current.order * 2, current.node.left));
#                 if(current.node.right != null) queue.add(new Node(current.order * 2 + 1, current.node.right));
#             }

#             if(!queue.isEmpty()) {
#                 result = Math.max(result, queue.peekLast().order - queue.peekFirst().order + 1);
#             }
#         }

#         return result;
#     }
# }