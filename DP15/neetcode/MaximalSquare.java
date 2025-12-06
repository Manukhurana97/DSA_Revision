// https://leetcode.com/problems/maximal-square/description/

public class MaximalSquare{
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        if(matrix == null || rows == 0 || cols == 0) return 0;
         
        Integer[][] memo = new Integer[rows+1][cols+1];

        int maxValue = 0;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                // maxValue = Math.max(maxValue, recursion(r, c, matrix));

                maxValue = Math.max(maxValue, memoization(r, c, matrix, memo));
            }
        } 
         
        return maxValue * maxValue;

        // return tabulation(matrix);

        // return spaceOptimization(matrix);
    }

    private int recursion(int r, int c, char[][] matrix){
        if(r < 0 || c < 0 || matrix[r][c] == '0') return 0;

        
        int left = recursion(r-1, c, matrix);
        int top = recursion(r, c-1, matrix);
        int topleft = recursion(r-1, c-1, matrix);


        return 1 + Math.min(Math.min(left, top), topleft);

    }


    private int memoization(int r, int c, char[][] matrix, Integer[][] dp){
        if(r < 0 || c < 0 || matrix[r][c] == '0') return 0;

        if(dp[r][c] != null) return dp[r][c];
        
        int left = memoization(r-1, c, matrix, dp);
        int top = memoization(r, c-1, matrix, dp);
        int topleft = memoization(r-1, c-1, matrix, dp);


        return dp[r][c] = 1 + Math.min(Math.min(left, top), topleft);

    }


    private int tabulation(char[][] matrix){
        int maxValue = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        
        for(int r=0; r<rows; r++){
            dp[r][0] = matrix[r][0] == '0' ? 0 : 1;
            maxValue = Math.max(maxValue, dp[r][0]);
        }
        for(int c=0; c<cols; c++){
            dp[0][c] = matrix[0][c] == '0' ? 0 : 1;
            maxValue = Math.max(maxValue, dp[0][c]);
        }

        for(int r=0; r<rows; r++){
            for(int c=1; c<cols; c++){
                if(matrix[r][c] == '1'){
                    int left = dp[r-1][c];
                    int top = dp[r][c-1];
                    int topleft = dp[r-1][c-1];

                    dp[r][c] = 1 + Math.min(Math.min(left, top), topleft);
                    maxValue = Math.max(maxValue, dp[r][c]);
                }else{
                    dp[r][c] = 0;
                }
            }
        }

        return maxValue * maxValue;
    }


    private int spaceOptimization(char[][] matrix) {
        int maxValue = 0;
        int rows = matrix.length, cols = matrix[0].length;

        int[] prev = new int[cols + 1]; 
        int[] curr = new int[cols + 1]; 

        for (int r = 0; r < rows; r++) {
            for (int c = 1; c <= cols; c++) { 
                if (matrix[r][c - 1] == '1') {
                    curr[c] = 1 + Math.min(Math.min(prev[c], curr[c - 1]), prev[c - 1]);
                    maxValue = Math.max(maxValue, curr[c]);
                } else {
                    curr[c] = 0;
                }
            }
            prev = curr.clone();
            
        }

        return maxValue * maxValue;
    }


    // ------------------------------------------------------------------------------
    public int maximalSquare1(char[][] matrix) {
        int maxSize = 0;

        for(int r=1; r<matrix.length; r++) {
            for(int c=1; c<matrix[0].length; c++) {
                if(matrix[r][c]-'0' >= 1) {
                    int max = 1 + Math.min(matrix[r-1][c]-'0', Math.min(matrix[r-1][c-1]-'0', matrix[r][c-1]-'0'));
                    
                    matrix[r][c] = (char)(max+'0');
                    maxSize = Math.max(maxSize, max);
                }
            }
        }

        if(maxSize == 0){
            for(int r=0; r<matrix.length; r++) if(matrix[r][0] == '1') return 1;
            for(int c=0; c<matrix[0].length; c++) if(matrix[0][c] == '1') return 1;
        }

        return maxSize * maxSize;
    }

    public static void main(String[] args) {
        char[][] arr = {{'1','1','1','1'}, {'1', '1','1','1'},{'1','1','1','1'}, {'1', '1','1','1'}};

        MaximalSquare obj = new MaximalSquare();
        System.out.println(obj.maximalSquare(arr));
    }
}