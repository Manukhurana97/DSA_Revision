// https://leetcode.com/problems/perfect-squares/

public class PerfactSquare{
	public int numSquares(int n) {
        if(n==1) return 1;

        int[][] dp = new int[n+1][n+1];
        // return recursion((int)Math.sqrt(n), n, dp);

        // return tabulation((int)Math.sqrt(n), n, dp);

        // return spaceOptimization((int)Math.sqrt(n), n);

        return spaceOptimization1((int)Math.sqrt(n), n);
    }

    public int recursion(int n, int target, int[][] dp){
        if(target<0) return Integer.MAX_VALUE;
        if(target==0) return 0;
        if(n == 1) return target;
        
        if(dp[n][target] != 0) return dp[n][target];

        int notTake = recursion(n-1, target, dp);
        int take = (target - n*n >= 0) ? 1 + recursion(n, target-n*n, dp) : Integer.MAX_VALUE;
        
        return dp[n][target] = Math.min(take, notTake);
    }


    public int tabulation(int n, int target, int[][] dp){
        
        for(int t=1; t<=target; t++){
            dp[1][t] = t;
        }
        
        for(int i=2; i<=n; i++){
            for(int t=1; t<=target; t++){
                int notTake = dp[i-1][t];
                int take = (t - i*i >= 0) ? 1 + dp[i][t-i*i] : Integer.MAX_VALUE;
        
                dp[i][t] = Math.min(take, notTake);
            }
        }

        return dp[n][target];
    }


    public int spaceOptimization(int n, int target){
        
        int[] prev = new int[target+1];

         for(int t=1; t<=target; t++){
            prev[t] = t;
        }
        
        for(int i=2; i<=n; i++){
            int[] curr = new int[target+1];
            for(int t=1; t<=target; t++){
                int notTake = prev[t];
                int take = (t - i*i >= 0) ? 1 + curr[t-i*i] : Integer.MAX_VALUE;
        
                curr[t] = Math.min(take, notTake);
            }
            prev = curr;
        }

        return prev[target];
    }


    public int spaceOptimization1(int n, int target){
        
        int[] prev = new int[target+1];

         for(int t=1; t<=target; t++){
            prev[t] = t;
        }
        
        for(int i=1; i*i<=n; i++){
            int square = i*i;
            for(int t=square; t<=target; t++){
                int notTake = prev[t];
                int take = (t - i*i >= 0) ? 1 + prev[t-square] : Integer.MAX_VALUE;
        
                prev[t] = Math.min(take, notTake);
            }
        }

        return prev[target];
    }
}



// -----------------------------------------------------------------

public int numSquares(int n) {
    if (n <= 0) return 0;

    // Queue for BFS
    Queue<Integer> queue = new LinkedList<>();
    queue.add(n);
    int level = 0;

    // Set to track visited numbers
    Set<Integer> visited = new HashSet<>();

    while (!queue.isEmpty()) {
        int size = queue.size();
        level++;

        for (int i = 0; i < size; i++) {
            int curr = queue.poll();

            // Iterate through all possible perfect squares
            for (int j = 1; j * j <= curr; j++) {
                int next = curr - j * j;

                // If we reach zero, return the level
                if (next == 0) return level;

                // If not visited, add to the queue
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
    }

    return level;
}
