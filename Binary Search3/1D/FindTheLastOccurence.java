public class FindTheLastOccurence{

	public static int findLastOcc(int[] arr, int k){
		int index = -1;


		for(int i = 0; i < arr.length; i++){
			if(arr[i] == k){
				index = i;
			}
		}

		return index;
	}

	public static int findLastOcc2(int[] arr, int k){

		int left = 0;
		int right = arr.length-1;
		int index = -1;

		while(left<right){
			int mid = (left + right)/2;
			if(arr[mid] == k){
				index = mid;
				left = mid;
			}else if(arr[mid]>k){
				right = mid-1;
			}else{
				left = mid+1;
			}
		}

		return index;
	}


	public static void main(String[] args) {
		int[] arr = {3,4,13,13,13,20,40};
		System.out.println(findLastOcc(arr, 13));
		System.out.println(findLastOcc2(arr, 13));
	}
}