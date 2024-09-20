public class PainterPartitions{

	public static int canPaint(int[] arr, int maxTime){
		int numberOfPainter = 1, sum = 0;

		for(int i: arr){
			if(i + sum <= maxTime){
				sum += i;
			}else{
				numberOfPainter += 1;
				sum = i;
			}
		}

		return numberOfPainter;
	}

	public static int getMinimumTime(int[] arr, int k){

		if(arr.length == 1) return arr[0];

		int minTime = 0, maxTime = 0;

		for(int i: arr){
			minTime = Math.max(minTime, i);
			maxTime += i;
		}

		if(k == 1 ) return maxTime;
		if(arr.length < k) return -1;
		if(arr.length == k) return minTime;

		for(int i = minTime; i <= maxTime; i++){
			if(canPaint(arr, i) == k){
				return i;
			}
		}
		return -1;
	}


	public static int getMinimumTime1(int[] arr, int k){
		if(arr.length == 1) return arr[0];

		int minTime = 0, maxTime = 0;

		for(int i : arr) {
	        minTime = Math.max(minTime, i);
	        maxTime += i;
	    }

		if(k == 1 ) return maxTime;
		if(arr.length < k) return -1;
		if(arr.length == k) return minTime;

		int left = minTime;
		int right = maxTime;

		while(left < right){
			int mid = (left + right) / 2;
			int numOfPainter = canPaint(arr, mid);

			if(numOfPainter == k){
				right = mid;
			}else if(numOfPainter>k){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}

		return left;
	}


	public static void main(String[] args) {
		int[] boards = {5, 5, 5, 5};
		int[] boards1 = {10, 20, 30, 40};

		System.out.println(getMinimumTime(boards, 2));
		System.out.println(getMinimumTime(boards1, 2));


		System.out.println(getMinimumTime1(boards, 2));
		System.out.println(getMinimumTime1(boards1, 2));
	}
}