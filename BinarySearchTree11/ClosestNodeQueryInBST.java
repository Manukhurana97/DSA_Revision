// https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/

public class ClosestNodeQueryInBST {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        List<List<Integer>> answer = new ArrayList<>();
        for(int i: queries) {
            answer.add(getIndex(i, list));
        }
        return answer;
    }

    public List<Integer> getIndex(int val, List<Integer> list) {
        int start = 0, end = list.size()-1;
        int lower = -1, upper = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = list.get(mid);

            if(midVal == val) {
                return List.of(midVal, midVal);
            }
            if(midVal < val) {
                lower = midVal;
                start = mid+1;
            } else{
                upper = midVal;
                end = mid-1;
            }
        }
        return List.of(lower, upper);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
