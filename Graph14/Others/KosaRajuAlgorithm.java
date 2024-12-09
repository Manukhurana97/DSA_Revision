
/* 
 * strongest connectected component
 * 1. Sort all the edges according to finishing time.
 * 2  Reverse the graph
 * 3. Do a DFS
 */

public class KosaRajuAlgorithm{
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, int[] visited){
        visited[i] = 1;
        for(int neighbour: adj.get(i)){
            if(visited[neighbour] == 0){
                dfs(neighbour, adj, stack, visited);
            }
        }
        
        stack.push(i);
    }
    
    public void dfs2(int i, ArrayList<ArrayList<Integer>> adj, int[] visited){
        visited[i] = 1;
        for(int neighbour: adj.get(i)){
            if(visited[neighbour] == 0){
                dfs2(neighbour, adj, visited);
            }
        }
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        /*
            Sort all the nodes according to finish time (dfs)
        */ 
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];
        
        for(int i=0; i<V; i++){
            if(visited[i] == 0){
                dfs(i, adj, stack, visited);
            }
        }
        
        /*
            Transpose/reverse the graph
        */ 
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<V; i++){
            adjT.add(new ArrayList<>());
        }
        
        for(int i=0;i<V; i++){
            for(Integer j: adj.get(i)){
                adjT.get(j).add(i);
            }
        }
        
        /*
            perfrom dfs on orderof finishing time
        */ 
        int count = 0;
        visited = new int[V]; // Reset visited array
        
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited[node] == 0){
                count += 1;
                dfs2(node, adjT, visited);
            }
        }
        
        return count;
    }
}
