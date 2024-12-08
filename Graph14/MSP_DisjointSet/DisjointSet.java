import java.util.*;

/*
	It tells the parent constant time O(4 alpha) where alpha ~ = 1
	It has 2 functionality: find parent, union .
	Union can be done by rank and size;

*/ 
public class DisjointSet{

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


	/*
     * find the ultimate parent of node and also do the compression of path.
    */
	public int findParents(int i){
		// int current = parent.get(i); // will return parent of current node
		// if(current == i){ // parent of current is current itself
		// 	return current; // return
		// }

		// parent.set(i, findParents(current)); // set parent of each node (path compression)
		// return parent.get(i);

		if(i != parent.get(i)){
			parent.set(i, findParents(parent.get(i)));
		}

		return parent.get(i);
	}


	/*
	 *	Union(u, v)
	 *	Find the untimate parent of u & v
	 *	Find the rank of parent of U and parent of V
	 *	Connect the smaller to greater to make the height min
	*/ 
	public void unionByRank(int u, int v){
		int parentU = findParents(u);
		int parentV = findParents(v);


		// if they belongs to same parent 
		if(parentU == parentV) return;

		// Attach smaller rank tree under the larger rank tree
		if(rank.get(parentU) > rank.get(parentV)){
			parent.set(parentV, parentU);
		}else if(rank.get(parentU) < rank.get(parentV)){
			parent.set(parentU, parentV);
		}else{
			parent.set(parentV, parentU);
			rank.set(parentU, rank.get(parentV) + 1); // Increment rank if both have the same rank
		}
	}

	/*
	 * Union(u, v)
	 * find the ultimate parent of u and v
	 * if the size of parentU is greater the parentV, them add v to u
	 * else add u to v
	*/ 
	public void unionBySize(int u, int v){
		int uParent = findParents(u);
		int vParent = findParents(v);

		if(size.get(uParent) > size.get(vParent)){
			parent.set(vParent, uParent);
			size.set(uParent, size.get(vParent));
		}else{
			parent.set(uParent, vParent);
			size.set(vParent, size.get(uParent));
		}
	}

	public static void main(String[] args) {
        DisjointSet set = new DisjointSet(8);
        set.unionBySize(1, 2);
        set.unionBySize(2, 3);
        set.unionBySize(4, 5);
        set.unionBySize(6, 7);
        set.unionBySize(5, 6);

        // find parent of 1 and 4
        System.out.println((set.findParents(1) == set.findParents(4)) ? "same" : "not same");
        set.unionBySize(3, 4);
        System.out.println((set.findParents(1) == set.findParents(4)) ? "same" : "not same");
    }

}