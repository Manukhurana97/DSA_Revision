public class DetectCycleInUnDirectedGraph{
	// Time: O(n+2e), Space: O(1)
	public boolean isCycle(ArrayList<ArrayList<Integer>> adj){
		int n = adj.size();
		Set<Integer> visited = new HashSet<>();

		// since we can have multiple graphs
		for(int i=0;i<adj;i++){
			if(visited.contains(i) && bfs(adj, i, visited))
				return true;
		}

		return false;
	}

	// keep the track of 3 {parent, current, neighbour}
	private boolean bfs(ArrayList<ArrayList<Integer>> adj, int start, Set<Integer> visited){
		Queue<int[]> queue = new ArrayList<>();
		queue.add(new int[]{start, -1});
		visited(start);

		while(!queue.isEmpty){
			int[] node = queue.poll();
			int current = node[0];
			int parent = node[1];

			for(int neighbour: adj.get(current)){
				if(!visited.contains(neighbour)){
					queue.append(new int[]{neighbour, current});
					visited.add(neighbour);
				}else if(neighbour != parent){ // check if node is visited by same parent again or not if not then return true (because is already visited by somebody else)
					return false;	
				}
			}
		}

		return true;
	}


	// keep the track of 3 {parent, current, neighbour}
	private boolean dfs(ArrayList<ArrayList<Integer>> adj, int start, int parent, Set<Integer> visited){
		visited.add(start);

		for(var neighbour: adj.get(i)){
			if(!visited.contains(neighbour)){
				if(dfs(adj, neighbour, start, visited)){
					return true;
				}
			}else if(neighbour != parent){ // check if node is visited by same parent again or not, if not then return true
				return true;
			}
		}

		return false;
	}

}