https://leetcode.com/problems/merge-k-sorted-lists/description/

// // Time : O(nlogk) , space (n+k)
public class MergeKSortedLists(){
	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(var list: lists){
            while(list!=null){
                queue.add(list.val);
                list = list.next;
            }
        }

        ListNode result = new ListNode();
        ListNode temp = result;
        while(!queue.isEmpty()){
            result.next = new ListNode(queue.poll());
            result = result.next;
        }
        
        return temp.next;
    }


    // Time : O(nlogk) , space (k)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }


        ListNode result = new ListNode();
        ListNode current = result;

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;

            if(node.next != null){
                queue.add(node.next);
            }
        }

        return result.next;
    }
}