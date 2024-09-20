public class kokoEatingBanana{
	public static int getBananas(int[] arr, int k){
		if(arr.length == 1) return arr[0];

		int max = Integer.MIN_VALUE;
		for(var i: arr) max = Math.max(i, max);

		if(arr.length == k) return max;

		for(int i=1;i<=max;i++){
			int count = 0;
			for(int j: arr) count += Math.ceil((double)j/ (double)i);
			
			if(count <= k) return i;
			
		}
		return 0;
	}

	public static int getBananas1(int[] arr, int k){
		int n = arr.length;
		if(arr.length == 1) return arr[0];

		int max = Integer.MIN_VALUE;
		for(var i: arr) max = Math.max(i, max);

		if(n == k) return max;

		int left = 1;
		int right = max;

		while(left<=right){
			int mid = (left + right) / 2;

			int count = 0;
			for(int j: arr) count += Math.ceil((double)j / (double)mid);


			if(count>k){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}


		return left;
	}

	public static void main(String[] args) {
		int[] arr = {7, 15, 6, 3};
		int[] arr1 = {25, 12, 8, 14, 19};

		System.out.println(getBananas(arr, 8));
		System.out.println(getBananas(arr1, 5));


		System.out.println(getBananas1(arr, 8));
		System.out.println(getBananas1(arr1, 5));
	}
}