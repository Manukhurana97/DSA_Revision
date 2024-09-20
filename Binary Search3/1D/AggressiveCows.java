import java.util.*;

public class AggressiveCows{

	public static boolean canWePlace(int[] arr, int k, int distance){
		int n = arr.length;
		int last = arr[0];

		k-=1; // since we place element in first element

		for(int i = 1; i< n; i++){
			if(arr[i] - last >= distance){
				k--;
				last = arr[i];
			}
			if(k <= 0){
				return true;
			}
		}

		return false;
	}

	public static int getMaxPossibleMinDistance(int[] arr, int k){
		int n = arr.length;

		Arrays.sort(arr);

		for (int distance = 1; distance <=(arr[n-1] - arr[0]); distance++)
			if(!canWePlace(arr, k, distance))
				return distance-1;	
			
		return -1;
	}



	public static int getMaxPossibleMinDistance1(int[] arr, int k){
		int n = arr.length;

		Arrays.sort(arr);

		int left = 1;
		int right = arr[n-1] - arr[0];
		int result = 0;

		while(left<right){

			int mid = (left + right)/2;

			if(canWePlace(arr, k, mid)){
				result = mid;
				left = mid+1;
			}else{
				right = mid-1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = {0,3,4,7,10,9};
		System.out.println(getMaxPossibleMinDistance(arr, 4));
		System.out.println(getMaxPossibleMinDistance1(arr, 4));
	}
}