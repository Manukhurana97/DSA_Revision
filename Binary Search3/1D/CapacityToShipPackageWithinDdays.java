public class CapacityToShipPackageWithinDdays{

	public static int getMinCapacity(int[] arr, int d){
		if(arr.length == 1) return arr[0];
		
		int minCalacity = 0;
		int maxCapacity = 0;
		for(int i: arr) {
			minCalacity = Math.max(minCalacity, i);
			maxCapacity += arr[i];
		}
		
		if(d == 1) return maxCapacity;
		if(d == maxCapacity) return 1;


		for(int i = minCalacity;i<=maxCapacity;i++){
			int capacity = i;
			int day = 0;
			for (int j : arr){
				capacity-=j;
				if(capacity == 0){
					day += 1;
					capacity = i;
				}else if(capacity < 0){
					day += 1;
					capacity = i - j;
				}
			}

			if(day == d) return i;
		}
		return -1;
	}


	public static int getMinCapacity1(int[] arr, int d){
		if(arr.length == 1) return arr[0];
		
		int minCalacity = 0;
		int maxCapacity = 0;

		for(int i: arr) {
			minCalacity = Math.max(minCalacity, i);
			maxCapacity += arr[i];
		}
		
		if(d == 1) return maxCapacity;

		int left = minCalacity;
		int right = maxCapacity;

		while(left <= right){
			int mid = (left + right) / 2;

			int day = 0;
			int temp = mid;
			for (int j = 0; j < arr.length; j++){
				temp-=arr[j];
				if(temp==0){
					day += 1;
					temp = mid;
				}else if(temp<0){
					day += 1;
					temp = mid - arr[j];
				}
			}

			if(day>d){
				left = mid+1;
			}else{
				right = mid -1;
			}

		}

		return left;
	}


	public static void main(String[] args) {
		int[] arr = {5,4,5,2,3,4,5,6};

		System.out.println(getMinCapacity(arr, 5));
		System.out.println(getMinCapacity1(arr, 5));
	}
}