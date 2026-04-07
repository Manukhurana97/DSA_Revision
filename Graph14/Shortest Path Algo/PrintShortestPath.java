
import java.util.*;

public class PrintShortestPath{
	public static List<Integer> shortestPath(int n, int m, int edges[][]) {

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
            return List.of(-1);
        }
        
        // O(n)
         int currentNode = n;
        while (currentNode != 1) {
            result.add(currentNode);
            currentNode = parent[currentNode];
        }
        result.add(1);
        // result.add(distance[n]);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,2}, {1,4,5}, {2,3,4}, {2,5,5}, {3,4,3}, {3,5,1}};
        System.out.println(shortestPath(5,6,matrix));
    }
}