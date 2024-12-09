// https://leetcode.com/problems/critical-connections-in-a-network/

public class CriticalConnectionsInANetwork {
    public int timer = 1;
    private void dfs(int node, int parent,  List<List<Integer>> adj, int[] visited, int[] tin, int[] low, List<List<Integer>> result ){
        visited[node] = 1;
        tin[node] = low[node]  = timer;
        timer++;

        for(var neighbour: adj.get(node)){
            if(neighbour == parent) continue;

            if(visited[neighbour] == 0){
                dfs(neighbour, node, adj, visited, tin, low, result);
                low[node] = Math.min(low[node], low[neighbour]);


                if(low[neighbour] > tin[node]) {
                    // its a bridge
                    result.add(Arrays.asList(node, neighbour));
                }
            }else{
                low[node] = Math.min(low[node], tin[neighbour]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        // create adjancy list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (var connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // crete visited, tin, low input
        int[] visited = new int[n];
        int[] tin = new int[n]; // time of insertion of node
        int[] low = new int[n];
        List<List<Integer>> result = new ArrayList<>();

        // perform dfs
        dfs(0, -1, adjList, visited, tin, low, result);
        return result;
    }
}