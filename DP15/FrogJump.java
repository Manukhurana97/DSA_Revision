import java.util.*;


public class FrogJump{

	public int findMinJump(int n, int[] heights){

		// return dfs(n-1, heights);
		
		int[] visited = new int[n+1];
		Arrays.fill(visited, -1);
		return memoization(n-1, heights, visited);
	}


	// Time: O(n^2) , Space O(n)
	public int dfs(int n,  int[] heights){
		if(n<0) return Integer.MAX_VALUE;
		if(n == 0) return 0;


		int n1 = dfs(n-1, heights) + Math.abs(heights[n-1] - heights[n]); 
		int n2 = Integer.MAX_VALUE;
		if(n-2 >=0){
			 n2 = dfs(n-2, heights) +  Math.abs(heights[n-2] - heights[n]);
		}
		return Math.min(n1, n2);

	}

	// Time: O(n) , Space O(n+n {recursion space})
	public int memoization(int n,  int[] heights, int[] visited){
		if(n<0) return Integer.MAX_VALUE;
		if(n == 0) return 0;

		if(visited[n] > -1) return visited[n];

		int n1 = dfs(n-1, heights) + Math.abs(heights[n-1] - heights[n]); 
		int n2 = (n-2 >=0) ? dfs(n-2, heights) +  Math.abs(heights[n-2] - heights[n]) : Integer.MAX_VALUE;
		
		int minVal =  Math.min(n1, n2);
		visited[n] = minVal;
		return minVal;

	}

	public static void main(String[] args) {
		FrogJump obj = new FrogJump();

		int[] arr = {30, 10, 60, 10, 60, 50};
		System.out.println(obj.findMinJump(arr.length, arr));
	}


}