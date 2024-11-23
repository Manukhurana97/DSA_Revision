public class DetectCycleInDirectedGraph{
	public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[n];
        int[] pathVisited = new int[n];

        for(int i = 0; i < n; i++){
        	if (visited[i] == 0 && dfs(i, adj, visited, pathVisited)) {
        		return true;
        	}
        }

        return false;
    }

    public boolean dfs(int current, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited){
    	visited[current] = 1;
    	pathVisited[current] = 1;
    	

    	for(var neighbour: adj.get(current)){
    		if(visited[neighbour] == 0)   { 		
    			if(dfs(neighbour, adj, visited, pathVisited)) {
    				return true;
    			}
    		}
    		else if(pathVisited[neighbour] == 1){
    			return true;
    		}
    	}
    	
    	pathVisited[current] = 0;

    	return false;
    }
}