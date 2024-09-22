import java.util.*;
public class CheckForBalanceParantheses{
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] ch = s.toCharArray();

        for(var i: ch){
            if(i == '{' || i == '[' || i == '(')
            	stack.push(i);
            else if(!stack.isEmpty())
                switch(i){
                    case '}':
                        if (stack.peek() != '{') return false;
                        stack.pop();
                        break; 

                    case ']':
                        if (stack.peek() != '[') return false;
                        stack.pop();
                        break; 

                    case ')':
                        if (stack.peek() != '(') return false;
                        stack.pop();
                        break; 
            	}
            else  return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
    	String s = "[([])][";

    	System.out.println(isValid(s));
    }
}