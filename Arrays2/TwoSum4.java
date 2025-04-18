public class TwoSum4 {
	public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if(root == null) return false;
        if(set.contains(k - root.val)) return true;

        set.add(root.val);
        if(dfs(root.left, k, set)) return true;
        if(dfs(root.right, k, set)) return true;
        return false;
    }
}