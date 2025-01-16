// https://leetcode.com/problems/unique-binary-search-trees/description/

public class UniqueNumberOfBinaryTrees{
    // n = 4 : (left : 0, right : 3 + left : 1, right : 2, left : 2: 1 ... )
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);

        //  root node
        for(int i=1; i<=n; i++){
            int total = 0;
            for(int j=1; j<=i; j++){
                int left = j-1; // no of nodes on left
                int right = i-j; // no of nodes on right
                total += dp[left] * dp[right];
            }

            dp[i] = total;
        }

        return dp[n];
    }
}