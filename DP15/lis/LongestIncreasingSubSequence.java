import java.util.*;

public class LongestIncreasingSubSequence{

	public int longestIncSubSequence(int[] nums) {
        int n = nums.length;
        // return recursion(0, -1, nums);

        int[][] memo = new int[n+1][n+1];
        for(int[] dp: memo)
            Arrays.fill(dp, 0);
        // return memoization(0, -1, nums, memo);

        // return tabulation(nums, memo);

        return spaceOptimization1(nums);
    }

    private int recursion(int i, int prev, int[] nums){
        if(i == nums.length) return 0;

        int notTake = recursion(i+1, prev, nums);
        int take = (prev == -1 || nums[prev] < nums[i]) ? 1 + recursion(i+1, i, nums) : 0;

        return Math.max(take , notTake);
    }


    private int memoization(int i, int prev, int[] nums, int[][] dp){
        if(i == nums.length) return 0;

        if(dp[i][prev+1] != 0) return dp[i][prev+1];

        int notTake = memoization(i+1, prev, nums, dp);
        int take = (prev == -1 || nums[prev] < nums[i]) ? 1 + memoization(i+1, i, nums, dp) : 0;

        return dp[i][prev+1] = Math.max(take , notTake);
    }

    private int tabulation(int[] nums, int[][] dp){
        int n = nums.length;

        List<Integer> lis = new ArrayList<>();
        
        for(int i=n-1; i>=0; i--){
            for(int prev = i; prev>=-1; prev--){
                int notTake = dp[i+1][prev+1];
                int take = (prev == -1 || nums[prev] < nums[i]) ? 1 + dp[i+1][i+1] : 0;

                dp[i][prev+1] = Math.max(take , notTake);
            }
        }


        return dp[0][0];
    }


    private int spaceOptimization(int[] nums){
        int n = nums.length;

        int[] ahread = new int[n+1];
        
        for(int i=n-1; i>=0; i--){
            int[] curr = new int[n+1];
            for(int prev = i; prev>=-1; prev--){
                int notTake = ahread[prev+1];
                int take = (prev == -1 || nums[prev] < nums[i]) ? 1 + ahread[i+1] : 0;

                curr[prev+1] = Math.max(take , notTake);
            }
            ahread = curr;
        }

        return ahread[0];
    }


    private int spaceOptimization1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; 

        int[] ahead = new int[n];
        int[] parent = new int[n];

        Arrays.fill(ahead, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int lastIndex = 0;
        
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && ahead[prev] + 1 > ahead[i]) {
                    ahead[i] = 1 + ahead[prev];
                    parent[i] = prev;
                }
            }

            if (ahead[i] > maxLen) {
                maxLen = ahead[i];
                lastIndex = i;
            }
        }

        // Reconstruction
        List<Integer> result = new ArrayList<>();
        int temp = lastIndex; 
        while (temp != -1) {
            result.add(nums[temp]);
            temp = parent[temp];
        }

        Collections.reverse(result);
        System.out.println("Longest Increasing Subsequence: " + result);

        return maxLen;
    }



	public static void main(String[] args) {
		LongestIncreasingSubSequence obj = new LongestIncreasingSubSequence();
		int[] arr = {10, 9, 2, 5, 3, 7,101, 102, 103, 104, 17,18,19};
		System.out.println(obj.longestIncSubSequence(arr));
	}
}