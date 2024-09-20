public class GenerateValidParanthesis{
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();

        String s = "";
        for(int i=0;i<n;i++) s+="(";
        for(int i=0;i<n;i++) s+=")";

        generateAllParanthesis(0, 2*n, s, set);

        return new ArrayList<>(set);
    }

    public void generateAllParanthesis(int i, int n, String s, Set<String> result){
        if(i == n){
            if(validParanthesis(s) && !result.contains(s)){
                result.add(s);
                return;
            }
        }

        for(int j=i; j<n; j++){
            s = swap(i, j, s);
            generateAllParanthesis(i+1, n, s, result);
            s = swap(i, j, s);
        }
    }


    public String swap(int from, int to, String s){
        char[] ch = s.toCharArray();

        char temp = ch[from];
        ch[from] = ch[to];
        ch[to] = temp;

        return new String(ch);
    }


    public boolean validParanthesis(String s){
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();

        for(char c: ch){
            if(c == '(') stack.push(c);
            else{
                if(stack.isEmpty() || stack.pop() != '(') return false;
            }
        }

        return stack.isEmpty();
    }
}


   // --------------------------------------------------------------

public class GenerateValidParanthesis{

    public List<String> generateParenthesis(int n) {
        int open = n, close = n;
        List<String> result = new LinkedList<>();

        generateAllParanthesis(0, n, 0, 0, new StringBuilder(), result);

        return result;
    }


    public void generateAllParanthesis(int i, int n, int open, int close, StringBuilder builder, List<String> result){
        if(i == 2*n){
            result.add(builder.toString());
            return;
        }

        if(open<n){
            builder.append("(");
            generateAllParanthesis(i+1, n, open+1, close, builder, result);
            builder.deleteCharAt(i);
        }

        if(close<open){
            builder.append(")");
            generateAllParanthesis(i+1, n, open, close + 1, builder, result);
            builder.deleteCharAt(i);
        }
    }
}
