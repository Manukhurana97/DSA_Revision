class TrieNode{
    Map<Character, TrieNode> node;
    boolean isEnd;

    TrieNode(){
        this.node = new HashMap<>();
        this.isEnd = false;    
    }

    public void put(char key, TrieNode newNode){
        node.put(key, newNode);
    }

    public TrieNode get(char key){
        return node.get(key);
    }

    public boolean containsKey(char key){
        return this.get(key) != null;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public void setEnd(){
        isEnd = true;
    }
}

public class DesignAddAndSearchWordsDataStructure {

    TrieNode head;

    public WordDictionary() {
        head = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = head;
        for(char ch: word.toCharArray()){
            if(!current.containsKey(ch)) current.put(ch, new TrieNode());
            current = current.get(ch);
        }
        current.setEnd();
    }
    
    public boolean search(String word) {
        return dfs(0, word, head);
    }

    public boolean dfs(int index, String word, TrieNode root){
        TrieNode current = root;

        for (int ind = index; ind < word.length(); ind++) {
            char ch = word.charAt(ind);
            
            if(ch =='.'){
                for(TrieNode child: current.node.values()){
                    if(child != null && dfs(ind + 1, word, child)){
                        return true;
                    }
                }
                return false;
            }
            else {
                if(!current.containsKey(ch)) {
                    return false;
                }
                current = current.get(ch);
            }
        }

        return current.isEnd();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */