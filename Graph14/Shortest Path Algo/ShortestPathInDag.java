public class ShortestPathInDag{
	public int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1 : perform toposort
        
        int n = V;
        
        // 1.1 : create adjacency list
	    List<List<int[]>> adjList = new ArrayList<>();
	    for (int i = 0; i < V; i++) {
	        adjList.add(new ArrayList<>());
	    }
        
        for(int[] edge: edges){
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        
        //1.2 on each node perform dfs if not visited
        Stack<Integer> stack = new Stack<>();
	    int[] visited = new int[V];
	    for (int i = 0; i < V; i++) {
	        if (visited[i] == 0) {
	            dfs(i, adjList, visited, stack);
	        }
	    }

        //Step: 2, calculate distance
        int[] dist = new int[V];
        for(int i = 0; i < n; i++){
        	dist[i] = Integer.MAX_VALUE;
        }

        dist[0] = 0;

        while(!stack.isEmpty()){
        	int current = stack.pop();

        	if (dist[current] == Integer.MAX_VALUE) continue;

        for (int[] neighbour : adjList.get(current)) {
            int v = neighbour[0]; // destination
            int wt = neighbour[1]; // weight

            if (dist[v] > dist[current] + wt) {
                dist[v] = dist[current] + wt;
            }
        }
        }

        // Replace any remaining Integer.MAX_VALUE with -1 to indicate unreachable nodes
	    for (int i = 0; i < V; i++) {
	        if (dist[i] == Integer.MAX_VALUE) {
	            dist[i] = -1;
	        }
	    }

        return dist;
    }

    public void dfs(int current, List<List<int[]>> adjList, int[] visited, Stack<Integer> stack){
    	visited[current] = 1;

    	for(int[] neighbours: adjList.get(current)){
    		if(visited[neighbours[0]] == 0){
    			dfs(neighbours[0], adjList, visited, stack);
    		}
    	}

    	stack.push(current);
    }
}