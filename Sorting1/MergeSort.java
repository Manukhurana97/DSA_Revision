public class MergeSort{

	
	public static int[] divide(int[] arr, int start, int end){
		if(start>=end) return arr;

		int mid = start + (end - start) / 2;
		arr = divide(arr, start, mid);
		arr = divide(arr, mid+1, end);
		return combine(arr, start, mid, end);
	}

	public static int[] combine(int[] arr, int start, int mid, int end){
		int i = start, j = mid+1, k = 0;
		int[] aux = new int[arr.length];


		while(i<=mid && j<=end)
			aux[k++] = arr[i] <=arr[j] ? arr[i++] : arr[j++];
		
		while(i<=mid)
			aux[k++] = arr[i++];

		while(j<=end)
			aux[k++] = arr[j++];	

		for( i=0;i<k;i++)
			arr[start + i] = aux[i];
		
		return arr;
	}


	public static void main(String[] args) {
		int[] arr  = {5,4,3,2,1};
		arr = divide(arr, 0, arr.length - 1);

		for(int i: arr){
			System.out.print(i+" ");
		}
	}
}