public class BinarySearchOnSortedArray{

	public static int binarySearch(int[] arr, int k){
		int i=0, n = arr.length-1;

		while(i <= n){
			int mid = (n + i) / 2;
			if(k == arr[mid]) return mid;
			else if (k<arr[mid]) n = mid+1;
			else i = mid-1;
		}


		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};
		System.out.println(binarySearch(arr, 12));
	}
}