// https://leetcode.com/problems/target-sum/

public class targetSum {
    public int findTargetSumWays(int[] arr, int d) {

        // return recursion(arr.length-1, 0, d, arr);
    
        int sum = 0;
        for(int i: arr) sum+=i;
        if(Math.abs(d) > sum) return 0;

        int[][] dp = new int[arr.length][2*sum+1];
        for(int[] i: dp) Arrays.fill(i, 0);
        
        // return memoiztion(arr.length-1, d, arr, sum, dp);

        // return tabulation(d, arr, sum , dp);

        return spaceOptimize(d, arr, sum);
    }
    
    private int recursion(int i, int sum, int target, int[] arr){

        if(i<0) 
            return target == sum ? 1: 0; 

        int pos = recursion(i-1, sum+arr[i], target, arr);
        int neg = recursion(i-1, sum-arr[i], target, arr);

        return pos + neg;
    }


    private int memoiztion(int i, int target, int[] arr, int sum, int[][] dp){
        if(i<0) 
            return target == 0 ? 1 : 0;

        int index = sum + target;
        if(index<0 || index>=2*sum+1) return 0;

        if(dp[i][sum+target] != 0) return dp[i][sum+target];

        int pos = memoiztion(i-1, target+arr[i], arr, sum, dp);
        int neg = memoiztion(i-1, target-arr[i], arr, sum, dp);

        return dp[i][sum+target] = pos + neg;
    }


    private int tabulation(int d, int[] arr, int sum, int[][] dp){
        dp[0][sum + arr[0]] = 1;
        dp[0][sum - arr[0]] += 1;

        for(int i=1; i<arr.length; i++){
            for (int target = -sum; target <= sum; target++) {
                int index = sum + target;
                if(index<0 || index>=2*sum+1) continue;
                
                int pos = (index + arr[i] < 2 * sum + 1) ? dp[i - 1][index + arr[i]] : 0;
                int neg = (index - arr[i] >= 0) ? dp[i - 1][index - arr[i]] : 0;

                dp[i][index] = pos + neg;
                
            }
        }

        return dp[arr.length-1][sum+d];
    }


    private int spaceOptimize(int d, int[] arr, int sum){
        int[] prev = new int[2*sum+1];

        prev[sum + arr[0]] = 1;
        prev[sum - arr[0]] += 1;

        for(int i=1; i<arr.length; i++){
            int[] curr = new int[2*sum+1];
            for (int target = -sum; target <= sum; target++) {
                int index = sum + target;
                if(index<0 || index>=2*sum+1) continue;
                
                int pos = (index + arr[i] < 2 * sum + 1) ? prev[index + arr[i]] : 0;
                int neg = (index - arr[i] >= 0) ? prev[index - arr[i]] : 0;

                curr[index] = pos + neg;
                
            }
            prev = curr;
        }

        return prev[sum+d];
    }

    
}