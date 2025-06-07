import java.util.*;

public class NGEsOnRight{

	public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = N - 1; i >= 0; i--){
            int val = arr[i];
            
            while (!stack.isEmpty() && stack.peek() <= val) stack.pop();
            
            map.put(i, stack.size());
            stack.push(val);
        }

        System.out.println(map);
        

        int[] result = new int[queries];
        for (int i = 0; i < queries; i++) {
            int index = indices[i];
            result[i] = map.getOrDefault(index, 0);
        }
        
        return result;
  }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, -2, 7, 10};
        int N = arr.length;

        int[] indices = {0, 1, 2, 3, 4, 5};
        int queries = indices.length;

        int[] result = NGEsOnRight.count_NGEs(N, arr, queries, indices);

        System.out.println("Result:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
	
}