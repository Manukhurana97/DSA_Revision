// https://leetcode.com/problems/longest-valid-parentheses/

public class LongestValidParanthesis {
    public int longestValidParentheses(String s) {
        int open  = 0, result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(i);
            else{
                stack.pop();
                if(!stack.isEmpty()) {
                    result = Math.max(result, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }

        return result;
    }
}