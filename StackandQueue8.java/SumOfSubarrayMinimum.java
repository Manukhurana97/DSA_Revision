public class SumOfSubarrayMinimum{
	public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for(int i=0;i<n;i++){
            int s = arr[i];
            for(int j=i; j<n;j++){
                s = Math.min(s, arr[j]);
                totalSum+=s;
            }
        }
        
        
        return totalSum;
    }



    // ------------------------------------------------------------------------------------

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        long totalSum = 0;

        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Monotonic stack for previous less elements on both left and right

        // get element with smallest index on left
        for(int i = 0;i<n;i++){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            
            prev[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i); 
        }

        stack.clear();

        // get element with smallest index on right
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) stack.pop();
            
            next[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i); 
        }
        

        for(int i=0;i<n;i++){
            long leftCount = i - prev[i];
            long rightCount = next[i] - i;
            totalSum = (totalSum + arr[i] * leftCount * rightCount) % MOD;
        }
        
        return (int)totalSum;
    }
}