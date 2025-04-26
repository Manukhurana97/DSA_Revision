// https://leetcode.com/problems/insertion-sort-list/

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = head.next;
        head.next = null;

        while(current != null) {
            ListNode prev = null, temp = dummy.next, next = current.next;

            while(temp != null && temp.val<current.val){
                prev = temp;
                temp = temp.next;
            }

            if(temp != null && temp.val >= current.val) {
                if(prev == null){ // insert into head
                    current.next = temp;
                    dummy.next = current;   
                }else{
                    current.next = temp;
                    prev.next = current;
                }
            }else{
                head.next = current;
                head = current;
                head.next = null;
            }
            
            current = next;
        }


        return dummy.next;
    }



    // -----------------------------------------------------------------------------------------


    ublic ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        ListNode current = head;

       while(current != null){
        ListNode prev = dummy;
        ListNode next = current.next;

        while(prev.next != null && prev.next.val <current.val){
            prev = prev.next;
        }

        current.next = prev.next;
        prev.next = current;

        current = next;
       }


        return dummy.next;
    }

}