// https://leetcode.com/problems/rotate-list/

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int len = 1;
        ListNode last = head;

        while(last.next != null) {
            len+=1;
            last = last.next;
        }

        k %= len;
        if(k == 0) return head;
        
        ListNode prev = head, current = head;
        
        while(len-- > k) {
            prev = current;
            current = current.next;
        }

        prev.next = null;
        last.next = head;
        retur
}