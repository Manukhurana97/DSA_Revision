// https://leetcode.com/problems/interleaving-string/description/

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int i = s1.length(), j = s2.length(), k = s3.length();

        if(i + j != k) return false;
        if(s1.length() == 0) return s2.equals(s3);
        if(s2.length() == 0) return s1.equals(s3);

        // int[][] dp = new int[i+1][j+1];
        // return recursion(i-1, j-1, k-1, s1, s2, s3);

        // return memoization(i-1, j-1, k-1, s1, s2, s3, dp);

        // return tabulation(s1, s2, s3);

        return spaceOptimization(s1, s2, s3);
    }

    // point to not is i+j == k
    private boolean recursion(int i, int j, int k, String s1, String s2, String s3){
        if(k<0) return true;   
        if (i < 0 && j < 0) return false;     

        if( i >= 0 && s1.charAt(i) == s3.charAt(k)){
            if(recursion(i-1, j, k-1, s1, s2, s3)) return true; // Explore path for s1
        }
        if(j>=0 && s2.charAt(j) == s3.charAt(k)){
            if(recursion(i, j-1, k-1, s1, s2, s3)) return true; // Explore path for s2
        }
        return false;
        
    }

    // since i + j == k, we have only 2d arr dp
    private boolean memoization(int i, int j, int k, String s1, String s2, String s3, int[][] dp){
        if(k<0) return true;   
        if (i < 0 && j < 0) return false;     

        if(dp[i+1][j+1] != 0) return dp[i+1][j+1] == 1;

        if( i >= 0 && s1.charAt(i) == s3.charAt(k)){
            if(memoization(i-1, j, k-1, s1, s2, s3, dp)){ 
                dp[i+1][j+1] = 1;
                return true;} // Explore path for s1
        }
        if(j>=0 && s2.charAt(j) == s3.charAt(k)){
            if(memoization(i, j-1, k-1, s1, s2, s3, dp)){
                dp[i+1][j+1] = 1;
                return true;
            } // Explore path for s2
        }
        dp[i+1][j+1] = 2;
        return  false;
        
    }


    // since i + j == k, we have only 2 loops
    private boolean tabulation(String s1, String s2, String s3){
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        boolean[][] dp = new boolean[n1+1][n2+1];
        dp[0][0] = true;

        for(int i=1; i<=n1; i++){
            dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0];
        }
        for(int i=1; i<=n2; i++){
            dp[0][i] = s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1];
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                boolean fromS1 = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
                boolean fromS2 = s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1];
                dp[i][j] = fromS1 || fromS2;
                
            }
        }
        
        return dp[n1][n2];
    }


    private boolean spaceOptimization(String s1, String s2, String s3){
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        boolean[] prev = new boolean[n2+1];
        prev[0] = true;

        for(int i=1; i<=n2; i++){
            prev[i] = s2.charAt(i-1) == s3.charAt(i-1) && prev[i-1];
        }

        for (int i = 1; i <= n1; i++) {
            boolean[] curr = new boolean[n2+1];
            curr[0] = s1.charAt(i - 1) == s3.charAt(i - 1) && prev[0];
            for (int j = 1; j <= n2; j++) {
                boolean fromS1 = s1.charAt(i - 1) == s3.charAt(i + j - 1) && prev[j];
                boolean fromS2 = s2.charAt(j-1) == s3.charAt(i+j-1) && curr[j-1];
                curr[j] = fromS1 || fromS2;
                
            }
            prev = curr;
        }
        
        return prev[n2];
    }
}