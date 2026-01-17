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

    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9]; // use index as a position eg 5 4th value will be 1 -> 000010000
        int[] cols = new int[9]; // use index as a position eg 5 4th value will be 1 -> 000010000
        int[] boxes = new int[9];// use index as a position eg 5 4th value will be 1 -> 000010000

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue;

                int bit = 1 << (val - '1');     // bit for number
                int box = (r / 3) * 3 + (c / 3);

                if ((rows[r] & bit) != 0 || // if bit is ON in the row the number already exists
                    (cols[c] & bit) != 0 || // if bit is ON in the col the number already exists
                    (boxes[box] & bit) != 0) { // if bit is ON in the box (3 * 3) the number already exists
                    return false;
                }

                rows[r] |= bit; // with or operation we are turing the bit on
                cols[c] |= bit; // with or operation we are turing the bit on
                boxes[box] |= bit; // with or operation we are turing the bit on
            }
        }
        return true;
    }

}