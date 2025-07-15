import java.util.*;

public class InFixToPostFix{

	public static String convert(String str){
		StringBuilder builder = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		char[] arr = str.toCharArray();


		for(char ch: arr){
			if(Character.isLetterOrDigit(ch))
				builder.append(ch);
			else{
				if(ch == '(') stack.push(ch);
				else if(ch == ')'){
					while(!stack.isEmpty() && stack.peek() !='(') builder.append(stack.pop());
					
					stack.pop();
				}else{
					int currentPrecedence = getPrecidence(ch);
					while(!stack.isEmpty() && getPrecidence(stack.peek()) >= currentPrecedence)
						builder.append(stack.pop());
					
					stack.push(ch);
				}
			}

		}

		while(!stack.isEmpty()) builder.append(stack.pop());

		return builder.toString();
	}

	public static int getPrecidence(char ch){
		return switch(ch){
			case '+','-'-> 1;
			case '*', '/' -> 2;
			case '^' -> 3;
			default -> -1;
		};
				
	}

	public static void main(String[] args) {
		String str = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(convert(str));
	}
}