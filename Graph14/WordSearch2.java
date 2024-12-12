public class WordSearch2{

	public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<>();
        for(String word: words){
            if(searchWord(word, board)){
                result.add(word);
            }
        }

        return result;
    }

    public boolean searchWord(String word, char[][] board){
        char[] charArr = word.toCharArray();
        int[][] visited = new int[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == charArr[0]){
                    if(dfs(0, i, j, board,charArr, visited)){
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public boolean dfs(int i, int r, int c, char[][] board,char[] charArr, int[][] visited){
        if(i>=charArr.length) return true;
        if(r < 0 || c < 0 || r>=board.length || c>=board[0].length || visited[r][c] == 1 || board[r][c] != charArr[i]) return false;

        visited[r][c] = 1;

        if(dfs(i+1, r+1, c, board, charArr, visited)) return true;
        if(dfs(i+1, r-1, c, board, charArr, visited)) return true;
        if(dfs(i+1, r, c+1, board, charArr, visited)) return true;
        if(dfs(i+1, r, c-1, board, charArr, visited)) return true;

        visited[r][c] = 0;

        return false;
    }
}


    // -------------------------------------------------------- Trie ----------------------------------------------------------------

class Trie{
    Trie[] child;
    boolean isEnd;

    Trie(){
        child = new Trie[26];
        isEnd = false;
    }

    public void insertWord(String word){
        Trie node = this;
        for(char ch: word.toCharArray()){
            if(node.child[ch - 'a'] == null){
                node.child[ch - 'a'] = new Trie();
            }
            node = node.child[ch - 'a'];
        }
        node.isEnd = true;
    }

    public Trie get(char ch){
        return child[ch-'a'];
    }
}


public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();

        for(String word: words) {
            trie.insertWord(word);
        }

        int[][] visited = new int[board.length][board[0].length];

        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[r].length; c++){
                dfs(r, c, board, visited, "", trie, result);
            }
        }

        return result;
    }

    public void dfs(int r, int c, char[][] board, int[][] visited, String word, Trie trie, List<String> result){
        if(r<0 || c<0 || r>= board.length || c>= board[0].length || visited[r][c] == 1 || trie.get(board[r][c]) == null) return;

        visited[r][c] = 1;
        trie = trie.get(board[r][c]);
        word+=board[r][c];
        
        if(trie.isEnd){
            result.add(word);
            trie.isEnd = false;
        }

        dfs(r+1, c, board, visited, word, trie, result);
        dfs(r-1, c, board, visited, word, trie, result);
        dfs(r, c+1, board, visited, word, trie, result);
        dfs(r, c-1, board, visited, word, trie, result);

        visited[r][c] = 0;
    }
}