import java.util.*;

public class maximumSumOfNonAdjacentElement{

	public int maximumNonAdjacentSum(int[] nums){
		return dfs(nums.length-1, nums);

		// int[] visited = new int[nums.length + 1];
		// Arrays.fill(visited, -1);
		// return memoization(nums.length-1, nums, visited);

		// return tabulation(nums.length-1, nums, visited);

		// return spaceOptimization(nums.length-1, nums);
	}

	public int dfs(int n, int[] nums){
		if(n == 0) return nums[n];
		if(n < 0) return 0;

		int take = nums[n] + dfs(n-2, nums); // taking current 
		int notTake = dfs(n-1, nums); // not taking current

		return Math.max(take, notTake);
	}


	public int memoization(int n, int[] nums, int[] visited){
		if(n < 0) return 0;
		if(n == 0) return nums[n];
		
		if(visited[n] != -1) return visited[n];

		int take = nums[n] + memoization(n - 2, nums, visited); // taking current 
		int notTake = memoization(n - 1, nums, visited); // not taking current

		visited[n] =  Math.max(take, notTake);
		return visited[n];
	}


	public int tabulation(int n, int[] nums, int[] visited){
		if(n == 0 ) return nums[0];
		visited[0] = nums[0];

		for(int i=1; i<=n; i++){
			int take = nums[i] + (i - 2 >= 0  ? visited[i - 2] : 0); // taking current 
			int notTake = visited[i - 1]; // not taking current
			visited[i] = Math.max(take, notTake);
		}

		return visited[n];

	}



	public int spaceOptimization(int n, int[] nums){
		if(n == 0 ) return nums[0];
		int prev2 = 0, prev1 = Math.max(0, nums[0]);

		for(int i=1; i<=n; i++){
			int current = Math.max(nums[i] + prev2, prev1);
			prev2 = prev1;
			prev1 = current;
		}

		return prev1;

	}

	public static void main(String[] args) {
		maximumSumOfNonAdjacentElement obj = new maximumSumOfNonAdjacentElement();

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(obj.maximumNonAdjacentSum(arr));

		int[] arr1 = {2, 1, 4, 9};
		System.out.println(obj.maximumNonAdjacentSum(arr1));
	}
}