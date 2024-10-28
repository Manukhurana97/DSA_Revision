// kadenes algo
public class MaximumSumAubArray{

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int num: nums){
            sum += num;
            sum = Math.max(num, sum);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

}