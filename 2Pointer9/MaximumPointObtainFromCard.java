// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

public class MaximumPointObtainFromCard{

	public int maxScore(int[] cardPoints, int k) {
        int[] arr = new int[k*2];
        int arrIndex = 0,  n = cardPoints.length;

        for(int i=n-k; i<n+k;i++) arr[arrIndex++] =  cardPoints[i%n];

        int sum = 0, maxSum = 0, current=0, last =0;

        while(current < 2*k){
            sum += arr[current];
            while(current - last  >= k) sum-=arr[last++];
            if(current - last + 1 == k) maxSum = Math.max(maxSum, sum);

            current++;
        }
        
        return maxSum;
    }


    public int maxScore1(int[] cardPoints, int k) {
        int sum = 0, maxSum = 0,  n = cardPoints.length;
        int start = n-k, end = n+k, index = 0;

        for(int i=start; i<end;i++){
            sum += cardPoints[i%n];
            index += 1;

            if(index > k ) {
                sum -= cardPoints[start % n];
                start++;
            }
            
            if(index >= k) maxSum = Math.max(maxSum, sum);

        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        
    }
}