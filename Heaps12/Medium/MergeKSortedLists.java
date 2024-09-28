https://leetcode.com/problems/merge-k-sorted-lists/description/
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
}