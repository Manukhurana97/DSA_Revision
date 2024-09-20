import java.util.*;


class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode() {}
   TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
   }
}

class Node{
    int order;
    TreeNode treeNode;

  
    Node(int order, TreeNode treeNode){
        this.order = order;
        this.treeNode = treeNode;
    }
}

public class TopViewOfBinaryTree{

	public static ArrayList<Integer> topView(TreeNode root){
		if(root ==null) return new ArrayList<>();

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();

		Queue<Node> queue = new LinkedList();
		queue.add(new Node(0, root));

		while(!queue.isEmpty()){
			int size = queue.size();

			for(int ind = 0;ind < size;ind++){
				var currentNode = queue.poll();
				var currTreeNode = currentNode.treeNode;

				map.computeIfAbsent(currentNode.order, k-> new ArrayList()).add(currTreeNode.val);

				if(currTreeNode.left != null) queue.add(new Node(currentNode.order-1, currTreeNode.left));
				if(currTreeNode.right != null) queue.add(new Node(currentNode.order+1, currTreeNode.right));
			}
		}




		ArrayList<Integer> result = new ArrayList<>();
		for(var values: map.values())
			result.add(values.get(0));
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(topView(root));
	}

}