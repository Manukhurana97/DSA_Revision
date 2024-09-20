public class SimplifyPath{
	 public String simplifyPath(String path) {
        
        String s = "";
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for(String part: parts){
            
            if (part.equals("") || part.equals(".")) continue;
            else if(part.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(part);
        }


        String result = "";
        while(!stack.isEmpty()){
            result = "/" +stack.pop() +result;
        }

        return result.equals("") ? "/": result;
        
    }
}