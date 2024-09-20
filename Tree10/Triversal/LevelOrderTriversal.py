# 
# public class TreeNode {
#      int val;
#      TreeNode left;
#      TreeNode right;
#      TreeNode() {}
#      TreeNode(int val) { this.val = val; }
#      TreeNode(int val, TreeNode left, TreeNode right) {
#          this.val = val;
#          this.left = left;
#          this.right = right;
#      }
#  }

# class Solution {
#     public List<List<Integer>> levelOrder(TreeNode root) {
#         List<List<Integer>> result = new ArrayList<>();

#         if (root == null) return result;

#         Queue<TreeNode> queue = new LinkedList<>();
#         queue.add(root);

#         while(!queue.isEmpty()){
#             List<Integer> tempStorage = new ArrayList<>();
#             int size = queue.size();

#             while(--size >= 0){
#                 var current = queue.remove();
#                 tempStorage.add(current.val);

#                 if(current.left !=null ) queue.add(current.left);
#                 if(current.right !=null ) queue.add(current.right);
#             }

            
#             result.add(tempStorage);
                
#         }

#         return result;
#     }
# }




from collection import deque

class TreeNode:
	def __init__(self, val: int = 0, left: Optional['TreeNode'] = None, right: Optional['TreeNode'] = None):
		self.val = val
		self.left = left
		self.right = right


class LevelOrderTriversal:

	def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
		result = []

		if not root: return result

		queue = deque([root])

		while queue:
			tempStorage = []
			size = len(queue)

			for _ in range(size):
				current = queue.popleft()
				tempStorage.append(current.val)

				if current.left: queue.append(current.left)
				if current.right: queue.append(current.right)

			result.append(tempStorage)

	return result