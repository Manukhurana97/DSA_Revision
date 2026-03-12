// https://leetcode.com/problems/path-sum-ii/

public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(root, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void recursion(TreeNode root, int sum, int target, List<Integer> list, List<List<Integer>> result) {
        if(root == null) return;

        sum += root.val;
        list.add(root.val);
        
        if(root.left == null && root.right == null && sum == target) {
            result.add(new ArrayList<>(list));
        }

        recursion(root.left, sum, target, list, result);
        recursion(root.right, sum, target, list, result);

        list.remove(list.size() - 1);
    }
}