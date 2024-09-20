import java.util.*;

// class TrieNode{
// 	TrieNode[] child;

// 	TrieNode(){
// 		child = new TrieNode[26];
// 	}	

// 	void put(char ch, TrieNode node){
// 		child[ch - 'a'] = node;
// 	}

// 	TrieNode get(char ch){
// 		return child[ch - 'a'];
// 	}

// 	boolean containsKey(char ch){
// 		return get(ch) != null;
// 	}
// }


class TrieNode{
	Map<Character, TrieNode> child = new HashMap<>();

	void put(char ch, TrieNode node){
		child.put(ch, node);
	}

	TrieNode get(char ch){
		return child.get(ch);
	}

	boolean containsKey(char ch){
		return get(ch) != null;
	}
}

public class Trie4{

	static TrieNode root = new TrieNode();

	public static int countDistinctSubstrings(String s) { 

		int count = 0; 

		for(int i = 0; i<s.length(); i++){
			var current = root;
			
			for(int j=i; j<s.length(); j++){
				var ch = s.charAt(j);
				
				if(!current.containsKey(ch)){
					current.put(ch, new TrieNode());
					count += 1;
				}
				current = current.get(ch);
			}
		}

		return count + 1; // +1 for blank string
	}


	public static void main(String[] args) {
		String word = "abab";
		System.out.println(countDistinctSubstrings(word));
	}
}