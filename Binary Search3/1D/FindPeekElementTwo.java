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



	public static void main(String[] args) {
		int[][] arr = {
			{4,2,5,1,4,5}, 
			{2,9,3,2,3,2}, 
			{1,7,6,0,1,3}, 
			{3,6,2,3,7,2}};

		System.out.println(getPeekElements(arr));
	}
}