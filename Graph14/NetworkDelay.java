public class NetworkDelay{
	public int networkDelayTime(int[][] times, int n, int k) {

        // adjancy list
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] time: times){ 
            adjList.get(time[0] - 1).add(new int[]{time[1] - 1, time[2]});
        }

        // priority queue / min heap
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{k - 1, 0});

        // distance
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k - 1] = 0;

        int maxTime = 0;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int currentTime = current[1];
            
            for(int[] neighbour: adjList.get(node)){
                int neighbourNode = neighbour[0];
                int time = currentTime + neighbour[1];

                if(distance[neighbourNode] > time){
                    distance[neighbourNode] = time;
                    queue.add(new int[]{neighbourNode, time});
                }
            }
            
        }

        // validate if any node left
        for(int i: distance){
            if(i == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, i);
        }
        return maxTime;

    }
}