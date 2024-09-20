import java.util.*;

class TrieNode{
	TrieNode[] child;
	boolean flag;

	TrieNode(){
		child = new TrieNode[26];
		flag = false;
	}

	void put(char ch, TrieNode node){
		child[ch - 'a'] = node;
	}

	TrieNode get(char ch){
		return child[ch-'a'];
	}

	boolean containsKey(char ch){
		return get(ch) != null;
	}

	void setEnd(){
		flag = true;
	}

	boolean isEnd(){
		return flag;
	}


}

public class Trie3{

	static TrieNode root = new TrieNode();

	private static void insert(List<String> words){
		for(var word : words){
			var current = root;
			for(var ch: word.toCharArray()){
				if(!current.containsKey(ch)) current.put(ch, new TrieNode());
				current = current.get(ch);
			}
			current.setEnd();
		}
	}

	public static String getMaxCompleteString(List<String> words){

		insert(words);

		String maxCompleteString = "";

		for(var word : words){
			var current = root;
			boolean isValid = true;

			for(var ch: word.toCharArray()){
				if (!current.containsKey(ch) || !current.get(ch).isEnd()){ // if prefix is not a word
					isValid = false;
					break;
				}	
				current = current.get(ch);
			}

			if (isValid && word.length() > maxCompleteString.length()){
				maxCompleteString = word;
			}
		}

		return maxCompleteString;

	}

	public static void main(String[] args) {
		List<String> input = List.of("a", "apple", "ap", "app", "appl", "appse");
		System.out.println("max Complete String : "+ getMaxCompleteString(input));
	}
}