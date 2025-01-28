# https://leetcode.com/problems/construct-string-from-binary-tree/description/

class ConstructStringFromBinaryTree:
	def tree2str(self, root: Optional[TreeNode]) -> str:
        result = []

        def preorder(root): # root, left, right
            if not root: return
            
            result.append('('+str(root.val))
            if not root.left and root.right: result.append("()")

            preorder(root.left)
            preorder(root.right)
            result.append(")")

        preorder(root)
        return "".join(result)[1:-1]

# -------------------------------------------------------------------------

# public String tree2str(TreeNode root) {
#         StringBuilder builder = new StringBuilder();
#         dfs(root, builder);

#         return builder.toString().substring(1, builder.length()-1);
#     }

#     public void dfs(TreeNode root, StringBuilder builder){
#         if(root == null) return;

#         builder.append("(").append(root.val);

#         if(root.left==null && root.right!=null) builder.append("()");

#         dfs(root.left, builder);
#         dfs(root.right, builder);

#         builder.append(")");
#     }