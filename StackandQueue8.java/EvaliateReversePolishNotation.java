public class EvaliateReversePolishNotation{

	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = Set.of("+", "-", "/", "*");

        for(String s: tokens){
            if(set.contains(s) && stack.size()>=2) arithmeticOperations(s, stack);
            else stack.push(Integer.parseInt(s));
        }

        return stack.pop();
    }

    public Stack<Integer> arithmeticOperations(String operation, Stack<Integer> stack){
        int a = stack.pop();
        int b = stack.pop();
        switch(operation){
            case "+":
                stack.push(b+a);
                break;
            case "-":
                stack.push(b-a);
                break;
            case "*":
                stack.push(b*a);
                break;
            case "/":
                stack.push(b/a);
                break;
        }

        return stack;
    }
}