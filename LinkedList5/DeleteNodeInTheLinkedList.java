// https://leetcode.com/problems/delete-node-in-a-linked-list/

public class DeleteNodeInTheLinkedList {
    public void deleteNode(ListNode node) {
        
        ListNode prev = null;
        
        while(node != null) {
            if(node.next != null){
                node.val = node.next.val;
            }else{
                prev.next = null;
            }
            
            prev = node;
            node = node.next;    
        }
    }

    public void deleteNode1(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}