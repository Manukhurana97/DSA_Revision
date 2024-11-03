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
        

        int[] result = new int[queries];
        for (int i = 0; i < queries; i++) {
            int index = indices[i];
            result[i] = map.getOrDefault(index, 0);
        }
        
        return result;
     
  }
	
}