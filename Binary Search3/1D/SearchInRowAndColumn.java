public class SearchInRowAndColumn{

	// Time: O(M*N), Space : O(1)
	public static boolean searchElement(int[][] arr, int k){

		for(int[] i: arr){
			for(int j: i){
				if(j == k) return true;
			}
		}

		return false;
	}

	// perform binary search in each row
	// Time: O(M*logN), Space : O(1)
	public static boolean searchElement1(int[][] arr, int k){

		for(int[] i: arr){ // for each row
			int left = 0, right = i.length;

			while(left<right){ // binary search
				int mid = ( left + right )/2;

				if(i[mid] == k) return true;
				else if(i[mid]>k) right = mid-1;
				else left = mid+1;
			}
		}

		return false;
	}

	// we will start from 1 row and nth col , during division , if the element is greater we will go down(row++) else we will reduce the left (col--)
	// Time: O(log(N*M)), Space : O(1)
	public static boolean searchElement2(int[][] arr, int k){
		int n = arr.length;
		int m = arr[0].length;

		int row = 0;
		int col = m - 1;
		while(row<n && col>=0){
			if(arr[row][col] == k) return true;
			else if(arr[row][col] < k)row+=1;
			else col-=1;
		}

		return false;
	}



	public static void main(String[] args) {
		int[][] arr = {
			{1, 4, 7, 11, 15}, 
			{2, 5, 8, 12, 19}, 
			{3, 6, 9, 16, 22}, 
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30}
		};

		System.out.println(searchElement(arr, 8));
		System.out.println(searchElement1(arr, 8));
	}
}