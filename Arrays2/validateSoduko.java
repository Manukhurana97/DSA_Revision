// https://leetcode.com/problems/valid-sudoku/

public class validateSoduko{
	public boolean isValidSudoku(char[][] board) {
        
        for(int r=0; r<9; r++){

            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] box = new boolean[9];

            for(int c=0; c<9; c++){
                // check row
                if(board[r][c] != '.') {
                    int val = board[r][c] - '1';
                    if(row[val]) return false;
                    row[val] = true;
                }

                // check col        
                if(board[c][r] != '.') {
                    int val = board[c][r] - '1';
                    if(col[val]) return false;
                    col[val] = true;
                }
        
                // check column
                int rowIndex = (r / 3) * 3;
                int colIndex = (r % 3) * 3;
                int dr = rowIndex + c / 3;
                int dc = colIndex + c % 3;
                if(board[dr][dc] != '.') {
                    int val = board[dr][dc] - '1';
                    if(box[val]) return false;
                    box[val] = true;
                }

            }
        }

        return true;
    }
}