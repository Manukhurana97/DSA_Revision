// https://leetcode.com/problems/odd-even-linked-list/

public class OddEvenLinkedList{
	public ListNode oddEvenList(ListNode head) {
        ListNode evenDummy = new ListNode();
        ListNode oddDummy = new ListNode();
        ListNode even = evenDummy;
        ListNode odd = oddDummy;

        int i = 0;
        while(head != null){
            if(i%2 == 1){
                even.next = head;
                even = even.next;
            }else{
                odd.next = head;
                odd = odd.next;
            }
            i+=1;
            head = head.next;
        }
    
	    even.next = null;
	    odd.next = evenDummy.next;
	    return oddDummy.next;
    }
}