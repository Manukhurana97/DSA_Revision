// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

public class NumberOfWaysToArriveAtDestination{
	static int countPaths(int n, List<List<Integer>> roads) {
        final int MOD = 1_000_000_007;

        
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (var road : roads) {
            adj.get(road.get(0)).add(new int[]{road.get(1), road.get(2)});
            adj.get(road.get(1)).add(new int[]{road.get(0), road.get(2)});
        }
        
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] ways = new int[n];
        
        // Min-heap priority queue (node, distance)
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{0, 0});
        distance[0] = 0;
        ways[0] = 1;
        
        while(!queue.isEmpty()){
          int[] current = queue.poll();
          int currentNode = current[0];
          int currentDist = current[1];
          
          if (currentDist > distance[currentNode]) continue;
          
            for (var neighbor : adj.get(currentNode)) {
                int neighborNode = neighbor[0];
                int edgeWeight = neighbor[1];
    
                int newDist = currentDist + edgeWeight;
                if (newDist < distance[neighborNode]) {
                    distance[neighborNode] = newDist;
                    ways[neighborNode] = ways[currentNode];
                    queue.add(new int[]{neighborNode, newDist});
                } else if (newDist == distance[neighborNode]) {
                    ways[neighborNode] = (ways[neighborNode] + ways[currentNode]) % MOD;
                }
            }
        }
        
        return ways[n-1] % MOD;
       
    }
}