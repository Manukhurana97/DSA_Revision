import java.util.*;

public class PrefixToPostfix{
	public static String convert(String str){
		Stack<String> stack = new Stack<>();

		for(int i = str.length() - 1; i >= 0; i--){
			if(Character.isLetterOrDigit(str.charAt(i))) 
				stack.push(str.charAt(i)+""); //push: add in stack
			else 
				stack.push(stack.pop()+stack.pop()+str.charAt(i)); // pop: operator1 + operand2 + expression
		}


		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(convert("*-A/BC-/AKL"));
		System.out.println(convert("*+AB-CD"));
	}
}