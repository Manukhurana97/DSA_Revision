class ConvertSortedArrayToBST:
	def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        if not nums: return None
        if len(nums) == 1: return TreeNode(nums[0])
        
        return self.createTree(nums, 0, len(nums)-1)
        
    def createTree(self, nums, start, end):
        if start > end: return None

        mid = (start + end) // 2

        root = TreeNode(nums[mid])
        root.left = self.createTree(nums, start, mid - 1)
        root.right = self.createTree(nums, mid + 1, end)
        return root