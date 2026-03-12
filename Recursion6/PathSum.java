// https://leetcode.com/problems/path-sum/description/

public class PathSum {
	public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return recursion(root, 0, targetSum);
    }

    private boolean recursion(TreeNode root, int sum, int target) {
        if(root == null) return false;
        
        sum += root.val;
        
        if(root.left == null && root.right == null) {
            return sum == target;
        }

        return recursion(root.left, sum, target) || recursion(root.right, sum, target);
    }
}