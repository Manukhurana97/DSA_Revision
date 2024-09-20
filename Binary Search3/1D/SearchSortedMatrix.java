public class SearchSortedMatrix{

	public static boolean getElement(int[][] arr, int k){
		for(int[] i: arr){
			for(int j: i){
				if(j==k) return true;
			}
		}

		return false;
	}

	public static boolean isElementExists1(int[][] arr, int k){
		int row = arr.length;
		int col =  arr[0].length;

		int leftR = 0, leftC = 0;
		int rightR = row, rightC = col;
		

		while(leftR<rightR && leftC<rightC){
			int midR = leftR + (rightR-leftR)/2; // mid row
			int midC = leftC + (rightC - leftC)/2; // mid col

			if(arr[midR][midC] == k){ 
				return true;
			}else if(arr[midR][midC] < k){
				if(arr[midR][col-1] >= k) leftC = midC+1;
				else {
					leftR = midR+1;
					leftC = 0;
				}
			}else{
				if(arr[midR][0] > k){ 
					rightR +=midR-1;
					rightC = col-1;
				}
				else rightC = midC-1;
			}
		}

		return false;
	}


	public static boolean isElementExists2(int[][] arr, int k){
		if (arr == null || arr.length == 0 || arr[0].length == 0) 
        	return false;
    	

	    int row = arr.length;
	    int col = arr[0].length;
	    int r = 0;
	    int c = col - 1;

	    while(r<row && c>=0){
	    	if(arr[r][c] == k) return true;
	    	else if(arr[r][c]>k)  c--;
	    	else r +=1;
	    }

	    return false;


	}


	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] arr1 = {{1,2,4}, {6,7,8}, {9, 10, 34}};
		
		System.out.println(getElement(arr, 8));
		System.out.println(isElementExists1(arr, 8));
		System.out.println(isElementExists2(arr, 8));

		System.out.println(getElement(arr1, 81));
		System.out.println(isElementExists1(arr1, 81));
		System.out.println(isElementExists2(arr1, 81));
	}
}