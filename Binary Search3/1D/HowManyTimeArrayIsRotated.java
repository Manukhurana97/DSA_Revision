public class HowManyTimeArrayIsRotated{

	public static int countRotation(int[] arr){
		int n = arr.length;

		for(int i=1;i<n;i++){
			if(arr[i-1]>arr[i]){
				return i;
			}
		}
		return 0;
	}


	public static int countRotation2(int[] arr){
		int left = 0;
		int right = arr.length-1;


		while(left <= right){
			int mid = (left + right) /2;

			if(arr[left] < arr[right])return left;			
			
			if(arr[left] < arr[mid]) left = mid + 1;
			else right = mid - 1;	
		}
		return 0;
	}



	public static void main(String[] args) {

		int[] arr = {4,5,6,7,0,1,2,3};
		int[] arr1 = {3,4,5,1,2};
		int[] arr2 = {5,4,3,2,1};
		
		System.out.println(countRotation(arr));
		System.out.println(countRotation(arr1));
		System.out.println(countRotation(arr2));

		System.out.println(countRotation2(arr));
		System.out.println(countRotation2(arr1));
		System.out.println(countRotation2(arr2));
	}
}
