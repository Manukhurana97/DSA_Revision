public class RemoveDuplicateElement{
	public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        while(true){
            char[] chArr = s.toCharArray();
            int count = 0;
            boolean isDeleted = false;
            
            for(var ch: chArr){
                if(!stack.isEmpty() && stack.peek() == ch){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }

            if(s.length() == stack.size()) return s;
            s = stackToString(stack);
            
        }
    }
}