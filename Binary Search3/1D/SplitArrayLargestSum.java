public class SplitArrayLargestSum {

	public static int canSplitInKSubset(int[] arr,int maxSum) {

		int numOfSplit = 1;
		int sum = 0;
		for (int i : arr) {
			if (i + sum < maxSum) {
				sum += i;
			} else {
				numOfSplit += 1;
				sum = i;
			}
		}
		return numOfSplit;
	}


	public static int getLargestSum(int[] arr, int k) {
		if (arr.length == 1) return arr[0];

		int minSum = 0;
		int maxSum = 0;

		for (int i : arr) {
			minSum = Math.max(minSum, i);
			maxSum += i;
		}

		if(arr.length == k) return minSum;
		if(arr.length < k) return -1;
		if(k == 1) return maxSum;

		for ( int i = minSum; i <= maxSum; i++){
			if (canSplitInKSubset(arr, i) == k){
				return i;
			}
		}
		return -1;
	}


	public static int getLargestSum1(int[] arr, int k) {

		if (arr.length == 1) return arr[0];

		int minSum = 0;
		int maxSum = 0;

		for (int i : arr) {
			minSum = Math.max(minSum, i);
			maxSum += i;
		}

		if(arr.length == k) return minSum;
		if(arr.length < k) return -1;
		if(k == 1) return maxSum;

		int left = minSum;
		int right = maxSum;

		while(left <= right){
			int mid = (left+right) / 2;

			int numberOfSplit = canSplitInKSubset(arr, mid);
			if(numberOfSplit == k) {
				return mid;
			}else if(numberOfSplit < k){
				right = mid -1;
			}else{
				left = mid+1;
			}
		}

		return left;

	}


	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] arr1 = {3,5,1};

		System.out.println(getLargestSum(arr, 3));
		System.out.println(getLargestSum(arr1, 3));

		System.out.println(getLargestSum1(arr, 3));
		System.out.println(getLargestSum1(arr1, 3));

	}
}