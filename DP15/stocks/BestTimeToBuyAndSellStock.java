public class BestTimeToBuyAndSellStock{
	private int maxProfit(int[] arr){
		int minIndex = 0, maxIndex = 0;

		for(int i=1; i<arr.length; i++){
			if(arr[maxIndex] < arr[i]){
				maxIndex = i;
			}
			if(arr[minIndex]>arr[i]){
				minIndex = i;
				if(maxIndex<minIndex){
					maxIndex = minIndex;
				}
			}
		}

		return arr[maxIndex] - arr[minIndex];
	}

	private int maxProfit1(int[] arr){
		int profit = 0, min = arr[0];

		for(int i=1; i<arr.length; i++){
			int diff = arr[i] - min;
			profit = Math.max(profit, diff);
			min = Math.min(min, arr[i]);
		}

		return profit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
		int[] arr = {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(arr));
		System.out.println(obj.maxProfit1(arr));
	}
}