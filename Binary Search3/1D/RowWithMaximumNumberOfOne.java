public class RowWithMaximumNumberOfOne{

	// Time : O(r*c)
	public static int findRow(int[][] arr){
		int ithRow = -1;
		int maxOnces = 0;

		for(int i=0;i<arr.length;i++){
			int count = 0;
			for(var j: arr[i]) count += (j == 1) ? 1 : 0;
			
			if(count > maxOnces){
				maxOnces = count;
				ithRow = i;
			}
		}
		return ithRow;
	}

	// Time : O(nLogc)
	public static int lowerBound(int[] arr, int i){
		int left = 0, right = arr.length-1;
		int ans = arr.length;

		while(left<=right){
			int mid = (left + right)/2;

			if (arr[mid]>=1) {
				ans = mid;
				right = mid -1;
			}else{
				left = mid + 1;
			}
		}

		return ans;
	}

	public static int findRow1(int[][] arr){
		int ithRow = -1;
		int maxOnces = 0;
		for(int row=0;row<arr.length;row++){
			int count = arr[row].length - lowerBound(arr[row], row);

			if(count > maxOnces){
				maxOnces = count;
				ithRow = row;
			}
		}

		return ithRow;
	}

	public static void main(String[] args) {
		int[][] arr = {{1,1,1}, {0,0,1}, {0,0,0}};
		int[][] arr1 = {{0,0,0}, {0,0,0}};

		System.out.println(findRow(arr));
		System.out.println(findRow(arr1));
		
		System.out.println(findRow1(arr));
		System.out.println(findRow1(arr1));
	}
}