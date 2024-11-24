import java.util.*;


/*for linear ordering of vertices, such that if there is an edge b/w u&v, u appears before v in the ordering extension of a topo sort (BFS)

	1. get the indegree (no of incoming nodes) of all the nodes
	2. get all the element with indegree 0 (there will be my initial nodes, and put them in queue)
	3. get all the initial element from queue (add it in result) and reduce the outdegree (remove connection)
	4. if the neighbours element is 0, add it in a queue 
*/ 

public class KahnsAlgorithm{
	private static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
		int n = adj.size();

		/* get the indegree of all the elemenmts */
		int[] indegree = new int[n];
		
		for(ArrayList<Integer> nodes: adj){
			for(Integer node: nodes){
				indegree[node]++;
			}
		}

		/*
			collect the intial nodes with indegree 0
			Since its a undirected graph there will be atleast one node with indegree 0
		*/ 
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < n; i++){
			if(indegree[i] == 0){
				queue.add(i);
			}
		}

		/* reduce all the outgoing connections */
		ArrayList<Integer> result = new ArrayList<>();
		while(!queue.isEmpty()){
			var current = queue.poll();
			result.add(current);
			
			for(int neighbour: adj.get(current)){
				indegree[neighbour] -= 1;

				// reduce indegree
				if(indegree[neighbour] == 0){
					queue.add(neighbour);
				}
			}
		}

		return result;
	}
}