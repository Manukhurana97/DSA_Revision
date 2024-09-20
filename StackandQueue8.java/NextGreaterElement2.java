public class NextGreaterElement2{
	public int[] nextGreaterElements(int[] nums) {
        // double the list and get next greater element
        // 1 2 3 4 3 1 2 3 4 3

        int n = nums.length;

        if(n == 1) return new int[]{-1};

        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--) stack.push(nums[i]);

        int[] result = new int[n];

        for(int i=n-1;i>=0;i--){
            int val = nums[i];
            while(!stack.isEmpty() && stack.peek()<=val){
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(val);
        }

        return result;
    }
}