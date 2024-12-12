
public class MinCostToConnectAllPoints{
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>( (a, b) -> a[0] - b[0]);
        queue.add(new int[]{0, 0});

        boolean[] visited = new boolean[n];
        int count = 0;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cost = current[0];
            int point = current[1];

            if(visited[point]) continue;
            visited[point] = true;
            count += cost;

            for(int i=0; i<n; i++){
                if(!visited[i]){
                    int dist = Math.abs(points[point][0] - points[i][0]) + Math.abs(points[point][1] - points[i][1]);
                    queue.add(new int[]{dist, i});
                }
            }
        }

        return count;
    }
}