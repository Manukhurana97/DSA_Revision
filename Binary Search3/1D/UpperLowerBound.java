public class UpperLowerBound{


	// given sorted array find lower bound, element less the k
	// Time: O(N), Space: O(1)
	public static int getLowerBound(int[] arr, int k){
		int n = arr.length;

		for(int i=0;i<n;i++){
			if(arr[i]>=k) return i;
		}

		return n;
	}

	// Time O(N log N), Space O(1)
	public static int getLowerBound2(int[] arr, int k){
		int n = arr.length-1;
		int i = 0;

		while(i<n){
			int mid = (n + i) / 2;

			if(arr[mid]<k){
				i=mid+1;
			}else{
				n = mid;
			}
		}
		return i;
	}


	public static int getUpperBound(int[] arr, int k){
		int n = arr.length;

		for(int i=0;i<n;i++) if(arr[i]>k) return i;

		return n;
	}


	public static int getUpperBound2(int[] arr, int k){

		int left = 0;
		int right = arr.length-1;
		int ans = 0;

		while(left<=right){
			int mid = (right + left) / 2;

			if(arr[mid]<k){
				left = mid+1;
			}
			else{
				ans = mid;
				right = mid-1;
			}
		}

		return left;
	}




	public static void main(String[] args) {
		int[] arr1 = {1,2,2,3};
		int[] arr2 = {3,5,8,15,19};
		
		System.out.println("lower "+ getLowerBound(arr1, 2));
		System.out.println("lower "+ getLowerBound(arr2, 9));

		System.out.println("lower "+ getLowerBound2(arr1, 2));
		System.out.println("lower "+ getLowerBound2(arr2, 9));


		System.out.println("Upper "+getUpperBound(arr1, 2));
		System.out.println("Upper "+getUpperBound(arr2, 9));


		System.out.println("Upper "+getUpperBound2(arr1, 2));
		System.out.println("Upper "+getUpperBound2(arr2, 9));


	}
}
