import java.util.*;

public class LargestRectangleInHistogram{
	
    // largest on left and right * currentHeight
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for(int i=0; i<n; i++){
            var leftMin = i;
            var rightMin = i;
            for(int left  = i; left >= 0; left--){
                if(heights[left]<heights[i]) break;
                leftMin-=1;
            }

            for(int right = i; right<n; right++){
                if(heights[right]<heights[i]) break;
                rightMin+=1;
            }

            maxArea = Math.max(maxArea, (rightMin - leftMin - 1) * heights[i]);
        }

        return maxArea;
    }


// create 2 array to store min on left and right
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        Stack<Integer> stack = new Stack<>();

        // compute left min
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                stack.pop();
            }

            leftMin[i] = stack.isEmpty() ? -1: stack.peek();
            stack.add(i);
           
        }

        stack.clear();


        // compute right min
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                stack.pop();
            }

            rightMin[i] = stack.isEmpty() ? n: stack.peek();
            stack.add(i);
           
        }

        
        // compute largest rectangle
        int maxArea = 0;
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, (rightMin[i] - leftMin[i] - 1) * heights[i]);
        }

        return maxArea;
    }


// monotonically increasing stack 
    public int largestRectangleArea3(int[] heights) {
        
        int maxArea = 0;
        int n = heights.length;
        
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=n; i++){
            int currentHeight = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek(); // currentIndex - prevIndex - 1
                maxArea = Math.max(maxArea,  width * height);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        System.out.println(obj.largestRectangleArea3(heights));
    }
}