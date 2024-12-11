// https://leetcode.com/problems/word-search/

public class WordSearch{
	public boolean exist(char[][] board, String word) {

        char[] charArr = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[r].length; c++){
                if(board[r][c] == charArr[0] && dfs(0, r, c, board, charArr,  visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int r, int c, char[][] board, char[] charArr, boolean[][] visited){
        if(i == charArr.length) return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[r].length || visited[r][c] ||charArr[i] != board[r][c]) return false;

        visited[r][c] = true;

        if(dfs(i+1, r + 1, c, board, charArr, visited)) return true;
        if(dfs(i+1, r - 1, c, board, charArr, visited)) return true;
        if(dfs(i+1,r, c + 1, board, charArr, visited)) return true;
        if(dfs(i+1, r, c - 1, board, charArr, visited)) return true;

        visited[r][c] = false;
        return false;
    }
}