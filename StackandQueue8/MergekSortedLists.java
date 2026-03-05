// https://leetcode.com/problems/merge-k-sorted-lists/

public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list: lists) {
            if(list != null)
                queue.add(list);
        }

        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while(!queue.isEmpty()) {
            ListNode current = queue.poll();
            prev.next = current;
            prev = current;

            if(current.next != null) queue.add(current.next);
        }

        return dummy.next;
    }	
}