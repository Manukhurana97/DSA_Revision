import java.util.*;

// Maximum XOR of Two Numbers in an Array
class TrieNode{
	TrieNode[] child;

	TrieNode(){
		child = new TrieNode[2];
	}

	void put(int bit, TrieNode node){
		child[bit] = node;
	}

	TrieNode get(int bit){
		return child[bit];
	}

	boolean containsKey(int bit){
		return get(bit) != null;
	}
}



public class MaximumXor{

	TrieNode root = new TrieNode();

	public void insert(int num){
		var current = root;

		for(int i=31; i>=0; i--){
			int bit = (num >> i) & 1; // Extract the i-th bit of the number
			if(!current.containsKey(bit))
				current.put(bit, new TrieNode());
			current = current.get(bit);
		}
	}

	public int maxXor(int num){
		var current = root;

		int maxXor = 0;

		for(int i=31; i>=0; i--){
			int bit = (num >> i) & 1;
			// because of xor property, if the bit is differnt then the value will increase 
			// thats why we took opps every time 
			// 1 * 0 : 1
			// 0 * 1 : 1
			// 0 * 0 : 0
			// 1 * 0 : 0
			if(current.containsKey(1-bit)){
				maxXor |= 1<<i;
				current = current.get(1-bit);
			}else current = current.get(bit);
		}
		return 	maxXor;
	}

	public int getMaxXOR(List<Integer> nums){
		for(var num: nums) insert(num);		

		int maxXor = 0;
		for(var num: nums) maxXor = Math.max(maxXor, maxXor(num));
		

		return maxXor;
	}


	public static void main(String[] args) {
		MaximumXor obj = new MaximumXor();
		List<Integer> input = List.of(3, 10, 5, 25, 2);

		System.out.print(obj.getMaxXOR(input));
	}
}