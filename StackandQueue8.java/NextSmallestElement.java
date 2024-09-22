import java.util.*;

public class NextSmallestElement{
	public static ArrayList<Integer> prevSmaller(int[] A) {
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> result = new ArrayList<>();

		for(int i: A){
			while(!stack.isEmpty() && stack.peek()>i)
				stack.pop();
			
			result.add(stack.isEmpty() ? -1: stack.peek());
			stack.push(i);
		}


		return result;
    }

    public static void main(String[] args) {
    	int[] a = {4, 5, 2, 10, 8};
    	System.out.println(prevSmaller(a));
    	int[] b = {3,2,1};
    	System.out.println(prevSmaller(b));
    }
}