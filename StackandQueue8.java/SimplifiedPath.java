public class SimplifiedPath{
	public String simplifyPath(String path) {
        
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();

        for(var str: arr){
            if(str.equals(".") || str.isEmpty()) continue;
            else if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else stack.push(str);
        }

        if(stack.isEmpty()) return "/";

        StringBuilder result = new StringBuilder();
        for(int i=0;i<stack.size();i++){
            result.append("/").append(stack.get(i));
        }

        return result;
    }
}