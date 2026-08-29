// https://leetcode.com/problems/is-subsequence/

public class IsSubsequence {

    public boolean isSubsequence(String a, String b) {
        if(a.equals(b) || a.equals("")) return true;

        // int m = a.length(), n =  b.length();
        // if(m > n) return false;
        // Boolean[][] dp = new Boolean[m][n];

        // return recursion(m - 1, n - 1, a, b, dp);

        // return tabulation(a, b);

        return spaceOptimization(a, b);
    }

    public boolean recursion(int i, int j, String a, String b, Boolean[][] dp) {
        if(i < 0) return true;
        if(j < 0) return false;

        if(dp[i][j] != null) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = recursion(i-1, j-1, a, b, dp);
        }

        return dp[i][j] = recursion(i, j-1, a, b, dp);
    }

    public boolean tabulation(String a, String b) {
        int m = a.length(), n =  b.length();
        boolean[][] dp = new boolean[m+1][n+1];

        if(m > n) return false;

        for(int j=0; j<n; j++) {
            dp[0][j] = true;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = dp[i][j-1];
            }
        }

        return dp[m][n];
    }

    public boolean spaceOptimization(String a, String b) {
        int m = a.length(), n =  b.length();
        boolean[] prev = new boolean[n+1];
        if(m > n) return false;

        for(int j=0; j<n; j++) {
            prev[j] = true;
        }

        for(int i=1; i<=m; i++) {
            boolean[] curr = new boolean[n+1];
            
            for(int j=1; j<=n; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    curr[j] = prev[j-1];
                else curr[j] = curr[j-1];
            }
            prev = curr;
        }

        return prev[n];
    }
}