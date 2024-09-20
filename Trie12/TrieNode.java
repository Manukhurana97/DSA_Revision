public class TrieNode{

	TrieNode[] child; // max size  = 26
	boolean flag;

	TrieNode(){
		flag = false;
		child = new TrieNode[26];
	}


	public void put(char key, TrieNode trieNode){
		child[key - 'a'] = trieNode;
	}
	
	public TrieNode get(char key){
		return child[key - 'a'];
	}

	public boolean containKey(char key){
		return get(key) != null;
	}

	public void setEnd(){
		flag = true;
	}

	public boolean isEnd(){
		return flag;
	}

	public static void main(String[] args) {
		
	}
}