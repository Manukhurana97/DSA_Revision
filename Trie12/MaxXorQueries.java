import java.util.*;

class TrieNode{

	TrieNode[] child;

	TrieNode(){
		child = new TrieNode[2];
	}

	void put(int i, TrieNode node){
		child[i] = node;
	}

	TrieNode get(int i){
		return child[i];
	}

	boolean containsKey(int i){
		return get(i) != null;
	}
}


public class MaxXorQueries{

	TrieNode root = new TrieNode();

	public void insert(int num){
		var current = root;

		for(int i=31;i>=0;i--){
			int bit = (num >> i) & 1;
			if(!current.containsKey(bit)) 
				current.put(bit, new TrieNode());
			current = current.get(bit);
		}
	}

	public int searchMaxXor(int num){
		int xor = 0;
		TrieNode current = root;

		for(int i = 31;i >= 0; i--){
			int bit = (num >> i) & 1;
			
			if(current.containsKey(1-bit)){
				xor |= (1 << i);
				current = current.get(1 - bit);
			} else current = current.get(bit);
		}
		return xor;
	}


	// insert into no less the queries[1] and multiply with queries[0]
	public int[] maxXorQueries(List<Integer> arr, int[][] queries){

		List<Integer> mutableArr = new ArrayList<>(arr);

		Collections.sort(mutableArr);

		int i=0;
		List<List<Integer>> data = new ArrayList<>();
		
		for(var query: queries) {
			data.add(List.of(i, query[1], query[0])); // [index, limit, number]
			i += 1;
		}

		Collections.sort(data, (list1, list2) -> Integer.compare(list1.get(1), list2.get(1)));

		int arrIndex = 0;
		int[] result = new int[queries.length]; 
		
		for(var query: data) {
			
			while(arrIndex < mutableArr.size() && mutableArr.get(arrIndex) <= query.get(1)){
				insert(mutableArr.get(arrIndex));
				arrIndex++;
			}

			// If no elements in Trie, return -1
			if(arrIndex == 0){
				result[query.get(0)] = -1;
			}else{
				result[query.get(0)] = searchMaxXor(query.get(2));
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		MaxXorQueries obj = new MaxXorQueries();
		List<Integer> arr = List.of(3, 10, 5, 25, 2, 8);
        int[][] queries = {{1, 2}, {3, 1}, {5, 3}, {25, 10}};
		
		var result = obj.maxXorQueries(arr, queries);
		for(var val: result) System.out.println(val);
	}
}