// https://leetcode.com/problems/reverse-linked-list-ii/

public class reverseLinkedList2{

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) return head;

        ListNode prev = null, current = head;
        while(current != null && --left >= 1 && --right > 0) {
            prev = current;
            current = current.next;
        }

        while(current != null && right-- >0) {
            current = current.next;
        }

        if(prev == null) 
            return recursion(head, current);
        else prev.next = recursion(prev.next, current);

        return head;
    }

    public ListNode recursion(ListNode head, ListNode end) {
        System.out.println(head.val + " "+(end == null ? null : end.val));

        ListNode prev = null, current = head;
        while(current != end) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head.next = end;
        return prev;
    }   
}