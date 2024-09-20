import java.util.*;

public class KthMissingPositiveNumber{

	// Time Complexity: O(K*n)
	public static int getMissingNumber(int[] arr, int k){
		int i = 0;
		while(k>0){
			i += 1;
			if(!isKIn(arr, i)) k--;
		}
		return i;
	}


	public static boolean isKIn(int[] arr, int k){
		// for(var i: arr){
		// 	if(i > k) return false;
		// 	if(i == k) return true;
		// }
		// return false;

		return Arrays.binarySearch(arr, k)>=0;
	}


	public static int getMissingNumber1(int[] arr, int k){
		int left = 0;
		int right = arr.length;

		while(left < right){
			int mid = (left + right) / 2;
			int missing = arr[mid] - (mid + 1);
			
			if(missing<k){
				left = mid + 1;
			}else{
				right = mid;
			}
		}

		return left + k;
	}


	public static void main(String[] args) {
		int[] arr = {4,7,9,10};
		int[] arr1 = {2, 3, 4, 7, 11};
		System.out.println(getMissingNumber(arr, 1));
		System.out.println(getMissingNumber(arr, 4));
		System.out.println(getMissingNumber(arr, 5));

		System.out.println(getMissingNumber1(arr, 1));
		System.out.println(getMissingNumber1(arr, 4));
		System.out.println(getMissingNumber1(arr1, 5));

		

	}
}