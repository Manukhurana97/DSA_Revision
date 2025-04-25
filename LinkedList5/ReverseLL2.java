// https://leetcode.com/problems/reverse-linked-list-ii/

public class reverseLinkedList2{

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left>=right) return head;

        ListNode current = head, prev = null;
        int pos = left;
        while(current != null && --pos>0){
            prev = current;
            current = current.next;
        }

        if(current == null) return head;
        
        ListNode response = rotate(current, right - left + 1);

        if(prev == null) return response;
        prev.next = response;

        return head;
    }


    public ListNode rotate(ListNode current, int count) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy, last = current;


        while(current != null && --count>=0){
            ListNode next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = next;
        }

        last.next = current;
        return dummy.next;
    }
}