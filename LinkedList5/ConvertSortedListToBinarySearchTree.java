// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

public class ConvertSortedListToBinarySearchTree{
	public TreeNode sortedListToBST(ListNode head) {
       

        List<Integer> list = new ArrayList<>();
        while(head!= null){
            list.add(head.val);
            head = head.next;
        }

        return createTree(0, list.size()-1, list);
    }

    public TreeNode createTree(int start, int end, List<Integer> list) {
        if(start > end) return null;

        int mid = start + (end - start) / 2;
        
        TreeNode root = new TreeNode(list.get(mid));
        root.left = createTree(start, mid-1, list);
        root.right = createTree(mid+1, end, list);
        return root;
    }
}