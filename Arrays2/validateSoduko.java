// https://leetcode.com/problems/valid-sudoku/

public class validateSoduko{
	public boolean isValidSudoku(char[][] board) {
        // use sets to track seen numbers
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                int num = ch - '1'; // convert '1'–'9' → 0–8
                int boxIndex = (r / 3) * 3 + (c / 3);

                // check row, col, and box
                if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                    return false;
                }

                rows[r][num] = cols[c][num] = boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}