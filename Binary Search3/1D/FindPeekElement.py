class FindPeekElement:
	def findPeakElement(self, nums: List[int]) -> int:
        maxValue = 0
        n = len(nums)

        if len(nums)==1: return 0
        if nums[0] > nums[1] : return 0
        if nums[n-1] > nums[n-2] : return n-1

        left, right = 1, n-2

        while left<= right:

            mid = left + (right - left) //2

            if nums[mid-1] < nums[mid] and nums[mid] > nums[mid+1]: return mid
            
            if nums[mid] < nums[mid+1]: left = mid+1
            else: right = mid-1

        return -1