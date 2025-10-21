// https://leetcode.com/problems/partition-list/

public class PartitionList{

    public ListNode partition(ListNode head, int x) {
        // find the largest element
        ListNode current = head, prev = null;

        while(current != null){
            if(current.val >= x){
                break;
            }

            prev = current;
            current = current.next;
        }

        // if not element is greater then x, return;
        if(current == null) return head;

        
        ListNode cPrev = current;
        while(current != null){
            if(current.val < x) {
                if(prev == null){
                    cPrev.next = current.next;
                    current.next = head;

                    prev = head = current;
                    current = cPrev;
                }
                else{
                    cPrev.next = current.next;
                    current.next = prev.next;
                    prev.next = current;

                    prev = prev.next;
                    current = cPrev;
                }
            }

            cPrev = current;
            current = current.next;
        }

        return head;
    }


// -------------------------------------------------------------------------


    public ListNode partition(ListNode head, int x) {
        ListNode lessthenDummy = new ListNode();
        ListNode greaterthenDummy = new ListNode();
        ListNode prev1 = lessthenDummy, prev2 = greaterthenDummy;

        while(head != null) {
            if(head.val < x) {
                prev1.next = head;
                prev1 = prev1.next;
            } else{
                prev2.next = head;
                prev2 = prev2.next;
            }

            head = head.next;
        }

        prev2.next = null;
        prev1.next = greaterthenDummy.next;
        return lessthenDummy.next;
    }
}