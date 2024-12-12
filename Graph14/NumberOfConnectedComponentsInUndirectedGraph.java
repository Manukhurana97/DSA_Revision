import java.util.*;

class DisjointSet{

	List<Integer> parent = new ArrayList();
	List<Integer> size = new ArrayList<>();

	DisjointSet(int n){
		for(int i=0; i<n; i++){
			parent.add(i);
			size.add(1);
		}
	}

	public int findParent(int i){
		if(i != parent.get(i)){
			parent.set(i, findParent(parent.get(i)));
		}

		return parent.get(i);
	}

	public void union(int u, int v){
		int uParent = findParent(u);
		int vParent = findParent(v);

		if(uParent == vParent) return;

		if(size.get(uParent) > size.get(vParent)){
			parent.set(vParent, uParent);
			size.set(uParent, size.get(uParent) + size.get(vParent));
		}else{
			parent.set(uParent, vParent);
			size.set(vParent, size.get(uParent) + size.get(vParent));
		}
	}
}


public class NumberOfConnectedComponentsInUndirectedGraph{
	// 2 ways to solve this 
	// 1. dfs

	public int countComponentsDFS(int n, int[][] edges){
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0; i< n; i++){
			adjList.add(new ArrayList<>());
		}

		for(int[] edge: edges){
			adjList.get(edge[0]).add(edge[1]);
		}


		int count = 0;
		int[] visited = new int[n];
		for(int i=0; i<n; i++){
			if(visited[i] == 0){
				count +=1;
				dfs(i, n, adjList, visited);
			}
		}

		return count;
	}

	private void dfs(int i, int n, List<List<Integer>> adjList,  int[] visited){
		visited[i] = 1;

		for(int neighbour: adjList.get(i)){
			if(visited[neighbour] == 0){
				dfs(neighbour, n, adjList, visited);
			}
		}
	}



// -------------------------------------------------------------------------------------------------------


	// 2. disjoint set
	public int countComponentsDS(int n, int[][] edges){

		DisjointSet dSet = new DisjointSet(n);

		for(int[] edge: edges){
			dSet.union(edge[0], edge[1]);
		}

		int count = 0;
		for(int i=0; i<n; i++){
			if(dSet.parent.get(i) == i){
				count += 1;
			}
		}

		return count;
	}

	public static void main(String[] args) {
        NumberOfConnectedComponentsInUndirectedGraph graph = new NumberOfConnectedComponentsInUndirectedGraph();
        int n = 5;
        int[][] edges = { {0, 1}, {1, 2}, {3, 4} };
        System.out.println("Number of Connected Components: " + graph.countComponentsDFS(n, edges)); // Output: 2
        System.out.println("Number of Connected Components: " + graph.countComponentsDS(n, edges)); // Output: 2
    }
}