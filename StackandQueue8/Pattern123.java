// https://leetcode.com/problems/132-pattern/

class Node{
    int min;
    int val;

    Node(int min, int val){
        this.min = min;
        this.val = val;
    }
}
public class Pattern123 {

    // Time : O(N^3)
    // public boolean find132pattern(int[] nums) {
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             for(int k=j+1;k<nums.length;k++){
    //                 if((nums[i] < nums[k]) && (nums[k] < nums[j])){
    //                     return true;
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }


    // Time O(N), Space: O(N)
    public boolean find132pattern(int[] nums) {
       Stack<Node> stack = new Stack<>(); // monotonocally decreasing stack

        int minTillNow = Integer.MAX_VALUE;
        for(int i: nums){
           
            while(!stack.isEmpty() && stack.peek().val < i) stack.pop();
            
            if(!stack.isEmpty() && stack.peek().min < i && i < stack.peek().val ) return true;
            
            minTillNow = Math.min(minTillNow, i);
            stack.push(new Node(minTillNow, i));
        }

        return false;
    }



    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int two = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            if(nums[i] < two) return true; // after 3-2, we are satisfying 1-2


            while(!stack.isEmpty() && stack.peek()<nums[i]){
                two = stack.pop(); // we here we are satisfying 3-2 comdition
            }

            stack.push(nums[i]);
           
        }

        return false;
    }
}