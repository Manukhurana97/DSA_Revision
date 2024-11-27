public ShortestPathInUGWithUnitWeight{
	
	public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        int[] distances = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        
        // Created adjancy list
        for(int i = 0;i<n;i++){
            distances[i] = -1;
            adjList.add(new ArrayList<>());
        }
        
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