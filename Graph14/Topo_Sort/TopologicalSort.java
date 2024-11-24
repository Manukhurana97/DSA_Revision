
// it can be applied on dag : dircted acyclic graph  
// if there is node from u->v, u will always be ahead of v
// 1. perform the dfs on all the element, and keep the visited pointer
// 2. get all the neighbour of current element and mark the as visited and perform the dfs
// 3. once the dfs is completed perform add the (last elemnt to result)
public class TopologicalSort{
	private static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[adj.size()];
        
        for(int i = 0; i<adj.size(); i++){
            if(visited[i] == 0){
                dfs(i, adj, stack, visited);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        
        return result;
    }
    
    private static void dfs(int current, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, int[] visited){
        visited[current] = 1;
        
        // Explore all neighbors
        for(var neighbour: adj.get(current)){
            if(visited[neighbour] == 0){
                dfs(neighbour, adj, stack, visited);
            }
        }
        
        // Add the current node to the stack after processing all neighbors
        stack.add(current);
    }
}
}