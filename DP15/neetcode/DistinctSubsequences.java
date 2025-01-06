// https://leetcode.com/problems/distinct-subsequences/

public class DistinctSubsequences{
	public int numDistinct(String s, String t) {
        // int n1 = s.length(), n2 = t.length();

        // int[][] dp = new int[n1][n2];
        // for(int[] i: dp) Arrays.fill(i, -1);
        // return recursion(n1-1, n2-1, s, t, dp);

        // return tabulation(s, t);

        return spaceOptimization(s, t);
    }

    public int recursion(int i, int j, String a, String b, int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = recursion(i-1, j-1, a, b, dp) + recursion(i-1, j, a, b, dp);
        }

        return dp[i][j] = recursion(i-1, j, a, b, dp);
    }


    public int tabulation( String a, String b){
        int n1 = a.length(), n2 = b.length();
        int[][] dp = new int[n1+1][n2+1];
        
        for(int i=0; i<=n1; i++) dp[i][0] = 1;

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n1][n2];
    }


    public int spaceOptimization( String a, String b){
        int n1 = a.length(), n2 = b.length();
        int[] prev = new int[n2+1];
        
        for(int i=0; i<=n1; i++) prev[0] = 1;

        for(int i=1; i<=n1; i++){
            int[] curr = new int[n2+1];
            curr[0] = 1;
            for(int j=1; j<=n2; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }

        return prev[n2];
    }
}