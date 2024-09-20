public class MinStack {

    // class Node{
    //     int val;
    //     int min;

    //     Node(int min, int val){
    //         this.val = val;
    //         this.min = min;
    //     }
    // }

    // int min = Integer.MAX_VALUE;
    // Stack<Node> stack;

    // public MinStack() {
    //     stack = new Stack<>();
    // }
    
    // public void push(int val) {
    //     min = Math.min(min, val);
    //     stack.push(new Node(min, val));
    // }
    
    // public void pop() {
    //     Node node = stack.pop();

    //     if (min == node.min){
    //         min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek().min;
    //     }
    // }
    
    // public int top() {
    //     return stack.peek().val;
    // }
    
    // public int getMin() {
    //     return stack.peek().min;
    // }




    // ------------------------------------------------------------------



    Long min = Long.MAX_VALUE;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    
    public void push(int val) {
       Long v = Long.valueOf(val);

       if(stack.isEmpty()){
            min = v;
            stack.push(v);
       }else if(min < val){
            stack.push(v);
       }else{
            stack.push(2*v - min);
            min = v;
       }
        
    }
    
    public void pop() {
        if(stack.isEmpty()) return;

        Long val = stack.pop();

        if(val < min){
            min = 2 * min - val;
        }
    }
    
    public int top() {
        var val =  (stack.peek()<min) ? min : stack.peek();

        return val.intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}
