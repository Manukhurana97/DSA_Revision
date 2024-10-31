public class SearchElementInRotatedSortedArray{
	
	// Time: O(N), Space O(1)
	public static int getIndex(int[] arr, int k){
		for(int i=0;i<arr.length;i++){
			if(arr[i] == k) return i;
		}

		return -1;
	}


	// Time: O(Log N), Space O(1)
	public static int getIndex1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right){
           int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {// left to mid is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }


	public static void main(String[] args) {
		
		int[] arr = {4,5,6,7,0,1,2,3};
		int[] arr1 = {4,5,6,7,0,1,2};
		int[] arr2 = {1,2,3,4,5,6,7,0};
		System.out.println(getIndex(arr, 0));
		System.out.println(getIndex(arr1, 3));
		System.out.println(getIndex(arr2, 0));


		System.out.println(getIndex1(arr, 0));
		System.out.println(getIndex1(arr1, 3));
		System.out.println(getIndex1(arr2, 0));
	}
}