// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class DeleteDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        
        ListNode current = head;
        while(current != null) {
            map.put(current.val, map.getOrDefault(current.val, 0)+1);
            current = current.next;
        }

        ListNode prev = head;
        current = head;
        while(current != null){
            if(map.get(current.val) > 1){
                if(current == head) {
                    prev = head = head.next;
                }else{
                    prev.next = current.next;
                }
            }else{
                prev = current;
            }
            
            current = current.next;
        }

        return head;
    }

}