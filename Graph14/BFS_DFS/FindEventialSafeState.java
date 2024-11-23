public class FindEventialSafeState{

	// anyone leads to a cycle is not a safe node
	// anyone is a part of cycle is not a safe node
	List<Integer> eventualSafeNodes(int n, List<List<Integer>> adj) {

		int[] visited = new int[n];
		int[] pathVisited = new int[n];
		int[] check = new int[n];
		

		for(int i=0;i<n;i++){
			if(visited[i] == 0)
				dfs(i, adj, visited, pathVisited, check);
			
		}

		List<Integer> result = new ArrayList<>();
		for(int i = 0;i<n;i++){
			if(check[i] == 1){
				result.add(i);
			}
		}
		return result;
    }

    public boolean dfs(int current, List<List<Integer>> adj, int[] visited, int[] pathVisited, int[] check){
    	visited[current] = 1;
    	pathVisited[current] = 1;
    	check[current] = 0;

    	for(int neighbour: adj.get(current)){
    		if(visited[neighbour] == 0){
    			if(dfs(neighbour, adj, visited, pathVisited, check)){
    				return true;
    			}
    		}else if(pathVisited[neighbour] == 1){
    			return true;
    		}
    	}

    	pathVisited[current] = 0;
    	check[current] = 1;
    	return false;

    }
}