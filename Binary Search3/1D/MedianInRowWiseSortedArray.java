// https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

class MedianInRowWiseSortedArray:
	def median(self, mat):
        def getUpperBound(target, row):
            left, right = 0, len(row)

            while left < right:
                mid = (left + right) // 2
                
                if row[mid] > target:
                    right = mid
                else: 
                    left = mid+1
            
            return left
        
        // for each row, get all the element less the mid
        def elementGreaterThenEquals(mid):
            count = 0
            
            for row in mat:
                count += getUpperBound(mid, row)
            
            return count
        

        // get the median element, get all the element that are less then mid, if count > we can ignore mid
        row, col = len(mat), len(mat[0])
        left, right = min(row[0] for row in mat), max(row[-1] for row in mat)
        desired = (row*col)//2
        
        while left < right:
            mid = (left + right) // 2
            
            if elementGreaterThenEquals(mid) <= desired: 
                left = mid + 1
            else: 
                right = mid
        
        return left