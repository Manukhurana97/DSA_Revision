// https://leetcode.com/problems/sum-of-subarray-minimums/
import java.util.*;

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

    public int sumSubarrayMins1(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        long totalSum = 0;

        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Monotonic increasing stack for previous less elements on both left and right

        // get element with smallest index on left
        for(int i = 0;i<n;i++){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            
            prev[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i); 
        }

        stack.clear();

        // get element with smallest index on right
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
            
            next[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i); 
        }
        

        for(int i=0;i<n;i++){
            long leftCount = i - prev[i];
            long rightCount = next[i] - i;
            totalSum += (arr[i] * leftCount * rightCount) % MOD;
        }
        
        return (int)totalSum;
    }

    public static void main(String[] args) {
        SumOfSubarrayMinimum obj = new SumOfSubarrayMinimum();
        int[] arr = {3,1,2,4};
        System.out.println(obj.sumSubarrayMins1(arr));
    }
}