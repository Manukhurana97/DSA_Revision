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


# -------------------------------------------------------------------------------------

    # Map<Integer, List<TreeNode>> dp = new HashMap<>();
    # public List<TreeNode> allPossibleFBT(int n) {

    #     return recursion(n);
    # }

    # private List<TreeNode> recursion(int n){
    #     if(n == 0) return new ArrayList<>();
    #     if(n == 1) return Collections.singletonList(new TreeNode());

    #     if(dp.containsKey(n)) return dp.get(n);

    #     List<TreeNode> list = new ArrayList<>();

    #     for(int i=0; i<n; i++){
    #         List<TreeNode> left = recursion(i);
    #         List<TreeNode> right = recursion(n-i-1);

    #         // backTrack: [t1, t2], rightTree: [t3, t1] :: t-Tree
    #         // its possible root is left child of t1, right child of t3/t4
    #         // its possible root is left child of t2, right child of t3/t4

    #         // all possible combinations

    #         for(TreeNode t1: left){
    #             for(TreeNode t2: right){
    #                 list.add(new TreeNode(0, t1, t2));
    #             }
    #         }
    #     }

    #     dp.put(n, list);
    #     return list;
    # }
		