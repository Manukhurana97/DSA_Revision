public class MinimumInRotatedSortedArray{

	public static int getMin(int[] arr){

		int minElem = Integer.MAX_VALUE;

		for(var i : arr)
			minElem = Math.min(minElem, i);

		return minElem;
	}


	public static int getMin1(int[] arr){

		int left = 0;
		int right = arr.length-1;

		while(left<right){
			int mid = (right + left) / 2;

			// if the array is already sorted
			if(arr[left] < arr[right]) return arr[left];
			
			if(arr[left] <= arr[mid]) left = mid+1;
			else right = mid-1;
			
		}

		return -1;

	}


	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,7,0,1};
		int[] arr1 = {3,4,5,1,2};

		System.out.println(getMin(arr));
		System.out.println(getMin(arr1));

		System.out.println(getMin1(arr));
		System.out.println(getMin1(arr1));
	}
}