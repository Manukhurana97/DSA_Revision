public class ChildSumParent{
	public static int isSumProperty(Node root){
        if(root == null) return 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if(current.left == null && current.right == null) continue;

            int left = (current.left != null) ? current.left.data : 0;
            int right = (current.right != null) ? current.right.data : 0;
        
            if(left + right != current.data) return 0;
        }
    }
}