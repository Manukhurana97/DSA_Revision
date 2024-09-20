public class SearchSingleElementInSortedArray{

	public static int getElement(int[] arr){
		int xor = 0;
		for(int i: arr){
			xor ^=i;
		}

		return xor;
	}


	// element are in order even/odd before single and odd/even after single char
	public static int getElement1(int[] arr){

		int n = arr.length;

		if(n==1) return arr[0];
		if(arr[0] != arr[1]) return arr[0];
		if(arr[n-2] != arr[n-1]) return arr[n-1];

		int left = 1;
		int right = n-2;

		while(left<=right){

			int mid = (left + right)/2;

			if(arr[mid - 1] != arr[mid] && arr[mid] != arr[mid+1]){
				return arr[mid];
			}
			else if((mid % 2 == 1 && arr[mid] == arr[mid-1]) || 
			(mid % 2 == 0 && arr[mid] == arr[mid+1])){
				left = mid+1;
			}
			else{
				right = mid-1;
			}
		}

		return -1;
	}




	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
		int[] arr1 = {1,1,3,5,5};

		System.out.println(getElement(arr));
		System.out.println(getElement(arr1));

		

		System.out.println(getElement1(arr));
		System.out.println(getElement1(arr1));
	}
}