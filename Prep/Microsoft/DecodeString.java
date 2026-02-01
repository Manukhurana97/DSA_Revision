
import java.util.*;

// given string ab[cd]{2} or ab[cd[ef]{2}]{3}

public class DecodeString {
	
	public String decode(String s) {
		Stack<String> stack = new Stack<>();
		StringBuilder builder = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int count = 0;

		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);

			if(ch == '[') {
				if(count > 0) {
					stack.push(builder.toString());
					builder = new StringBuilder();
				}
				count += 1;

			} else if(ch == ']') {
				stack.push(builder.toString());
				builder = new StringBuilder();
				count -=1;

			} else if(ch == '{') {

				int no = 0, j = i+1;

				while(j < s.length() && s.charAt(j) != '}') {
					no = no*10 + s.charAt(j) - '0';
					j++;
				}
				i = j+1;

				String repeatedStr = stack.pop().repeat(no);
				if(count > 0 && !stack.isEmpty()) {
					stack.push(stack.pop()+ repeatedStr);
				} else{
					result.append(repeatedStr);
				}

			} else {
				if(count > 0) builder.append(ch);
				else result.append(ch);
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		System.out.println(ds.decode("ab[cd]{2}")); // abcdcd
		System.out.println(ds.decode("a[b[c[d[e]{2}]{2}]{2}]{3}")); // abcdeedeecdeedeebcdeedeecdeedeebcdeedeecdeedee
		System.out.println(ds.decode("a[b[c]{2}]{3}")); // abccbccbcc
	}
}