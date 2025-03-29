// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

public class ReorderRoutesToMakeAllPathLeadsToTheCityZero{
	lic int minReorder(int n, int[][] connections) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        // create a 2 way connection
        for(int[] connection: connections){
            adjList.get(connection[0]).add(new int[]{connection[1], 1}); // 1 indicates road points away from city 0
            adjList.get(connection[1]).add(new int[]{connection[0], 0});  // 0 indicates road points towards city 0
        }
        // if there is node from (eg 0 -> 1) ,this mean is away from 0, we will take 1 
        // if there is node from (eg 1 -> 0) ,this mean is going twoards 0, but since 0 is initiali it will be alreeady visited we will not count this  

        int[] visited = new int[n];
        return dfs(0, adjList, visited);

    }


    private int dfs(int current, List<List<int[]>> adj, boolean[] visited){
        visited[current] = true;
        int count = 0;

        for(int[] neighbours: adj.get(current)){
            if(!visited[neighbours[0]]){
                count += neighbours[1] + dfs(neighbours[0], adj, visited);
            }
        }

        return count;
    }
}