import java.util.*;

public class PrefixToInFix{

	public static String convert(String str){	
		Stack<String> stack = new Stack<>();

		// iterate reverse 
		for(int i=str.length()-1;i>=0;i--){
			if(Character.isLetterOrDigit(str.charAt(i))) stack.push(str.charAt(i)+""); //push: add in stack
			else stack.push("("+stack.pop()+str.charAt(i)+stack.pop()+")"); // pop: operator + operand + operator
		}

		return stack.pop();
	}

	public static int getPrecidence(char ch){
		return switch(ch){
			case '+','-' -> 1;
			case '*','/' -> 2;
			case '^' -> 3;
			default -> -1;
		};
	}

	public static void main(String[] args) {
		String str = "*-A/BC-/AKL";
		System.out.println("((A-(B/C))*((A/K)-L))".equals(convert(str)));
	}
	
}