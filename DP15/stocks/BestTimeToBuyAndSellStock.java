// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

// can buy and sell only one.
public class BestTimeToBuyAndSellStock{

	public int maxProfit(int[] prices) {
        int minIndex = 0, maxIndex = 0, n = prices.length;
        int result = 0;

        for(int i=1; i<n; i++){
            if(prices[maxIndex] < prices[i]){
                maxIndex = i;
            }
            if(prices[minIndex] > prices[i]){
                minIndex = i;
                if(maxIndex < minIndex){
                    maxIndex = minIndex;
                }
            }

            result = Math.max(result, prices[maxIndex] - prices[minIndex]);
        }

        return result;
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