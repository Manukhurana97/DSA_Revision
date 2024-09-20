import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class BurningTree {
	
	static Node targetNode = null;
	public static int minTime(Node root, int target) {
        Map<Node, Node> parents = new HashMap<>();

        getParents(root, null, target, parents);

        return checkBottomNodes(targetNode, parents);
    }


    public static int checkBottomNodes(Node targetNode, Map<Node, Node> parents){ 
    	int level = 0;

    	Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(targetNode);
        visited.add(targetNode);

    	while(!queue.isEmpty()){
    		int size = queue.size();

    		for(int i = 0; i < size; i++){
    			var currentNode = queue.poll();
    			
    			// left
    			if(currentNode.left != null && !visited.contains(currentNode.left)){ 
    				queue.add(currentNode.left);
    				visited.add(currentNode.left);
    			}

    			// right
    			if(currentNode.right != null && !visited.contains(currentNode.right)){ 
    				queue.add(currentNode.right);
    				visited.add(currentNode.right);
    			}

    			// parent
    			Node parent = parents.get(currentNode);
                if(parent != null && !visited.contains(parent)){
                    queue.add(parent);
                    visited.add(parent);
                }
    		}

    		if(!queue.isEmpty()) level += 1;
    	}


    	return level;
    }


    public static void getParents(Node root, Node parent, int target, Map<Node, Node> parentMap){
    	if(root == null) return;

    	parentMap.put(root, parent);

    	if(target == root.data) targetNode = root;

    	getParents(root.left, root, target, parentMap);
    	getParents(root.right, root, target, parentMap);
    }

    public static void main(String[] args){
    	Node root = new Node(1);
    	root.left = new Node(2);
    	root.right = new Node(3);
    	root.left.left = new Node(4);
    	root.left.right = new Node(5);
    	root.left.right.left = new Node(7);
    	root.left.right.right = new Node(8);
    	root.right.right = new Node(6);
    	root.right.right.right = new Node(7);
    	root.right.right.right.right = new Node(10);

    	System.out.println(minTime(root, 8));


    	root = new Node(1);
    	root.left = new Node(2);
    	root.right = new Node(3);
    	root.left.left = new Node(4);
    	root.left.right = new Node(5);
    	root.right.right = new Node(7);
    	root.left.left.left = new Node(8);
    	root.left.right = new Node(10);

    	System.out.println(minTime(root, 10));
    }

}
