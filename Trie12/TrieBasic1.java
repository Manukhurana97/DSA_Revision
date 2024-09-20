import java.util.*;

public class TrieBasic1{

	public static TrieNode root = new TrieNode();

	public static TrieNode trieInsert(List<String> words){
		for(String word : words){
			var current = root;
			for(var ch: word.toCharArray()){
				if(!current.containKey(ch)) current.put(ch, new TrieNode());
				current = current.get(ch);
			}

			current.setEnd();
		}
		return root;
	}


	public static boolean search(String word){
		var current = root;
		for(var ch: word.toCharArray()){
			if(!current.containKey(ch)) return false;
			current = current.get(ch);
		}

		return current != null && current.isEnd();
	}

	public static boolean startWith(String prefix){
		var current = root;
		for(var ch: prefix.toCharArray()){
			if(!current.containKey(ch)) return false;
			current = current.get(ch);
		}

		return true;
	}

	public static void main(String[] args) {
		List<String> words = List.of("apple", "apps");
		trieInsert(words);
		System.out.println(search("app"));
		System.out.println(search("apple"));
		System.out.println(search("a"));
	}
	
}