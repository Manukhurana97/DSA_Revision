public class FloorAndCeil{


	// Time : O(N), Space: O(1)
	public static void findFloor(int[] arr,  int x) {

		int floor = Integer.MIN_VALUE;
		int ceil = Integer.MAX_VALUE;

		for(int i : arr){
			if(i < x)
				floor = Math.max(i, floor);
			if(i>x)
				ceil = Math.min(i, ceil);
		}

		System.out.println("floor "+ floor);
		System.out.println("ceil "+ ceil);

	}


	// Time : O(log N), Space: O(1)
	public static void findFloor2(int[] arr, int x){
		int left = 0;
		int right = arr.length;

		int floor = Integer.MIN_VALUE;
		int ceil = Integer.MAX_VALUE;

		while(left<right){
			int mid = (left + right) / 2;
			if(arr[mid]>x){
				right = mid;
				ceil = arr[mid];
			}else{
				left = mid;
				floor = arr[mid];
			}
		}

		System.out.println("floor "+ floor);
		System.out.println("ceil "+ ceil);
	}



	public static void main(String[] args) {
		int arr1[] ={3, 4, 4, 7, 8, 10};
		int arr2[] ={3, 4, 4, 7, 8, 10};
		
		findFloor(arr1, 5);
		findFloor(arr2, 5);

		System.out.println();
		findFloor2(arr1, 5);
		findFloor2(arr2, 5);

	}

}