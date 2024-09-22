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
}