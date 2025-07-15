// https://leetcode.com/problems/maximal-rectangle/description/

import java.util.*;

public class MaximumAreaOfRectangleInBinarymatrix{
	ppublic int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, largestRec = 0;
        int[] arr = new int[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                arr[j] = (matrix[i][j] == '0') ? 0 : arr[j]+1; 
            }

            largestRec = Math.max(largestRec, findLargestRectangle(arr));
        }

        return largestRec;
    }

    private int findLargestRectangle(int[] arr){
        int n = arr.length, maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=n; i++){
            int currentheight = i==n ? 0 : arr[i]; 
            while(!stack.isEmpty() && arr[stack.peek()] > currentheight){
                int height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : i-stack.peek()-1;

                maxArea = Math.max(maxArea, width*height);
            }

            stack.push(i);
        }

        return maxArea;
    }
}