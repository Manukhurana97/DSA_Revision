// https://leetcode.com/problems/set-matrix-zeroes/description/

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(matrix[r][c] == 0) {
                    rows[r] = true;
                    cols[c] = true;
                }
            }
        } 

        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(rows[r] || cols[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }


    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int col = 0;

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(matrix[r][c] == 0) {
                    if(c == 0) col = 1;
                    else{
                        matrix[r][0] = 0;
                        matrix[0][c] = 0;
                    }
                }
            }
        }

        for(int r=1; r<rows; r++) {
            for(int c=1; c<cols; c++) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) 
                    matrix[r][c] = 0;
            }
        }

        if(matrix[0][0] == 0) {
            for(int i=0; i<cols; i++) {
                matrix[0][i] = 0;
            }
        }

        if(col == 1) {
            for(int i=0; i<rows; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }


}


