// 
public class NumberOfProvinces{

	public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<isConnected.length;i++){
            adjList.add(new ArrayList());
        }

        // create n nodes for adjancy list [1: 2,3,4, 2: 4,5]
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j<isConnected[i].length;j++){
                if(i != j &&  isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }


        // perform dfs on all the nodes, it will mark visit to all the provience
        int provinces = 0;
        boolean[] visited = new boolean[isConnected.length];

        // since there can be multiple graph / disconnected graphs we use for loop on each node
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                provinces += 1;
                dfs(adjList, visited, i); // perform dfs to mark too the nodes in a provience
            }
        }

        return provinces;
    }

    public void dfs(List<List<Integer>> adjList, boolean[] visited, int index){
        visited[index] = true;

        for(var neighbour: adjList.get(index)){
            if(!visited[neighbour]){
                dfs(adjList, visited, neighbour);
            }
        }
    }
}