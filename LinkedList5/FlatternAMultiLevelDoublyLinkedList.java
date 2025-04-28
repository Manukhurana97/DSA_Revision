// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list

public class FlatternAMultiLevelDoublyLinkedList{

	// Time: O(2N), Space: O(n + n{stack Space})
    public Node flatten(Node head) {
        List<Node> list = new ArrayList();

        dfs(head, list);

        Node dummy = new Node(0);
        Node current = dummy;

        for(Node node: list){
            current.next = node;
            node.prev = current;

            current = current.next;
            current.child = null;
        }

        Node result = dummy.next;
        if (result != null)
            result.prev = null;

        return result;
        }

    public void dfs(Node node, List<Node> list){
        if(node == null) return;

        list.add(node);
        
        if(node.child != null) 
            dfs(node.child, list);
        dfs(node.next, list);
    }



    // --------------------------------------------------------------------------
    // failed (22 out of 26 pass)

    public Node flatten(Node head) {
        
        dfs(head);
        return head;
    }

    public Node dfs(Node head){
        if(head == null || head.next == null) return head;


        if(head.child != null){
            Node result = dfs(head.child);
            if(result != null) {
                result.next = head.next;
                head.next.prev = result;
            }
            head.next  = head.child;
            head.child.prev = head;
            head.child = null;
        }
        return dfs(head.next);
       
    }

    // ---------------------------------------------------------------------------



    public Node flatten(Node head) {
        
        dfs(head);
        return head;
    }

    public Node dfs(Node head){
        Node current = head;
        Node last = null;

        while(current != null) {
            Node next = current.next;

            if(current.child != null) {
                Node childTail = dfs(current.child);

                current.next = current.child;
                current.child.prev = current;

                if(next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                current.child = null;
                last = childTail;
            }else{
                last = current;
            }

            current = next;
        } 

        return last;
    }
}