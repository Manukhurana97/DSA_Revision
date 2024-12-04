class Node{
    int edge;
    int parent;
    int weight;
    
    Node(int edge, int parent, int weight){
        this.edge = edge;
        this.parent = parent;
        this.weight = weight;
    }
}

public class PrimsAlgorithm{
	static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int sum = 0;
        
        // log w
        boolean[] visited = new boolean[V];

        // Log e
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        queue.add(new Node(0, -1, 0));
        
        // E
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            if(visited[current.edge]) continue;
            visited[current.edge] = true;
            
            sum += current.weight;
            
            for(int[] neighbour: adj.get(current.edge)){
                if(!visited[neighbour[0]])
                    queue.add(new Node(neighbour[0], current.edge, neighbour[1]));
            }
        }
        
        for(boolean flag: visited) 
        	if(!flag) 
        		return -1;
        
        
        
        return sum;
    }
}