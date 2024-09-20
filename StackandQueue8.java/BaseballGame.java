public class BaseballGame{
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        
        for(String oper: operations) {
            stack = performSpecialOperation(oper, stack);
        }

        int result = 0;
        while(!stack.isEmpty()) result += stack.pop();

        return result;
    }


    public Stack<Integer> performSpecialOperation(String operation, Stack<Integer> stack){
        switch(operation){
            case "+":
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a+b);
                break;
            case "C":
                stack.pop();
                break;
            case "D":
                stack.push(stack.peek() * 2);
                break;
            default: 
                stack.push(Integer.parseInt(operation));
                break;
        }
        return stack;
    }
    
}