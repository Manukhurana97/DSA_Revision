//  

// // Time : O(nlogk) , space (n+k)
public class MergeKSortedLists(){

    // store all the element in priority queue and empty the queue and create tge result;
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
    // store all the head node of list in queue, which ever is smallest will come first and the move next
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list); // store only the head of all the list
            }
        }

        ListNode result = new ListNode();
        ListNode current = result;

        while(!queue.isEmpty()){
            current.next = queue.poll();
            current = current.next;

            if(current.next != null){
                queue.add(current.next);
            }
        }

        return result.next;
    }
}