// https://leetcode.com/problems/different-ways-to-add-parentheses

public class DifferentWaysToAddParanthesis{
	Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String s) {
        if(map.containsKey(s)) return map.get(s);

        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(s.substring(0, i));
                List<Integer> right = diffWaysToCompute(s.substring(i+1));

                
                for(int a: left){
                    for(int b: right){
                        int val = 0;
                        if(s.charAt(i) == '+'){
                            val = a+b;
                        }else if(s.charAt(i) == '-') {
                            val = a-b;
                        }else if(s.charAt(i) == '*') {
                            val = a*b;
                        }

                        result.add(val);
                    }
                }
            }
        }
        if(result.isEmpty()) {
            result.add(Integer.parseInt(s));
        }
        map.put(s, result);
        return result;
    }
}