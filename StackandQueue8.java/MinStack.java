// https://leetcode.com/problems/min-stack/

class Node{
    int value;
    int minTillNow;

    Node(int value, int minTillNow) {
        this.value = value;
        this.minTillNow = minTillNow;
    }
}

// Time : O(n), Space: O(2n)
class MinStack {

    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(new Node(val, (stack.isEmpty() ? val : Math.min(stack.peek().minTillNow, val))));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek().value;
    }
    
    public int getMin() {
        if(stack.isEmpty()) return -1;
        return stack.peek().minTillNow;
    }
}


// ------------------------------------------------------------------------------------------


// Time : O(n), Space: O(n)
class MinStack {

    Stack<Long> stack;
    long minTillNow;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push((long)val);
            minTillNow = val;
        }else if(val >= minTillNow) {
            stack.push((long)val);
        }else{
            stack.push(2L * val - minTillNow);
            minTillNow = val;
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;

        long val = stack.pop();
        if(val < minTillNow) { // recover encoded value
            minTillNow = 2 * minTillNow - val;
        }
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;

        long top = stack.peek();
        return (int) ((top < minTillNow) ? minTillNow : top);
    }
    
    public int getMin() {
        if(stack.isEmpty()) return -1;

        return (int) minTillNow;
    }
}

