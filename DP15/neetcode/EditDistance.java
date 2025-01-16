// https://leetcode.com/problems/edit-distance/description/

public class EditDistance{
	
	public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();

        if(n1 == 0) return n2;
        if(n2 == 0) return n1;

        int[][] dp = new int[n1+1][n2+1];
        // return recursion(n1-1, n2-1, word1, word2, dp);

        // return tabulation(word1, word2, dp);

        return spaceOptimization(word1, word2);
    }

    private int recursion(int i, int j, String a, String b, int[][] dp){
        if(i<0 && j<0) return 0;
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j] != 0) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = recursion(i-1, j-1, a, b, dp);
        }

        int insertion = recursion(i, j-1, a, b, dp);
        int deletion = recursion(i-1, j, a, b, dp);
        int replace = recursion(i-1, j-1, a, b, dp);

        return dp[i][j] = 1 + Math.min(replace, Math.min(insertion, deletion));
    }


    private int tabulation(String a, String b, int[][] dp){
        int n1 = a.length(), n2 = b.length();
        
        for(int i=0; i<=n1; i++) dp[i][0] = i;
        for(int j=0; j<=n2; j++) dp[0][j] = j;
        
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insertion = dp[i][j-1];
                    int deletion = dp[i-1][j];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = 1 + Math.min(replace, Math.min(insertion, deletion));
                }
            }
        }

        return dp[n1][n2];

    }


    private int spaceOptimization(String a, String b){
        int n1 = a.length(), n2 = b.length();

        int[] prev = new int[n2+1];
        
        for(int j=0; j<=n2; j++) prev[j] = j;
        
        for(int i=1; i<=n1; i++){
            int[] curr = new int[n2+1];
            curr[0] = i;
            for(int j=1; j<=n2; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else{
                    int insertion = curr[j-1];
                    int deletion = prev[j];
                    int replace = prev[j-1];

                    curr[j] = 1 + Math.min(replace, Math.min(insertion, deletion));
                }
            }
            prev = curr;
        }

        return prev[n2];
    }
}