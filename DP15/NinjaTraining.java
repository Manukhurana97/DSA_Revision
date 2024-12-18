import java.util.*;

public class NinjaTraining{

	private int maxPoints(int[][] grid){
		int n = grid.length;        // Number of days
    	int m = grid[0].length;     // Number of tasks

		// return dfs(n-1, m, grid);

		int[][] dp = new int[n][m + 1];
		for(int[] i: dp){
			Arrays.fill(i, -1);
		}
		// return memoization(n-1, m, grid, dp);

		// return tabulation(n-1, m, grid, dp);

		return spaceOptimization(n, m, grid);
	}

	private int dfs(int day, int prev, int[][] grid){
		if(day < 0) return 0;

		int maxPoints = 0;

		for(int tasks=0; tasks<grid[0].length; tasks++){
			if(tasks != prev){ // no two consecutive days have the same task
				int points = grid[day][tasks] + dfs(day-1, tasks, grid);
				maxPoints = Math.max(maxPoints, points);
			}
		}
		return maxPoints;
	}


	private int memoization(int day, int prev, int[][] grid, int[][] dp){
		if(day < 0) return 0;

		if(dp[day][prev] != -1) return dp[day][prev];

		int maxPoints = 0;

		for(int tasks=0; tasks<grid[0].length; tasks++){
			if(tasks != prev){ // no two consecutive days have the same task
				int points = grid[day][tasks] + memoization(day-1, tasks, grid, dp);
				maxPoints = Math.max(maxPoints, points);
			}
		}
		dp[day][prev] = maxPoints;
		return dp[day][prev];
	}


	private int tabulation(int n, int m, int[][] grid, int[][] dp){

		// for day 0;
		for (int task = 0; task < m; task++) {
	        dp[0][task] = grid[0][task];
	    }

		for(int day=1; day<=n; day++){
			for(int prev = 0; prev<m; prev++){
				dp[day][prev] = 0;
				for(int tasks=0; tasks<m; tasks++){
					if(tasks != prev){ // no two consecutive days have the same task
						dp[day][prev] = Math.max(dp[day][tasks], grid[day][tasks] + dp[day - 1][prev]);
					}
				}

			}
		}

		int maxPoints = 0;
	    for (int task = 0; task < m; task++) {
	        maxPoints = Math.max(maxPoints, dp[n][task]);
	    }
	    return maxPoints;
	}

	private int spaceOptimization(int n, int m, int[][] grid){
		int[] dp = new int[m+1];
		for (int task = 0; task < m; task++) {
	        dp[task] = grid[0][task];
	    }

		for(int day=1; day<n; day++){
			int[] current = new int[m+1];
			for(int prev = 0; prev<m; prev++){
				current[prev] = 0;
				for(int tasks=0; tasks<m; tasks++){
					if(tasks != prev){ // no two consecutive days have the same task
						current[prev] = Math.max(dp[tasks], grid[day][tasks] + dp[prev]);
					}
				}
			}
			dp=current;

		}

		int maxPoints = 0;
	    for (int task = 0; task < m; task++) {
	        maxPoints = Math.max(maxPoints, dp[task]);
	    }
	    return maxPoints;
	}


	public static void main(String[] args) {
		NinjaTraining obj = new NinjaTraining();

		int[][] arr = {
			{10, 50, 11}, 
			{20, 100, 1}
		};
		System.out.println(obj.maxPoints(arr));
	}
}