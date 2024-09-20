public class MinimumDaysToMakeABouquets{

	public static int getNumberOfDays(int[] arr, int m, int k){

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(var i: arr){
			min = Math.min(i, min);
			max = Math.max(i, max);
		}

		for(int i=min;i<=max;i++){
			int noOfBookeys = 0;
			int flowerCount = 0;
			for(var j: arr){
				if(i>=j){
					flowerCount+=1;
				}else{
					noOfBookeys += (flowerCount/k);
					flowerCount = 0;
				}
			}
			noOfBookeys += (flowerCount/k);
			if(noOfBookeys>=m) return i;
		}

		return -1;
	}


	public static int getNumberOfDays1(int[] arr, int m, int k){

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(var i: arr){
			min = Math.min(i, min);
			max = Math.max(i, max);
		}


		while(min<=max){
			int mid = (min + max)/2;

			int noOfBookeys = 0;
			int flowerCount = 0;

			for(var j: arr){
				if(mid>=j){
					flowerCount += 1;
				}else{
					noOfBookeys += (flowerCount/k);
					flowerCount = 0;
				}
			}
			noOfBookeys += (flowerCount/k);

			if(noOfBookeys<m){
				min = mid+1;
			}else{
				max = mid-1;
			}
		}

		return min;

	}

	public static void main(String[] args) {
		int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
		System.out.println(getNumberOfDays(arr, 2, 3));
		System.out.println(getNumberOfDays1(arr, 2, 3));
	}
}