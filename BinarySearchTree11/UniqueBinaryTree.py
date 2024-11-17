class UniqueBinaryTree:
	def numTrees(self, n: int) -> int:
        numsTree = [1] * (n + 1)

        for nodes in range(2, n+1): # 1 2 3 4 5
            total = 0
            for root in range(1, nodes+1): # 1 2 |3| 4 5
                left = root - 1
                right = nodes - root
                total += numsTree[left] * numsTree[right]
            
            numsTree[nodes] = total
        
        return numsTree[n]
		