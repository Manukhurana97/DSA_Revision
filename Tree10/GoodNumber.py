# https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

class GoodNumber:
	def goodNodes(self, root: TreeNode) -> int:
        if not root: return 0
        
        return self.dfs(root, float('-inf'))

    def dfs(self, root, maxTillNow):
        if not root: return 0

        count = 1 if root.val>=maxTillNow else 0 
        
        count += self.dfs(root.left, max(maxTillNow, root.val))
        count += self.dfs(root.right, max(maxTillNow, root.val))

        return count

# ------------------------------------------------------------------------------------


	def goodNodes(self, root: TreeNode) -> int:
        count = 0

        def dfs(root, maxTillNow):
            nonlocal count
            if not root: return 

            if root.val>=maxTillNow:
                count +=1 
            
            dfs(root.left, max(maxTillNow, root.val))
            dfs(root.right, max(maxTillNow, root.val))

        
        dfs(root, float('-inf'))
        return count 


# ------------------------------------------------------------------------------------


# public int goodNodes(TreeNode root) {
    #     return dfs(root, root.val-1);
    # }

    # public int dfs(TreeNode root, int maxTillNow){
    #     if(root == null) return 0;

    #     int count = 0;
    #     if(maxTillNow<=root.val){
    #         maxTillNow=root.val;
    #         count +=1;
    #     }

    #     count += dfs(root.left, maxTillNow);
    #     count += dfs(root.right, maxTillNow);
    #     return count;
    # }