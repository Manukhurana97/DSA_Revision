# https://leetcode.com/problems/merge-two-binary-trees/

class MergeTwoBST:   

    def __init__(self, root: Optional[TreeNode]):
        self.inorderArr = deque([])
        # self.inorder(root, self.inorderArr)
        self.partialInOrder(root, self.inorderArr)


    def next(self) -> int:
        # return self.inorderArr.popleft() if self.inorderArr else None
       
        currentNode = self.inorderArr.pop()
        self.partialInOrder(currentNode.right, self.inorderArr)
        return currentNode.val
        

    def hasNext(self) -> bool:
        return len(self.inorderArr) > 0

    
    def inorder(self, root, inorderArr):
        if not root: return None

        self.inorder(root.left, inorderArr)
        inorderArr.append(root.val)
        self.inorder(root.right, inorderArr)
    
    def partialInOrder(self, root, inorderArr):
        while root :
            inorderArr.append(root)
            root = root.left

# -----------------------------------------------------------------------------------

# class Solution {
#     public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
#         if(root1 == null && root2==null) return null;
#         if(root1 == null) return root2;
#         if(root2 == null) return root1;
#         root1.val+=root2.val;
        
#         root1.left = mergeTrees(root1.left, root2.left);
#         root1.right = mergeTrees(root1.right, root2.right);
        
#         return root1;
#     }
# }
