public class BiPartiteGraph{
	/* 
 * a graph is said to be a bipartite graph if parent and child dont have same color 
 *  1 -> (2,3) -> 4 : its a bipartite 
 *  1 -> (2, 3) ->  (2, 3->4 ) -> (2, 4) -> 5 : its not a bipartite because value of 2,4 is different from 5  
 *  Linear graph with no cycle is always a bipartite graph 
 *  Any graph with even cycle length is bipartite    
*/


	public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[adj.size()];
       
        for(int i=0;i<adj.size();i++) color[i] = -1;
        
        for(int i=0;i<adj.size();i++){
        	// if (!BFS(i, adj, color)) return false;

        	if (!DFS(i, adj, color)) return false;
        }
       

        return true;
    }

    public boolean BFS(int i, ArrayList<ArrayList<Integer>> adj, int[] color){
    	Queue<Integer> queue = new LinkedList<>();
        queue.add(i); 

        while(!queue.isEmpty()){
        	int current = queue.poll();

        	for(int neighbour: adj.get(current)){
        		if(color[neighbour] == -1){
        			color[neighbour] = 1 - color[current];
        		}else if(color[neighbour] == color[current]){
        			return false;
        		}
        	}
        }

        return true;
    }

    public boolean DFS(int current, ArrayList<ArrayList<Integer>> adj, int[] color){
    	for(int neighbour: adj.get(current)){
    		if(color[neighbour] == -1){
    			color[neighbour] = 1 - color[current];
    			if(!DFS(neighbour, adj, color)) return false;
    		}else if(color[neighbour] == color[current]){
    			return false;
    		}
    	}

    	return true;
    }
}