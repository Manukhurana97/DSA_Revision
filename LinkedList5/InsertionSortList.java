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


    // -----------------------------------------------------------------------------------------



    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-5001, head);
        ListNode current = head.next, tail = head;
        int maxTillNow = head.val;

        while(current != null) {
            ListNode next = current.next;

            if(current.val < maxTillNow) {
                
                ListNode tHead = dummy, tPrev = dummy;
                while(current.val > tHead.val) {
                    tPrev = tHead;
                    tHead = tHead.next;
                }

                current.next = tHead;
                tPrev.next = current;
                tail.next = next;
            } else {
                tail = current;
            }

            maxTillNow = Math.max(maxTillNow, current.val);
            current = next;
        }

        return dummy.next;
    }

}