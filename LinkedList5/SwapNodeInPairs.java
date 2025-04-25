// https://leetcode.com/problems/swap-nodes-in-pairs/?

public class SwapNodeInPairs{
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode node = new ListNode();
        ListNode dummy = node, prev = head,  current = head.next;
        
        while(current != null){
            ListNode temp = current.next;

            dummy.next = current;
            current.next = prev;

            dummy = prev;
            prev = temp;
            if(prev == null || prev.next == null){
                dummy.next = prev;
                break;
            }
            current = prev.next; 
        }


        return node.next; 
    }
}