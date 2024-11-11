class PostOrderTraversal:
	def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
		result = []
		self.getPostOrder(root, result)
		return result

	def getPostOrder(self, root, result):
		if not root: return result

		self.getPostOrder(root.left, result)
		self.getPostOrder(root.right, result)
		result.append(root.val)


# iteration 
	
	# 2 stack
	def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root: return result

        stack1 = [root]
        stack2 = []
        while stack1:
            current = stack1.pop()
            stack2.append(current)

            if current.left: stack1.append(current.left)
            if current.right: stack1.append(current.right)

        while stack2:
            result.append(stack2.pop().val)


        return result[::-1]

    # 1 stack
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
    	result = []
    	stack = []
    	current = root
    	lastVisited = None

    	while current and stack:
    		if current.left:
    			stack.append(current)
    			current = current.left
    		else:
    			topNode = stack[-1]
    			if topNode.right and lastVisited != topNode:
    				current = topNode.right
    			else:
    				result.append(current)
    				lastVisited = stack.pop();
    				
    	return result;


    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
	    if not root:
	        return []

	    stack = [root]
	    result = []

	    while stack:
	        current = stack.pop()
	        result.append(current.val)  # Add root to result first
	        
	        # Push left child first, so the right child is processed first in the reversed output
	        if current.left:
	            stack.append(current.left)
	        if current.right:
	            stack.append(current.right)

	    # Reverse the result list to get the correct postorder sequence
	    return result[::-1]

