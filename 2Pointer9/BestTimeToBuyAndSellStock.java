public class BestTimeToBuyAndSellStock{
    public int maxProfit(int[] prices) {
        int minIndex = 0;
        int maxIndex = 0;
        int maxProfit = 0;
        
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[minIndex]){
                minIndex = i;
                if(maxIndex < i) maxIndex = i;
            }

            if(prices[maxIndex]<prices[i]) maxIndex = i;
            
            maxProfit = Math.max(maxProfit, prices[maxIndex] - prices[minIndex]);
        }

        return maxProfit;
    }


// -------------------------------------------------------------------------------------
    
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, maxProfit = 0, n = prices.length;

        while(r<n){
            if(prices[r]<prices[l])
                l = r;

             maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            
            r++;
        }

        return maxProfit;
    }
}