
// Map Based : Time : O(Length of word), Space: O(26*n)
// public class TrieNode{

// 	TrieNode[] child; // max size  = 26
// 	boolean flag;

// 	TrieNode(){
// 		flag = false;
// 		child = new TrieNode[26];
// 	}


// 	public void put(char key, TrieNode trieNode){
// 		child[key - 'a'] = trieNode;
// 	}
	
// 	public TrieNode get(char key){
// 		return child[key - 'a'];
// 	}

// 	public boolean containKey(char key){
// 		return get(key) != null;
// 	}

// 	public void setEnd(){
// 		flag = true;
// 	}

// 	public boolean isEnd(){
// 		return flag;
// 	}

// 	public static void main(String[] args) {
		
// 	}
// }


// Map Based : Time : O(Length of word), Space: O(n)

public class TrieNode{

    Map<Character, TrieNode> child;
    boolean isEnd;

    TrieNode(){
        this.child = new HashMap<>();
        this.isEnd = false;
    }

    public void insert(char key, TrieNode node){
        this.child.put(key, node);
    }

    public TrieNode get(char key){
        return this.child.get(key);
    }

    public boolean contains(char key){
        return get(key) != null;
    }

    public void setEnd(){
        this.isEnd = true;
    }

    public boolean isEnd(){
        return this.isEnd;
    }

}
