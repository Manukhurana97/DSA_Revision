// https://leetcode.com/problems/merge-in-between-linked-lists/

public class MergeInBetweenLinkedList{
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode current = list1;
        ListNode start = null, end = null;
        
        while(current != null) {
            if(--a==0) start = current;
            if(b--==-1) end = current;

            current = current.next;
        }

        // head edge case
        if(start == list1) {
            start = list1;
        }
        
        start.next = list2;
        if(end != null) {
            while(start.next != null) {
                start = start.next;
            }
            start.next = end;
        }
        

        return list1;
    }
}