// https://leetcode.com/problems/maximum-subarray-min-product/

public class MaximumSubarrayMinProduct{

	public int maxSumMinProduct(int[] nums) {
        int n=nums.length, maxProduct = 0;

        for(int i=0; i<n; i++){
            int minValue = nums[i], sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                minValue = Math.min(minValue, nums[j]);

                maxProduct = Math.max(maxProduct, sum*minValue);
            }
        }

        return maxProduct;
    }


    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long mod = 1_000_000_007;
        long[] prefixSum = new long[n+1];
        
        for(int i=0; i<n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i])  stack.pop();
            
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i])  stack.pop();
            
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }


        long maxProduct = 0;
        for(int i=0; i<n; i++){
            long sum = prefixSum[right[i]] - prefixSum[left[i]+1];
            maxProduct = Math.max(maxProduct, (sum * nums[i]));
        }

        return (int) (maxProduct % mod);
    }
}