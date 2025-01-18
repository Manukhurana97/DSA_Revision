public class Course2{
	public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < numCourses; i++) adj.add(new ArrayList());

        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        List<Integer> result = new ArrayList<>();


        for(int i=0; i<numCourses; i++){
            if(!visited[i] && !dfs(i, adj, visited, pathVisited, result)){
                return new int[0];
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }


    private boolean dfs(int i, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited, List<Integer> result){
        visited[i] = true;
        pathVisited[i] = true;

        for(int neighbour: adj.get(i)){
            if(!visited[neighbour]){
                if(!dfs(neighbour, adj, visited, pathVisited, result)){
                    return false;
                }
            }else if(pathVisited[neighbour]){
                return false;
            }
        }

        pathVisited[i] = false;
        result.add(i);

        return true;
    }
}