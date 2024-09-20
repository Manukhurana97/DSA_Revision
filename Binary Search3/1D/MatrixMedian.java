// get median in row wise sorted matrix
// let a matrix 5*3, 
public class MatrixMedian{
	
	public static int countSmallerNumberByM(int[] a, int midEl, int n){
		int left = 0;
		int right = n-1;

		while(left<=right){
			int mid = (left + right) / 2;
			
			if(a[mid] <= midEl) left = mid + 1;
			else right = mid - 1;
		}
		return left;
	}

	public static int findMedian(int[][] arr){
		int left = 1;
		int right = 1000000000;
		int n = arr.length;
		int m = arr[0].length;

		while(left <= right){
			// (left + right)/2 right shift , divide by 2
			int mid = (left + right) >> 1;  

			int count = 0;

			// for each row
			for(int i=0;i<n;i++)
				count += countSmallerNumberByM(arr[i], mid, m); // calculate in each column

			if(count <= (n * m) / 2) left = mid+1;
			else right = mid - 1;
		}

		return left;
		
	}

	public static void main(String[] args) {
	int row = 3, col = 3;
    int[][] arr = {{1, 4, 9},
                   {2, 5, 6},
                   {3, 6, 7}};
    int[][] arr1 = {{1,5,7,9,11}, 
    				{2,3,4,5,10}, 
    				{9,10,12,14,16}};
    System.out.println(findMedian(arr));
    System.out.println(findMedian(arr1));
	}
}