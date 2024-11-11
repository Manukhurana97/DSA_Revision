/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Node{
    int level;
    int order;
    TreeNode treeNode;

    Node(int level, TreeNode treeNode){
        this.level = level;
        this.treeNode = treeNode;
    }
    
    Node(int level, int order, TreeNode treeNode){
        this.level = level;
        this.order = order;
        this.treeNode = treeNode;
    }
}

public class VerticalOrderTriversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if(root == null) return new ArrayList<>(); 

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, root));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                TreeNode current = node.treeNode;
                
                map.computeIfAbsent(node.order, k -> new TreeMap<>())
                .computeIfAbsent(node.level, k-> new PriorityQueue<>())
                .add(current.val);

                if (current.left != null) queue.add(new Node(node.level + 1, node.order - 1 ,current.left));
                if (current.right != null) queue.add(new Node(node.level + 1, node.order + 1,  current.right));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (var levelMap : map.values()) {
            List<Integer> vals = new ArrayList<>();
            for (var pq : levelMap.values()) {
                while(!pq.isEmpty()){
                    vals.add(pq.poll());
                }
            }
            result.add(vals);
        }

        return result;
    }


    // ---------------------------------------------------------------------------------------------------


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        dfs(root, 0, 0, map);

        for(var value: map.values()){
            List<Integer> vals = new ArrayList<>();
            for (var pq : value.values()) {
                while(!pq.isEmpty()){
                    vals.add(pq.poll());
                }
            }
            result.add(vals);
        }

        return result;
    
    }

    public void dfs(TreeNode root, int order, int level, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map ){
        if(root == null) return;

        map.computeIfAbsent(order, k -> new TreeMap<>()).computeIfAbsent(level, k-> new PriorityQueue<>()).add(root.val);

        dfs(root.left, order-1, level + 1, map);
        dfs(root.right, order+1, level+1, map);
    }
}