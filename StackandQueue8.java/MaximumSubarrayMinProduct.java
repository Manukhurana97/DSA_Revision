public class MaximumSubarrayMinProduct{

	public int maxSumMinProduct(int[] nums) {
        int n = nums.length;

        long maxSum = 0;
        final int MOD = 1_000_000_007;

        for(int i = 0; i < n; i++){
            long min = Integer.MAX_VALUE;
            long sum = 0;
            
            for(int j = i; j < n; j++){
                min = Math.min(min, nums[j]);
                sum += nums[j]; 

                maxSum = Math.max(maxSum, (sum*min) % MOD);
            }
            
        }
        return (int)(maxSum);
    }


    public int maxSumMinProduct(int[] nums){
        int n =  nums.length();
        int[] prefixSum = new int[n+1];
        
        for(int i = 0; i < n; i++)
            prefixSum[i+1] = prefixSum[i] + nums[i];
        

        
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && stack.peek(nums[i]>=nums[i])){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=n; i<=0; i--){
            while(!stack.isEmpty() && stack.peek(nums[i]>=nums[i])){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sum = 0;
        for(int i = 0; i < n; i++){
            sum = Math.max(sum, (prefixSum[right[i]] - prefixSum[left[i]] + 1))
        }


        return (int) sum % 1_000_000_007;


    }
}