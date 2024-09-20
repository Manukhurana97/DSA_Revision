from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left = None, right = None):
        self.left = left
        self.right = right
        self.val = val

class InOrderTriversal: # (left root right)
	# def inOrderTraversal(self, root: Optional[TreeNode]) -> List[int]:
    #     result = []
    #     if not root: return result

    #     self.getInOrder(root, result)

    #     return result
        
    # def getInOrder(self, root, result):
    #     if not root : return
        
    #     self.getInOrder(root.left, result)
    #     result.append(root.val)
    #     self.getInOrder(root.right, result)
		

# Iterative

    def inOrderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root: return result

        stack = []
        current = root

        while stack or current:
            while current :
                stack.append(current)
                current = current.left

            current = stack.pop()
            result.append(current.val)

            
            current = current.right

        return result


tree = TreeNode(1)
tree.left = TreeNode(2)
tree.right = TreeNode(3)
tree.left.left = TreeNode(4)
tree.left.right = TreeNode(5)
tree.right.left = TreeNode(6)
tree.right.right = TreeNode(7)
tree.left.left.right = TreeNode(8)
tree.left.left.right.left = TreeNode(9)
tree.left.left.right.right = TreeNode(10)


obj = InOrderTriversal()
print(obj.inOrderTraversal(tree))