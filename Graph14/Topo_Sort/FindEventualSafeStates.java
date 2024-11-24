public class FindEventualSafeStates{

	public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        int[] check = new int[n];

        /* Create Array List*/ 
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                adjList.get(i).add(neighbor);
            }
        }

        // perform dfs omn each nodes
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                dfs(i, adjList, visited, pathVisited, check);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(check[i] == 1){
                result.add(i);
            }
        } 

        return result;
    }

    public boolean dfs(int current, List<List<Integer>> adjList, int[] visited, int[] pathVisited, int[] check){
        visited[current] = 1;
        pathVisited[current] = 1;

        for(var neighbour: adjList.get(current)){
            if(visited[neighbour] == 0){
                if(dfs(neighbour, adjList, visited, pathVisited, check)){
                    return true;
                }
            }else if(pathVisited[neighbour] == 1){
                return true;
            }
        }


        pathVisited[current] = 0;
        check[current] = 1;
        return false;
    }




    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] inOrder = new int[n];
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                adjList.get(neighbor).add(i);
                inOrder[i] += 1;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inOrder[i] == 0){
                queue.add(i);
            }
        }


        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);

            for(int neighbour: adjList.get(current)){
                inOrder[neighbour] -= 1;

                if(inOrder[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}