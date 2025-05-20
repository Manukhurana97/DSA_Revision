// https://leetcode.com/problems/basic-calculator/

public class SimpleCalculator{
	public int calculate(String s) {
        int number = 0, result = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        char[] chArr = s.toCharArray();

        for(char ch: chArr) {
            if('0'<=ch && ch<='9') {
                number = number * 10 + ch-'0';
            } else if(ch == '+' || ch == '-'){
                result += sign * number;
                sign = ch == '-' ? -1 : 1;
                number = 0;
            } else if(ch == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if(ch ==')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if(number != 0) result += sign * number;
        return result;
    }
}