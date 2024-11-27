public class ShortestPathinDAG{
	
	public int[] shortestPath(int V, int E, int[][] edges, int source) {
    // Step 1 : perform topological sort
    
    // 1.1 : create adjacency list
    List<List<int[]>> adjList = new ArrayList<>();
    for (int i = 0; i < V; i++) {
        adjList.add(new ArrayList<>());
    }
    
    for (int[] edge : edges) {
        adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }
    
    // 1.2 on each node perform DFS if not visited
    Stack<Integer> stack = new Stack<>();
    int[] visited = new int[V];
    for (int i = 0; i < V; i++) {
        if (visited[i] == 0) {
            dfs(i, adjList, visited, stack);
        }
    }

    // Step 2: calculate distances
    int[] dist = new int[V];
    for (int i = 0; i < V; i++) {
        dist[i] = Integer.MAX_VALUE;
    }

    dist[source] = 0; // starting point

    while (!stack.isEmpty()) {
        int current = stack.pop();

        // If the current node is unreachable, skip it
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

public void dfs(int current, List<List<int[]>> adjList, int[] visited, Stack<Integer> stack) {
    visited[current] = 1;

    for (int[] neighbour : adjList.get(current)) {
        if (visited[neighbour[0]] == 0) { // check the node, not the edge
            dfs(neighbour[0], adjList, visited, stack);
        }
    }

    stack.push(current);
}

}