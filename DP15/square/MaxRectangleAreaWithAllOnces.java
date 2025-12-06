// https://leetcode.com/problems/maximal-rectangle/

import java.util.*;

public class MaxRectangleAreaWithAllOnces{
	private int maxAreaOfSubMatrixOfAll(int[][] matrix){
		int n = matrix.length;
		int[] arr = new int[n];

		int maxArea = 0;
		for(int i =0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[j] = (matrix[i][j] == 0) ? 0 : arr[j]+1;
			}

			maxArea = Math.max(maxArea, getMaxArea(arr));
		}

		return maxArea;
	}	


	private int getMaxArea(int[] arr){
		int n = arr.length, maxArea = 0;
		Stack<Integer> stack = new Stack<>(); // monotonically increasing stack

		for(int i=0; i<=n; i++){ // to remove the last element from stack we are going till n
			int currentHeight = i==n ? 0 : arr[i]; // all elements are greater the 0, to remove the last element from queue we make last height as 0;
			while(!stack.isEmpty() && arr[stack.peek()]>=currentHeight){
				int height = arr[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek()-1;

				maxArea = Math.max(maxArea, width * height);
			}
			stack.push(i);
		}

		return maxArea;
	}
    

	public static void main(String[] args) {
		MaxRectangleAreaWithAllOnces obj = new MaxRectangleAreaWithAllOnces();
		int[][] arr = {
			{1,0,0,0},
			{1,1,1,1},
			{0,1,1,1},
			{1,0,0,1}
		};
		System.out.println(obj.maxAreaOfSubMatrixOfAll(arr));
	}

}