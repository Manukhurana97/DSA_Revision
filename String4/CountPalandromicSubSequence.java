// https://www.geeksforgeeks.org/problems/count-palindromic-subsequences/1
public class CountPalandromicSubSequence{
    public int countPS(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        
        return recursion(0, n-1, s,  dp);
    }
    
    
    public int recursion(int i,int j, String s, int[][] dp){
        if (i>j) return 0;
        if (i==j) return 1;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j)){ // if same then just reduce i+1, j-1  
            return dp[i][j] = 1 + recursion(i+1, j, s,  dp)+recursion(i, j-1, s,  dp); // in this also abca , these will be case when (bca, abc) in this case we dont skip b or c because it will form  substring
        }
        
        return dp[i][j] = recursion(i+1, j, s, dp) + recursion(i, j-1, s, dp) - recursion(i+1, j-1, s, dp); // else reduce i+1, j-1, - (i+1, j-1) to avoid dulicate (ab, bc) is is common in both    
        
    }
}