// https://leetcode.com/problems/next-greater-node-in-linked-list/

public class NextGreaterNodeInLinkedList {
    int size = 0;
    public int[] nextLargerNodes(ListNode head) {
        head = reverseLinkedList(head);

        int[] result = new int[size];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        while(--size >=0 && head != null){
            
            while(!queue.isEmpty() && head.val >= queue.peek())
                queue.poll();
            
            if(!queue.isEmpty())
                result[size] = queue.peek();

            queue.add(head.val);
            head = head.next;
        }

        return result;
    }

    public ListNode reverseLinkedList(ListNode head){

        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while(head != null){
            ListNode next = head.next;

            head.next = prev.next;
            prev.next = head;

            head = next;
            size+=1;
        }

        return dummy.next;
    }
}
}