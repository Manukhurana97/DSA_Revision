// https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/

public class CountSquareSubmatricesWithAllOnces{

	/**
	 * crete a table  : input {{1,1,1,1,1}, {1,1,1,1,0}, {1,1,1,1,1}}
	 * 1 1 1 1 1
	 * 1 2 2 2 0 
	 * 1 2 3 3 1 
	 * */ 
	int countSquares(int[][] arr){
		int rows = arr.length, cols = arr[0].length, count = 0;
		int[][] dp = new int[rows][cols];

		for(int i=0; i<rows; i++){ 
			dp[i][0] = arr[i][0];
			count += dp[i][0];
		}
		for(int i=0; i<cols; i++){ 
			dp[0][i] = arr[0][i];
			count += dp[0][i];
		}
		

		for(int r=1; r<rows; r++){
			for(int c=1; c<cols; c++){
				if(arr[r][c] != 0) {
					dp[r][c] = 1 + Math.min(dp[r-1][c-1], Math.min(dp[r-1][c], dp[r][c-1]));
					count += dp[r][c];
				}
			}
		}

		return count;
	}



	// ---------------------------------------------------

	public int countSquares(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int count = 0;

        for(int r=0; r<rows; r++) count += matrix[r][0];
        for(int c=1; c<cols; c++) count += matrix[0][c];


        for(int r=1; r<rows; r++) {
            for(int c=1; c<cols; c++) {
                if(matrix[r][c] == 1) {
                    matrix[r][c] = 1 + Math.min(matrix[r-1][c-1], Math.min(matrix[r-1][c], matrix[r][c-1]));
                    count += matrix[r][c];
                }
                
            }
        }

        return count;
    }

	public static void main(String[] args) {
		CountSquareSubmatricesWithAllOnces obj = new CountSquareSubmatricesWithAllOnces();

		int[][] arr = {
			{1,1,1,1}, 
			{1,1,0,1}, 
			{1,1,1,1}};
		System.out.println(obj.countSquares(arr));
	}
}