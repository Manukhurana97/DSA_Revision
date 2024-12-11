// https://leetcode.com/problems/clone-graph/

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class CloneGraph{
	public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        Map<Integer, Node> map = new HashMap<>();
        return clone(map, node);
    }

    public Node clone(Map<Integer, Node> map, Node node){
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);

        for(var neighbour: node.neighbors){
            newNode.neighbors.add(clone(map, neighbour));
        }

        return newNode;
    }
}