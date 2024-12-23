public class CheapestFlightsWithKStops{

	// used modified version of dijkstra algo
	public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        
        // createing adjency list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] detail: flights) adj.get(detail[0]).add(new int[]{detail[1], detail[2]});

        
        // init distances
        int[] distance = new int[n];
        for(int i=0;i<n;i++) distance[i] = Integer.MAX_VALUE;
        distance[src] = 0;
        
        int result = Integer.MAX_VALUE;
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0, 0});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cSrc = current[0];
            int cCost = current[1];
            int cStop = current[2];
            
            if(cSrc == dst) result = Math.min(result, cCost);
            
            if(cStop > k) continue;
            
            for(int[] neighbour: adj.get(cSrc)){
                int nSrc = neighbour[0];
                int nCost = neighbour[1];
                
                if(distance[nSrc] > cCost + nCost){
                    distance[nSrc] = cCost + nCost;
                    queue.add(new int[]{nSrc, cCost + nCost, cStop+1});
                }
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // using bellman fort algo 

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for(int i=0; i<=k; i++){
            int[] temp = distance.clone();
            for(int[] flight: flights){
                int u = flight[0];
                int v = flight[1];
                int wt = flight[2];

                if(distance[u] != Integer.MAX_VALUE){
                    temp[v] = Math.min(temp[v],  wt + distance[u]);
                }
            }
            distance = temp;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }   
}