// https://leetcode.com/problems/decode-string/

public class DecodeString {
	public String decodeString(String s) {
        int i = 0;  
        Stack<Integer> noStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        StringBuilder result = new StringBuilder();

        while(i<s.length()){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
                int no = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))) {
                    no = no * 10 + s.charAt(i) - '0';
                    i++;
                }
                noStack.push(no);
            
            } else if(ch == '[') {
                charStack.push(result.toString());
                result = new StringBuilder();
                i++;

            } else if(ch == ']') {
                String str = charStack.pop();
                str += result.toString().repeat(noStack.pop());

                result = new StringBuilder();
                result.append(str);
                i++;
                
            } else {
                result.append(ch);
                i++;
            }
        }

        return result.toString();
    }
}