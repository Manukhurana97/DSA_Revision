/*
	it overcome the problems of Dijkstra, which dijkstra fails for -ve weights/distance,
	it only works with directed graph, inorder to work with undirected graph we need to convert graph to directed graph
	it help to detect neg cycle.

	we do, Relexation of all edges N-1 times sequentially
	Relexation: if(dist[u] + wt < dist[v]) dist[v] = dist[u] + wt;
*/ 
public class BellmanFordAlgorithm{
	static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] distance = new int[V];
        
        for(int i=0;i<V;i++) distance[i] = (int)1e8;
        distance[src] = 0;
        
        // Relax all edges V-1 times
        for(int i = 0; i<V-1; i++){
            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(distance[u] != (int)1e8 && distance[v] > w +  distance[u]){
                    distance[v] = w + distance[u];
                }
            }
        }
        
        for(int[] edge: edges){
            int u = edge[0];
                int v = edge[1];
                int w = edge[2];
            if(distance[u] != (int)1e8 && distance[v] > w +  distance[u]){
                return new int[]{-1}; // Negative cycle detected
            }
        }
        
        return distance;
    }
}