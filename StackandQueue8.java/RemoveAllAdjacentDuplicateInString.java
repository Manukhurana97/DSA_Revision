// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
import java.util.*;

public class RemoveAllAdjacentDuplicateInString{

	// time : O(N^2/k), Space : O(2N)
	public String removeDuplicates(String s, int k) {
        
        while(true){
            char[] charArr = s.toCharArray();
            int count = 0;
            boolean isDeleted = false;
            Stack<Character> stack = new Stack<>();

            
            for(char ch: charArr){
                if(!stack.isEmpty() && ch == stack.peek()) count++;
                else count = 1;

                stack.push(ch);
                
                if(count == k){
                    while(count-->0 && !stack.isEmpty())
                        stack.pop();
                    isDeleted = true;
                }
            }
           
            if(!isDeleted) return s;
            s = stackToString(stack);
            
        }

    }

    public static String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        
        for (Character ch : stack) {
            sb.append(ch);
        }
        
        return sb.toString();
    }


    // ---------------------------------------------------------------------------


    // time : O(N^2/k), Space : O(N)
    public String removeDuplicates(String s, int k) {
        
        while(true){
            char[] charArr = s.toCharArray();
            int count = 0;
            boolean isDeleted = false;
            StringBuilder stack = new StringBuilder();

            
            for(char ch: charArr){
                if(!stack.isEmpty() && ch == stack.charAt(stack.length() - 1)) count++;
                else count = 1;

                stack.append(ch);
                
                if(count == k){
                    stack.delete(stack.length()-k , stack.length()); // delete from i -> n
                    isDeleted = true;
                }
            }
           
            if(!isDeleted) return s;
            s = stack.toString();
        }
    }


    // ---------------------------------------------------------------------------


    
    public String removeDuplicates(String s, int k) {
       
        while(true){
            StringBuilder builder = new StringBuilder();
            Stack<Integer> stackCount = new Stack<>();
            char[] charArr = s.toCharArray();
            boolean isDeleted = false;
            
            for(char ch: charArr){
                int count = 1;
                if(!builder.isEmpty() && ch == builder.charAt(builder.length() - 1)) 
                    count = stackCount.pop()+1;
                stackCount.push(count);

                builder.append(ch);
                
                if(stackCount.peek() == k){
                    builder.delete(builder.length() - k , builder.length());
                    stackCount.pop();
                    isDeleted = true;
                }
            }
           
            if(!isDeleted) return s;
            s = builder.toString();
        }
    }
}