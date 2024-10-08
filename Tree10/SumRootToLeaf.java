// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

public class SumRootToLeaf{
	public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }


    public int sumNumbers(TreeNode root, int sum) {

        if(root == null) return 0;
        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) return sum;

        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }
}