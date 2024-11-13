public class ChildSumParent{
	public static int isSumProperty(Node root){
        if(root == null) return 1;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                var currentNode = queue.remove();
                
                int left = 0, right = 0;
                if(currentNode.left != null){
                    left = currentNode.left.data;
                    queue.add(currentNode.left);
                }
                
                if(currentNode.right !=null){
                    right = currentNode.right.data;
                    queue.add(currentNode.right);
                }
                
                if(left == 0  && right == 0) continue;
                if( left+right != currentNode.data) return 0;
            }
        }
        
        
        return 1;
    }
}