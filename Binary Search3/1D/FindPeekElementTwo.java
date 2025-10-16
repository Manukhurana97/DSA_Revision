// https://leetcode.com/problems/find-a-peak-element-ii/submissions/1570341977/

import java.util.*;

public class FindPeekElementTwo {

	public static boolean isPeek(int[][] arr, int r, int c, int current) {
	    if (r > 0 && arr[r - 1][c] > current) return false; // Check above
	    if (r < arr.length - 1 && arr[r + 1][c] > current) return false; // Check below
	    if (c > 0 && arr[r][c - 1] > current) return false; // Check left
	    if (c < arr[r].length - 1 && arr[r][c + 1] > current) return false; // Check right

	    return true; // If none of the neighbors are greater, it's a peak
	}

	// check each column (using binary search)
	public static List<Integer> checkPeekElement(int[][] arr, int r){

		int left = 1, right = arr.length-1;

		while(left <= right){
			int mid = (left + right)/2;

			boolean leftCheck = (mid == 0 || arr[r][mid - 1]<arr[r][mid]);
			boolean rightCheck = (mid<arr.length-1 || arr[r][mid] > arr[r][mid + 1]);

			if(leftCheck && rightCheck  && isPeek(arr, r, mid, arr[r][mid])) {
				return Arrays.asList(r, mid);
			}else if(!leftCheck) right = mid - 1;
			else left = mid + 1;
		}

		return Arrays.asList();
	}

	// for each row
	public static List<List<Integer>> getPeekElements(int[][] arr){
		List<List<Integer>> result = new ArrayList<>();

		for(int r=0; r<arr.length; r++){
			List<Integer> response = checkPeekElement(arr, r);
			if(!response.isEmpty()) result.add(response);
		}

		return result;
	}


    // --------------------------------------------------------------------------------

    public boolean isPeakElement(int r, int c, int[][] mat) {
        if(r > 0 && mat[r-1][c] > mat[r][c]) return false;
        if(r < mat.length-1 && mat[r+1][c] > mat[r][c]) return false;
        if(c > 0 && mat[r][c-1] > mat[r][c]) return false;
        if(c < mat[r].length-1 && mat[r][c+1] > mat[r][c]) return false;
        return true;
    }

    public int getPeakElement(int r, int[][] mat) {
        for(int c = 0; c < mat[r].length; c++) {
            if(isPeakElement(r, c, mat)) {
                return c;
            }
        }
        
        return -1;
    }
    
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;

        for(int r = 0; r < n; r++) {
            int c = getPeakElement(r, mat);
            if(c >= 0) {
                return new int[]{r, c}; 
            }
        }

        return new int[]{-1, -1};
    }

        public int getCol(int r, int[][] mat) {
            int maxCol=0;
            for(int c=0; c<mat[r].length; c++) 
                if(mat[r][maxCol] < mat[r][c]) {
                    maxCol = c;
                }
                
            return maxCol;
        } 

    // --------------------------------------------------------------------------------


    public int[] findPeakGrid(int[][] mat) {
        int top= 0, bottom = mat.length-1;

        while(top<=bottom) {
            int mid = (top + bottom) / 2;
            int c = getCol(mid, mat);

            boolean isUpperBigger = (mid>0 && mat[mid-1][c] > mat[mid][c]);
            boolean isLowerBigger = (mid<mat.length-1 && mat[mid+1][c] > mat[mid][c]);

            if(!isUpperBigger && !isLowerBigger) {
                return new int[]{mid, c};
            }

            if(isUpperBigger) {
                bottom = mid-1;
            } else{ 
                top = mid+1;
            }
        }   

        return new int[]{-1, -1};
    }



	public static void main(String[] args) {
		int[][] arr = {
			{4,2,5,1,4,5}, 
			{2,9,3,2,3,2}, 
			{1,7,6,0,1,3}, 
			{3,6,2,3,7,2}};

		System.out.println(getPeekElements(arr));
	}
}