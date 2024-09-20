class ListNode{
    int val;
    ListNode prev;
    ListNode next;


    ListNode(int val){
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

// 1 2 3 4 5 6 : 2 1 3 4 5 6
// 
public class ReverseLL{

    // def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    //     dummy  = ListNode()

    //     while head:
    //         nxt = head.next

    //         head.next = dummy.next
    //         dummy.next = head

    //         head = nxt;

    //     return dummy.next

     public ListNode reverseList(ListNode head) {
       //  if(head == null || head.next == null) return head;

       //  ListNode current = head;

       //  while(current != null && current.next != null){
       //      ListNode next = current.next;
       //      current.next = next.next;
       //      next.next = head;
       //      head = next;
       //  }

       // return head;

        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // 1 2 3 4 5 6

    public static ListNode reverseListRecursion(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode node = reverseListRecursion(head.next);

        head.next.next = head;
        head.next = null;

        return node;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1); 
        head.next = new ListNode(2);  
        head.next.next = new ListNode(3);  
        head.next.next.next = new ListNode(4);  
        head.next.next.next.next = new ListNode(5);  
        head.next.next.next.next.next = new ListNode(6);  

        var node = reverseListRecursion(head);
        while(node!=null){
            System.out.print(node.val +" ");
            node = node.next;
        }
    }
}