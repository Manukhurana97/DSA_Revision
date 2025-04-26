// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

public class PopulatingNextRightPointersInEachNode2 {
    public Node connect(Node root) {
        if(root == null) return root;

        Node head = root;
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> temp = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            var current = queue.poll();

            if(!queue.isEmpty()){
                current.next = queue.peek();
            }

            if(current.left != null) temp.add(current.left);
            if(current.right != null) temp.add(current.right);

            if(queue.isEmpty() && !temp.isEmpty()) {
                queue.addAll(temp);
                temp.clear();
            }

        }
        
        return head;
    }



    public Node connect(Node root) {
        if(root == null) return root;

        Node head = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node current = queue.poll();

                if(i<size-1){
                    current.next = queue.peek();
                }

                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
        }
        
        return head;
    }




    public Node connect(Node root) {
        if(root == null) return root;

        Node head = root;
        
        while(root != null) {
            Node dummy = new Node(0);
            Node temp = dummy;
            Node current = root;

            while(current != null){
                if(current.left != null){
                    temp.next = current.left;
                    temp = temp.next;
                }
                if(current.right != null ){
                    temp.next = current.right;
                    temp = temp.next;
                }

                current = current.next;
            }

            root = dummy.next;
        }
        
        return head;
    }
}