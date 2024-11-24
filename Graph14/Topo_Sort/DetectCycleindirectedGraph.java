public class DetectCycleindirectedGraph{

	// using kahns algo, TopoSort BFS
	public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
		int n = adj.size();

		// calculate the indegree of all the nodes
		int[] indegree = new int[n];

		for(ArrayList<Integer> nodes: adj){
			for(int node: nodes){
				indegree[node]++;
			}
		}

		/*
			get all the initial nodes who has indegree 0, 
			if there is a loop, there are chances there will be no nodes with indegree 0
		*/
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < n; i++){
			if(indegree[i] == 0){
				queue.add(i);
			}
		}


		// remove all the connection with adjacent nodes
		int count = 0;
		while(!queue.isEmpty()){
			int current = queue.poll();
			count += 1;

			for(int neighbour: adj.get(current)){
				indegree[neighbour] -= 1;

				if(indegree[neighbour] == 0){
					queue.add(neighbour);
				}
			}
		}

		return count != n;
	}
}