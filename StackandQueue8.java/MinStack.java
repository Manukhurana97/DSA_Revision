class Node{
    int value;
    int minTillNow;

    Node(int value, int minTillNow){
        this.value = value;
        this.minTillNow = minTillNow;
    }
}

public class MinStack {

    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push();
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek().value;
    }   
    
    public int getMin() {
        return stack.isEmpty() ? -1 : stack.peek().minTillNow;
    }
}