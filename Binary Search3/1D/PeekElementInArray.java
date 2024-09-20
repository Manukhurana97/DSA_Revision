public class PeekElementInArray{

	public static int getPeekIndex(int[] arr) {
        int n = arr.length;

        if(n == 1) return arr[0];
		if(arr[0] > arr[1]) return 0;
		for(int i=1;i<n-1;i++) if(arr[i-1] < arr[i] && arr[i]>arr[i+1]) return i;
		if(arr[n-2]<arr[n-1]) return n-1;

		return -1;
    }


	public static int getPeekIndex1(int[] arr){

		int n = arr.length;
		if (n == 1) return 0;
 		if(arr[0]>arr[1]) return 0;
 		

 		int left = 1;
 		int right = n-2;

 		while(left<=right){
 			int mid = (left+right) /2;
            if(arr[mid-1] < arr[mid] && arr[mid]>arr[mid+1]) return mid;
            if(arr[mid]<arr[mid-1]) right = mid-1;
            else left = mid+1;
        }
        
        return (arr[n-1]>arr[n-2])? n - 1: -1;
	}


	public static void main(String[] args) {
		int[] arr = {1, 7, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(getPeekIndex(arr));
		System.out.println(getPeekIndex1(arr));	
	}
}
// 1 2 3 4 6 5 7 8 9