public class RotateMatrix{

// {
// 	{1,2,3},
// 	{4,5,6},
// 	{7,8,9}
// }

	// Time Complexity: O(N^2 + N^2) , Space: O(N^2)
	public static int[][] rotate(int[][] arr){

		int n  = arr.length;
		int[][] aux = new int[arr.length][arr.length];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				aux[j][n-i-1] = arr[i][j];
			}
		}

		return aux;
	}


// {
// 	{1,2,3},
// 	{4,5,6},
// 	{7,8,9}
// }

	// Time : O(N^2), Space O(1)
	public static int[][] rotate1(int[][] arr){

		int n  = arr.length;
	
		for(int i=0; i<n/2; i++){
			for(int j=0; j<n; j++){
				int temp = arr[i][j];
				arr[i][j] = arr[n-i-1][j];
				arr[n-i-1][j] = temp;
			}
		}

		
		// 1 2 3 
		// * 2 3
		// * * 3   
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}

		return arr;

	}


	public static void print(int[][] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		int[][] arr = {
			{1,2,3},
			{4,5,6},
			{7,8,9}};
		// arr = rotate(arr);
		print(rotate1(arr));
	}
}
