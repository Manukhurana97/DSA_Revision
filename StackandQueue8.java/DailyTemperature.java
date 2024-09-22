public class DailyTemperature{

	public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        

        for(int i=n-1; i>=0;i--){
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]) var top = stack.pop();
            
            arr[i] = stack.isEmpty() ? 0: stack.peek() - i; // temp after n days
            stack.push(i);

        }

        return arr;
    }
}