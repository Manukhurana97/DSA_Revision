class DisjointSet{

	List<Integer> rank = new ArrayList<>();
	List<Integer> size = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();

	DisjointSet(int n){
		// make all the rank as 0 
        // mark parent of all nodes to itself
		for(int i = 0; i < n; i++){
			parent.add(i);
			rank.add(0);
			size.add(1);
		}
	}


	public int findParents(int i){
		if(i != parent.get(i)){
			parent.set(i, findParents(parent.get(i)));
		}

		return parent.get(i);
	}


	public void unionBySize(int u, int v){
		int uParent = findParents(u);
		int vParent = findParents(v);

		if(size.get(uParent) > size.get(vParent)){
			parent.set(vParent, uParent);
			size.set(uParent, size.get(vParent) + size.get(uParent));
		}else{
			parent.set(uParent, vParent);
			size.set(vParent, size.get(vParent) + size.get(uParent));
		}
	}

}


/* sort the graph by weight and take the smallest one first
 * check if parent of u and v are not same,
 * the just sum the weight and make the union of u and v 
*/
public class KrusKalAlgorithm{
	public record Node(int u, int v, int wt){}

	public static int spanningTree(int V, List<List<List<Integer>>> adj) {
		PriorityQueue<Node> queue = new PriorityQueue<>((a, b)-> a.wt - b.wt);
		for(List<Integer> lst: adj){
			int u = lst.get(0);
			int v = lst.get(1);
			int wt = lst.get(2);

			queue.add(new Node(u, v, wt));
		}

		int sum = 0;
		while(!queue.isEmpty()){
			Node node = queue.poll();

			DisjointSet set = new DisjointSet();
			
			if(set.findParents(node.u) != set.findParents(node.v)){ 
				sum += node.wt;
				set.unionBySize(node.u, node.v);
			}

		}

		retur sum;
	}
}