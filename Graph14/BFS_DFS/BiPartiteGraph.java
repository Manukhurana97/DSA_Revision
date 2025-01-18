// https://leetcode.com/problems/is-graph-bipartite/

public class BiPartiteGraph{
	/* 
 * a graph is said to be a bipartite graph if parent and child dont have same color 
 *  1 -> (2,3) -> 4 : its a bipartite 
 *  1 -> (2, 3) ->  (2, 3->4 ) -> (2, 4) -> 5 : its not a bipartite because value of 2,4 is different from 5  
 *  Linear graph with no cycle is always a bipartite graph 
 *  Any graph with even cycle length is bipartite    
*/


	public boolean isBipartite(int[][] graph) {
        
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i=0; i<graph.length; i++)
            if(color[i] ==-1){
                color[i] = 0;
                if(!bfs(i, color, graph))
                    return false;
            }
        return true;
    }

    private boolean dfs(int current, int[] color, int[][] adjList){
        
        for(int neighbour: adjList[current]){
            if(color[neighbour] == -1){
                color[neighbour] = 1 - color[current];
                if(!dfs(neighbour, color, adjList)){
                    return false;
                }
            }else if(color[neighbour] == color[current]){
                    return false;
                }
        }

        return true;
    }


    private boolean bfs(int current, int[] color, int[][] adjList){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(current);

        while(!queue.isEmpty()){
            current = queue.poll();
            for(int neighbour: adjList[current]){
                if(color[neighbour] == -1){
                    color[neighbour] = 1 - color[current];
                    queue.add(neighbour);
                }else if(color[neighbour] == color[current]){
                    return false;
                }
            }
        }

        return true;
    }
}