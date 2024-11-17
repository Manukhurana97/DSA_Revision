1import java.util.*;


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



public class RightSideView{
	public static List<Integer> rightSideView(TreeNode root) {
		if(root == null){
			return new ArrayList();
		}

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		Queue<Node> queue = new LinkedList();
		queue.add(new Node(0, root));

		while(!queue.isEmpty()){
			int size = queue.size();
			for(int ind = 0;ind<size;ind++){
				var currentNode = queue.poll();
				var currTreeNode = currentNode.treeNode;

				map.computeIfAbsent(currentNode.order, k-> new ArrayList<>()).add(currTreeNode.val);

				if(currTreeNode.left !=null) queue.add(new Node(currentNode.order + 1, currTreeNode.left));
				if(currTreeNode.right !=null) queue.add(new Node(currentNode.order + 1, currTreeNode.right));
			}
		}

		List<Integer> result = new LinkedList();
		for(var values: map.values()){
            // result.add(values.get(0)); // for left view
			result.add(values.get(values.size()-1)); // for right view
		}


        return result;
    }


    /*
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        q = collections.deque()
        q.append(root)
        rightside = []

        while q:
            for _ in range(len(q)):
                node = q.popleft()

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

            rightside.append(node.val)

        return rightside
        */

    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);

		System.out.println(rightSideView(root));
    }
}