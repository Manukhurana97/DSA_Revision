public class CountOccurencesInSortedArray{

	public static int countOccurences(int[] arr, int k){
		int count = 0;
		
		for(int i = 0;i < arr.length; i++){
			count += (arr[i] == k) ? 1 : 0;
		}
		return count;
	}


	// getUpperBoundIndex() - getLowerBoundIndex() 
	public static int countOccurences2(int[] arr, int k){
		int endIndex =  getEndIndex(arr, k);
		int startIndex = startIndex(arr, k);

		if (startIndex == -1 || endIndex == -1) 
            return 0; // Element k not found in the array
        


		return endIndex - startIndex + 1;
	}


	public static int startIndex(int[] arr, int k){
		int startIndex = -1;
		int left = 0;
		int right = arr.length-1;

		while(left <= right){
			int mid = (left + right) /2;

			if(arr[mid] == k){
				startIndex = mid;
				right = mid-1;
			}else if(arr[mid]>k){
				right = mid-1;
			}else{
				left = mid+1;
			}
		}

		return startIndex;
	}

	public static int getEndIndex(int[] arr, int k){
		int endIndex = -1;
		int left = 0;
		int right = arr.length-1;

		while(left <= right){
			int mid = (left + right) /2 ;

			if(arr[mid] == k){
				endIndex = mid;
				left = mid+1;
			}else if(arr[mid]>k){
				right = mid-1;
			}else{
				left = mid+1;
			}
		}

		return endIndex;
	}



	public static void main(String[] args) {
		int[] arr = {2, 2, 3 , 3 , 3 , 3 , 4};
		System.out.println(countOccurences(arr, 3));
		System.out.println(countOccurences2(arr, 3));
	}
}