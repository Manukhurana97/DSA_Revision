// https://leetcode.com/problems/min-cost-to-connect-all-points/description/

public class MinCostToConnectAllRopes {
	public int minCostConnectPoints(int[][] points) {
       int result = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{0, 0});
        
        Set<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int point = current[0];
            int cost = current[1];
            

            if(visited.contains(point)) continue;
            visited.add(point);
            result += cost;

            for(int i=0; i<points.length; i++){
                if(!visited.contains(i)){
                    queue.add(new int[]{i , Math.abs(points[point][0] - points[i][0]) + Math.abs(points[point][1] - points[i][1])});
                }
            }

        }

       return result;
    }
}