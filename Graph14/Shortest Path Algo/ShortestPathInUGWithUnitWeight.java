// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph-having-unit-distance

public ShortestPathInUGWithUnitWeight{
	
	public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        int[] distances = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        
        // Created adjancy list
        for(int i = 0;i<n;i++){
            distances[i] = -1;
            adjList.add(new ArrayList<>());
        }
        
        // weight we will store in distance matrix (unit weight for all nodes is 1)
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        distances[src] = 0;
        

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        
        while(!queue.isEmpty()){
            int current = queue.poll();

            for (int neighbour : adjList.get(current)) {
                if(distances[neighbour] == -1 || distances[neighbour] > distances[current] + 1){
                    distances[neighbour] = distances[current] + 1;
                    queue.add(neighbour);
                }
            }
            
        }
        
        return distances;
    }
}