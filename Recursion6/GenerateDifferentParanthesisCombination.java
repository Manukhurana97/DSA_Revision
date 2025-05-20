import java.util.*;

public class GenerateDifferentParanthesisCombination{

	static Map<String, List<String>> map = new HashMap<>();

	public static List<String> diffWaysToParenthesize(String expression) {
		if(map.containsKey(expression)) {
			return map.get(expression);
		}

		List<String> result = new ArrayList();

		for(int i=0; i<expression.length(); i++){
			char ch = expression.charAt(i);

			if(ch == '+' || ch == '-' || ch == '*'){
				List<String> left = diffWaysToParenthesize(expression.substring(0, i));
				List<String> right = diffWaysToParenthesize(expression.substring(i+1));

				for(var a: left) {
					for(var b: right) {
						result.add("("+ a + ch + b +")");
					}
				}
			}
		}

		if (result.isEmpty()) {
            result.add(expression);
        }

		map.put(expression, result);
        return result;

	}

	public static void main(String[] args) {
		String expr1 = "2-1-1";
		List<String> output1 = diffWaysToParenthesize(expr1);
        System.out.println("Input: " + expr1);
        System.out.println("Output: " + output1);

        String expr2 = "2*3-4*5";
        List<String> output2 = diffWaysToParenthesize(expr2);
        System.out.println("Input: " + expr2);
        System.out.println("Output: " + output2);
	}
}