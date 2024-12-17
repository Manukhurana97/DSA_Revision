import java.util.*;


public class FrogJump{

	public int findMinJump(int n, int[] heights){

		// return dfs(n-1, heights);
		
		int[] visited = new int[n+1];
		Arrays.fill(visited, -1);
		// return memoization(n-1, heights, visited);

		// return tabulation(n-1, heights, visited);
		return spaceOptimization(n-1, heights);
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

		if (visited[n] != -1) return visited[n];

		int n1 = memoization(n-1, heights, visited) + Math.abs(heights[n-1] - heights[n]); 
		int n2 = (n - 2 >= 0) ? memoization(n - 2, heights, visited) + Math.abs(heights[n - 2] - heights[n]) : Integer.MAX_VALUE;

		
		visited[n] = Math.min(n1, n2);;
		return visited[n];

	}

	public int tabulation(int n, int[] heights, int[] visited){
		if(n == 0) return 0;
		visited[0] = 0;

		for(int i=1; i<=n; i++){
			int n1 = visited[i - 1] + Math.abs(heights[i - 1] - heights[i]); 
			int n2 = (i-2 >=0) ?visited[i-2] +  Math.abs(heights[i-2] - heights[i]) : Integer.MAX_VALUE;

			visited[i] = Math.min(n1, n2);
		}

		return visited[n];
	}


	public int spaceOptimization(int n, int[] heights){
		if(n == 0) return 0;
		int prev1 = 0;
		int prev2 = 0;

		for(int i=1; i<=n; i++){
			int n1 = prev1 + Math.abs(heights[i - 1] - heights[i]); 
			int n2 = (i-2 >=0) ? prev2 +  Math.abs(heights[i-2] - heights[i]) : Integer.MAX_VALUE;

			int curr = Math.min(n1, n2);
			prev2 = prev1;
			prev1 = curr;
		}

		return prev1;
	}

	// -----------------------------------------------------------------------------------------------------------------------------
	// followup, k distance

	public int findMinJumpWithKDistance(int n, int k, int[] heights){

		// return dfs1(n-1, k, heights);
		int[] visited = new int[n+1];
		Arrays.fill(visited, -1);

		// return memoization1(n-1, k, heights, visited);

		return tabulation1(n-1, k, heights, visited);
	}

	// Time: O(n^2) , Space O(n)
	public int dfs1(int n, int k, int[] heights){
		if(n<0) return Integer.MAX_VALUE;
		if(n == 0) return 0;

		int minValue = Integer.MAX_VALUE;
		for(int i=1; i<=k; i++){
			if(n-i >=0){
				int cost = dfs1(n-i, k, heights) +  Math.abs(heights[n-i] - heights[n]);
				 minValue = Math.min(minValue, cost);
			}
		}
		return minValue;

	}

	// Time: O(n^2) , Space O(n)
	public int memoization1(int n, int k, int[] heights, int[] visited){
		if(n<0) return Integer.MAX_VALUE;
		if(n == 0) return 0;

		if(visited[n] !=-1) return visited[n];

		int minValue = Integer.MAX_VALUE;
		for(int i=1; i<=k; i++){
			if(n-i >=0){
				int cost = memoization1(n-i, k, heights, visited) +  Math.abs(heights[n-i] - heights[n]);
				 minValue = Math.min(minValue, cost);
			}
		}
		visited[n] = minValue;
		return minValue;
	}


	public int tabulation1(int n, int k, int[] heights, int[] visited){
		if(n==0) return 0;
		visited[0] = 0;

		for(int j=1; j<=n; j++){
			int minValue = Integer.MAX_VALUE;
			for(int i=1; i<=k; i++){
				if(j-i >=0){
					int cost = visited[j-i] + Math.abs(heights[j-i] - heights[j]);
					 minValue = Math.min(minValue, cost);
				}
			}
			visited[j] = minValue;
		}

		return visited[n];
	}


	public static void main(String[] args) {
		FrogJump obj = new FrogJump();

		int[] arr = {30, 10, 60, 10, 60, 50};
		System.out.println(obj.findMinJump(arr.length, arr));
		System.out.println(obj.findMinJumpWithKDistance(arr.length, 3, arr));
	}


}