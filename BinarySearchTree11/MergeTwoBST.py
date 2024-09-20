# https://leetcode.com/problems/binary-search-tree-iterator/description/

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
