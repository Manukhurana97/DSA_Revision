public class SearchElementInRotatedSortedArray2{

	// Time: O(N), Space O(1)
	public static int getIndex(int[] arr, int k){
		for(int i=0;i<arr.length;i++){
			if(arr[i] == k) return i;
		}

		return -1;
	}


	// Time: O(Log N), Space O(1)
	public static int getIndex1(int[] arr, int k){
		// get mid and check which section is sorted and check if element can present in which section
	
		int left = 0;
		int right = arr.length-1;

		while(left<=right){
			int mid = (left + right) / 2;

			if(arr[mid] == k){
				return mid;
			}

			if(arr[left] == arr[mid] && arr[right] == arr[mid]){
				left = left+1;
				right = right-1;
				continue;
			}

			if (arr[left] <= arr[mid] ) { // if left array is sorted
			 	if (arr[left] <= k && k <= arr[mid]) {
			 		right = mid-1;
			 	}else{
			 		left = mid+1;
			 	}
			}else{
				if(arr[mid] <= k && k <= arr[right]){
					left = mid+1;
				}else{
					right = mid-1;
				}
			}
		}

		return -1;
	}


	public static void main(String[] args) {
		SearchElementInRotatedSortedArray2 obj = new SearchElementInRotatedSortedArray2();
		int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
		int[] arr1 = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};

		System.out.println("v1 "+ obj.getIndex(arr, 3));
		System.out.println("v1 "+ obj.getIndex(arr1, 10));


		System.out.println("v2 "+ obj.getIndex1(arr, 3));
		System.out.println("v2 "+ obj.getIndex1(arr1, 10));	
	}
}