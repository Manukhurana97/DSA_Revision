public class Course{

	// detecting cycle
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int[] edge: prerequisites){
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i] && !dfs(i, visited, pathVisited, adj)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj){
        visited[i] = true;
        pathVisited[i] = true;

        for(int neighbour: adj.get(i)){
            if(!visited[neighbour]){
                if(!dfs(neighbour, visited, pathVisited, adj)){
                    return false;
                }
            }else if(pathVisited[neighbour]){
                return false;
            }
        }

        pathVisited[i] = false;
        return true;
    }
}
}