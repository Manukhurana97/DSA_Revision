public class BSTIterator {

    Deque<TreeNode> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        InOrderTriversal(root);
    }
    
    public int next() {
        var current = queue.pollFirst();
        InOrderTriversal(current.right);
        return current.val;
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public void InOrderTriversal(TreeNode root){
        while(root!=null){
            queue.push(root);
            root = root.left;
        }
    }
}