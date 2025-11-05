// https://leetcode.com/problems/word-search-ii/

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie current = new Trie();
        insertWords(words, current);

        int row = board.length, col = board[0].length;
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[row][col];

        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                dfs(r, c,  new StringBuilder(), visited, result, current, board);
            }
        }
        return result;
    }

    public void insertWords(String[] words, Trie trie) {
        for(String word: words) {
            Trie current = trie;
            for(char ch: word.toCharArray()) {
                if(!current.contains(ch)) 
                    current.insert(ch, new Trie());
                current = current.get(ch);
            }

            current.setEnd();
        }
        
    }

    public void dfs(int r, int c, StringBuilder builder, boolean[][] visited, List<String> result, Trie current, char[][] board) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] ||
            !current.contains(board[r][c])) return;

        builder.append(board[r][c]);
        current = current.get(board[r][c]);

        if(current.isEnd) {
            result.add(builder.toString());
            current.isEnd = false;
        }

        visited[r][c] = true;
        dfs(r-1, c, builder, visited, result, current, board);
        dfs(r, c-1, builder, visited, result, current, board);
        dfs(r+1, c, builder, visited, result, current, board);
        dfs(r, c+1, builder, visited, result, current, board);
        visited[r][c] = false;

        builder.deleteCharAt(builder.length()-1);
    }
}