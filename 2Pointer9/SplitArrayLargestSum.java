// https://leetcode.com/problems/split-array-largest-sum/

public class SplitArrayLargestSum{
	public int splitArray(int[] nums, int k) {
        if(nums.length < k) return -1;

        int n = nums.length, minSum = 0, maxSum = 0;

        for (int i : nums) {
            minSum = Math.max(minSum, i);
            maxSum += i;
        }

        if(k == 1) return maxSum;
        
        int result = 0;
        while(minSum <= maxSum){
            
            int mid = minSum + (maxSum - minSum) / 2;
            if(canSplitInSubset(mid, nums) <= k){
                result = mid;
                maxSum = mid-1;
            }else{
                minSum = mid+1;
            }
        }

        return result;
    }


    private int canSplitInSubset(int maxSum, int[] arr){
        int sum = 0, k = 1;

        for(int i : arr){
            if(sum + i > maxSum){
                sum = i;
                k+=1;
            }else sum += i;
        }

        return k;

    }
}