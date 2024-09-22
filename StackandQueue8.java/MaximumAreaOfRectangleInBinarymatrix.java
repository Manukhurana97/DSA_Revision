// https://leetcode.com/problems/maximal-rectangle/description/

import java.util.*;

public class MaximumAreaOfRectangleInBinarymatrix{
	public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        
        int maxHeight = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] arr = new int[n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
                arr[j] = matrix[i][j] == '0' ? 0 : arr[j] + 1;
            }
            maxHeight = Math.max(maxHeight, calculateMaxHeight(arr));
        }

        return maxHeight;
    }

    public int calculateMaxHeight(int[] arr){
    	int maxArea = 0;
        int n = arr.length;
    	Stack<Integer> stack = new Stack<>();

    	for(int i=0;i < n; i++){

    		while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
    			int height = arr[stack.pop()];
    			int width = stack.isEmpty()? i: i - stack.peek() - 1;
    			maxArea = Math.max(maxArea, width * height);
    		}
    		stack.push(i);
        }

        while(!stack.isEmpty()){
            int height = arr[stack.pop()];
            int width = stack.isEmpty()? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, width * height);
        }
    	

    	return maxArea;
    }

    public static void main(String[] args) {
    	
    }
}