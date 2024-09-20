class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


// Time: O(1), Space: O(N) + O(N) recurssion stack space
public class BinarySearchTreeIterator {

    TreeNode head = null;
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        head = root;
        stack = new Stack<>();

        InorderTriversal(head);
    }
    
    public int next() {
        var node = stack.pop();
        
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void InorderTriversal(TreeNode root){
       if(root == null) return;

       InorderTriversal(root.right);
       stack.push(root);
       InorderTriversal(root.left); 
       
    }
}

// Time: O(1), Space: O(h) // height of tree
public class BinarySearchTreeIterator{

    TreeNode head = null;
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        head = root;
        stack = new Stack<>();

        InorderTriversal(head);
    }
    
    public int next() {
        var node = stack.pop();
        if(node.right !=null) InorderTriversal(node.right);

        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void InorderTriversal(TreeNode root){
        
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
}