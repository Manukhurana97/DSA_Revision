public class SumOfSubArrayRange{

	public long subArrayRanges(int[] nums) {
        long totalSum = 0, n = nums.length;
        int noOfSubSet = 1<<n;

        for (int i = 0; i < n; i++){
            int min = nums[i];
            int max = nums[i];
            
           for(int j=i;j<n;j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                totalSum += max - min;
            }
        }

        return totalSum;
    }


    // ----------------------------------------------------------


    public long subArrayRanges(int[] nums) {
        return getSubarraySumMax(nums) - getSubarraySumMin(nums);
    }

    public int getSubarraySumMin(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Get element with smallest index on left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Get element with smallest index on right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) stack.pop();
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum = (totalSum + (long) nums[i] * (next[i] - i) * (i - prev[i])) % MOD;
        }

        return (int) totalSum;
    }

    public int getSubarraySumMax(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Get greater element on left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Get greater element on right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) stack.pop();
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum = (totalSum + (long) nums[i] * (next[i] - i) * (i - prev[i])) % MOD;
        }

        return (int) totalSum;
    }

    
}