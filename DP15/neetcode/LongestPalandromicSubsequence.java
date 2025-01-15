// https://leetcode.com/problems/longest-palindromic-subsequence/

public class LongestPalandromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        StringBuilder builder = new StringBuilder();
        builder.append(s);

        int[][] dp = new int[n+1][n+1];

        // return recursion(n-1, n-1, s, builder.reverse().toString(), dp);

        // return tabulation(s, builder.reverse().toString(), dp);

        return spaceOptimization1(s, builder.reverse().toString());
    }


    private int recursion(int i, int j, String s1, String s2, int[][] dp){
        if( i<0 || j<0) return 0;

        if(dp[i][j]!=0) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + recursion(i-1, j-1, s1, s2, dp);
        }
        return dp[i][j] = Math.max(recursion(i-1, j, s1, s2, dp), recursion(i, j-1, s1, s2, dp));
    }


    private int tabulation(String s1, String s2, int[][] dp){
        int n1 = s1.length(), n2 = s2.length();
        dp[0][0] = 0;

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n1][n2];
    }


    private int spaceOptimization(String s1, String s2){
        int n1 = s1.length(), n2 = s2.length();

        int[] prev = new int[n2+1];

        for(int i=1; i<=n1; i++){
            int[] curr = new int[n2+1];
            for(int j=1; j<=n2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }

            prev = curr;
        }
        
        return prev[n2];
    }
}