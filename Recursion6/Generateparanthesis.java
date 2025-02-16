// https://leetcode.com/problems/generate-parentheses/

public class Generateparanthesis{
     public List<String> generateParenthesis(int n) {
        StringBuilder builder =  new StringBuilder();
        List<String> result = new ArrayList<>();
        
        generate(0, 0, 0, n, builder, result);
        
        return result;
    }

    public void generate(int i, int open, int close, int n, StringBuilder builder, List<String> result){
        if(i == 2*n){
            result.add(builder.toString());
            return;
        }

        if(open<n){
            builder.append("(");
            generate(i+1, open+1, close, n, builder, result);
            builder.deleteCharAt(i);
        }

        if(close<open){
            builder.append(")");
            generate(i+1, open, close+1, n, builder, result);
            builder.deleteCharAt(i);
        }
    }
}