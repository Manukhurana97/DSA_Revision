import java.util.*;

class TrieNode{

	TrieNode[] child;
	int endWith;
	int countPair;

	TrieNode(){
		child = new TrieNode[26];
		endWith = 0;
		countPair = 0;
	}

	void put(char ch, TrieNode node){
		child[ch - 'a'] = node;
	}

	TrieNode get(char ch){
		return child[ch - 'a'];
	}

	boolean containsKey(char ch){
		return get(ch) != null;
	}

	public void reducePrefix(ch){
		var node = get(ch);
		if(node != null){
			node.endWith -=1;
		}
	}
}

public class Trie2{

	static TrieNode root = new TrieNode();

	public static void insert(String word){
		var current = root;

		for(var ch: word.toCharArray()){
			if(!current.containsKey(ch)) 
				current.put(ch, new TrieNode());
			current = current.get(ch);
			current.countPair += 1;
		}
		current.endWith += 1;
	}

	public static int countWordEndingWith(String word){
		var current = root;
		for(char ch: word.toCharArray()){
			if(!current.containsKey(ch)) return 0;
			current = current.get(ch);
		}

		if(current == null) return 0;
		return current.endWith;
	}

	public static int countWordStartWith(String word){
		var current = root;
		for(char ch: word.toCharArray()){
			if(!current.containsKey(ch)) return 0;
			current = current.get(ch);
		}

		if(current == null) return 0;
		return current.countPair;
	}


	public static void erase(String word){
		var current = root;
		for(char ch: word.toCharArray()){
			if(!current.containsKey(ch)) return;
			current = current.get(ch);
			current.countPair-=1;
		}
		if (current.endWith > 0) current.reducePrefix();
		
	}

	public static void main(String[] args) {
		insert("apple");
		insert("apps");
		System.out.println(countWordEndingWith("apps"));
		insert("apps");
		System.out.println(countWordEndingWith("apps"));
		erase("apps");
		System.out.println(countWordEndingWith("apps"));
	}
}