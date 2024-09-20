public class SearchInsertionPosition{

	// Time : O(N), Space : O(1)
	public static int searchInsert(int [] arr, int x) {
		for(int i=0;i<arr.length;i++){
			if(arr[i] == x || arr[i]>x){
				return i;
			}
		}
		return arr.length;
	}

	// Time : O(LogN), Space : O(1)
	public static int searchInsert1(int [] arr, int x) {
		int left = 0, right = arr.length;

		while(left < right){
			int mid = (left + right)/2;
			if (arr[mid] == x) return mid;
			else if(arr[mid]>x) right = mid-1;
			else left = mid+1;
		}

		
		return left;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,4,7};
		System.out.println(searchInsert(arr, 6));
		System.out.println(searchInsert(arr, 2));


		System.out.println(searchInsert1(arr, 6));
		System.out.println(searchInsert1(arr, 2));	}

}