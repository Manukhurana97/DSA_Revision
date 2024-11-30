public class PrintShortestPath{
	public List<Integer> shortestPath(int n, int m, int edges[][]) {

        // creating adjacy list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <=n  ; i++) adj.add(new ArrayList<>());
        
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        queue.add(new int[]{1, 0});

        int[] distance =  new int[n+1];
        int[] parent =  new int[n+1];
        
        for(int i=0;i<=n;i++){
            distance[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        distance[1] = 0;
        
        while(!queue.isEmpty()){
            int[] currentNode = queue.poll();
            
            for(var neighbours: adj.get(currentNode[0])){
                if(distance[neighbours[0]] > currentNode[1] + neighbours[1]){
                    distance[neighbours[0]] = currentNode[1] + neighbours[1];
                    parent[neighbours[0]] = currentNode[0];
                    queue.add(new int[]{neighbours[0], distance[neighbours[0]]});
                }
            }
        }
        

        List<Integer> result = new ArrayList<>();
        if(distance[n] == Integer.MAX_VALUE){
            result.add(-1);
            return result;
        }
        
        // O(n)
         int currentNode = n;
        while (currentNode != 1) {
            result.add(currentNode);
            currentNode = parent[currentNode];
        }
        result.add(1);
        Collections.reverse(result);
        result.add(0, distance[n]);
        return result;
    }
}