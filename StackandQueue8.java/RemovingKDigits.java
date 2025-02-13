// https://leetcode.com/problems/remove-k-digits/description/

import java.util.*;

public class RemovingKDigits{

    public String removeKdigits(String num, int k) {
        
        Stack<Character> stack = new Stack<>();
        char[] arr = num.toCharArray();

        for(var ch: arr){
            while(!stack.isEmpty() && stack.peek() > ch && k>0){
                k-=1;
                stack.pop();
            }
            stack.push(ch);
        }

        // if still k left
        while(k>0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // stack to string
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty())
            builder.append(stack.pop());
        

        builder.reverse(); // reverse the string (stack stored in reverse)

        // remove initial 0
        while(builder.length()>0 && builder.charAt(0)=='0')
            builder.deleteCharAt(0);
        

        
        return builder.length() == 0 ? "0" : builder.toString();

    }


// ------------------------------------------------------------------------------------

    public String removeKdigits(String num, int k) {
        int n  = num.length();

        Deque<Character> stack = new LinkedList<>();

        for(int i=0; i<n; i++){
            char val = num.charAt(i);
            while(k>0 && !stack.isEmpty() && stack.getLast() > val){
                k-=1;
                stack.pollLast();
            }

            stack.addLast(val);
        }

        while(k-->0 && !stack.isEmpty()){
            stack.pollLast();
        }

        /*Because of stack overflow we cant use Integer or long or double*/

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollFirst());
        }
        
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" :  result.toString();
    }



    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 2));
    }
}