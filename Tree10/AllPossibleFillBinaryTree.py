# https://leetcode.com/problems/all-possible-full-binary-trees/

class AllPossibleFillBinaryTree:
	def allPossibleFBT(self, n: int) -> List[Optional[TreeNode]]:
        visited = {} # n: list of FBT
        # return the list of full binary tree with n nodes
        def backTrack(n):
            if n == 0: return []
            if n == 1: return [TreeNode()]

            if n in visited:
                return visited[n]

        
            res = []
            for l in range(n):
                r = n - l - 1
                leftTree, rightTree =  backTrack(l), backTrack(r)

                # backTrack: [t1, t2], rightTree: [t3, t1] :: t-Tree
                # its possible root has left child of t1, right child of t3/t4
                # its possible root has left child of t2, right child of t3/t4

                # all possible combinations
                for t1 in leftTree:
                    for t2 in rightTree:
                        res.append(TreeNode(0, t1, t2))
            
            visited[n] = res
            return res

        return backTrack(n)
		