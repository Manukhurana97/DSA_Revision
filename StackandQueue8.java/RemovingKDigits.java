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

    // ----------------------------------------------------------------------------------------


	public static String removeKdigits(String num, int k) {
        if(num.length() <= k) return "0";

        Stack<Integer> stack = new Stack<>(); // use monotonically increasing stack
        char[] CharArr = num.toCharArray();

        for(var ch: CharArr){
            int val = ch - '0';
            while(!stack.isEmpty() && stack.peek() >= val && k >= 0){
                k--;
                stack.pop();
            }
            stack.push(val);
        }

        // if still k > 0, remove from last
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) builder.insert(0, stack.pop());
        
        while(builder.length()>0 && builder.charAt(0) == '0') builder.deleteCharAt(0);
    
        return builder.toString().equals("") ? "0" : builder.toString() ;
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 2));
    }
}