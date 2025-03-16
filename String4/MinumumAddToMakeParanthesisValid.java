// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

public class MinumumAddToMakeParanthesisValid {

	public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if (ch == '(') {
                stack.push('(');
            }else{
                if(!stack.isEmpty() && stack.peek() =='(') stack.pop();
                else stack.push(')');
            }
        }

        return stack.size();
    }


// --------------------------------------------------------------------------------------


    public int minAddToMakeValid(String s) {
        int bracket = 0, insertion = 0;

        for(char ch: s.toCharArray()) {
            if(ch =='(') bracket +=1;
            else {
                if(bracket > 0) bracket -= 1;
                else insertion+=1;
            }
        }
        if (bracket > 0) {
            insertion += bracket;
        }
        return insertion;
    }
}