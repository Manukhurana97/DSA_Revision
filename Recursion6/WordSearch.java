// https://leetcode.com/problems/word-search/

public class WordSearch{
	public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        char startVal = word.charAt(0);

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(startVal == board[r][c] && dfs(0, r, c, board, word, visited)){
                    return true;
                }
            }
        }

        return false;
    }


    public  boolean dfs(int i, int r, int c, char[][] board, String word, boolean[][] visited){
        if(i == word.length()) return true;
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visited[r][c] || board[r][c] != word.charAt(i)) return false;

        visited[r][c] = true;

        if(dfs(i+1, r-1, c, board, word, visited)) return true;
        if(dfs(i+1, r, c-1, board, word, visited)) return true;
        if(dfs(i+1, r+1, c, board, word, visited)) return true;
        if(dfs(i+1, r, c+1, board, word, visited)) return true;
        return visited[r][c] = false;
    }
}