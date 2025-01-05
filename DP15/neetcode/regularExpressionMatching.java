public class regularExpressionMatching{
    public boolean isMatch(String a, String b) {
        int i = a.length(), j = b.length();
            
        // Boolean[][] dp = new Boolean[i+1][j+1];
        // return recursion(i-1, j-1, a, b, dp);

        // return tabulation(a, b);

        return spaceOptimization(a, b);
    }

    private boolean recursion(int i, int j, String a, String b, Boolean[][] dp){

        if(i<0 && j<0) return true;
        if(j<0) return false;
        if(i<0){
            while(j>=0){
                if(j>0 && b.charAt(j) == '*'){
                    j-=2;
                }else{
                    return false;
                }
            }
            return true;
        }

        if(dp[i][j] != null) return dp[i][j];
        
        if (a.charAt(i) == b.charAt(j) || b.charAt(j) == '.') {
            return dp[i][j] = recursion(i - 1, j - 1, a, b, dp);
        }else if(b.charAt(j) == '*'){
            boolean notTake = recursion(i, j-2, a, b, dp); // not taking preceding element , skipping j-1 element
            boolean takeMultipleTimes = (j > 0 && ( a.charAt(i) == b.charAt(j-1) || b.charAt(j-1) == '.') &&  recursion(i-1, j, a, b, dp)); // taking j-1 element multiple times

            return dp[i][j] = takeMultipleTimes || notTake;
        }
        return dp[i][j]= false;
        
    }



    private boolean tabulation(String a, String b){
        int n1 = a.length(), n2 = b.length();

        boolean[][] dp = new boolean[n1+1][n2+1];

        dp[0][0] = true;
        for(int j=1; j<=n2; j++){
            if(j-1>0 && b.charAt(j-1) == '*'){
                    
                dp[0][j] = dp[0][j-2];
            }
        }
        

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if (a.charAt(i-1) == b.charAt(j-1) || b.charAt(j-1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(b.charAt(j-1) == '*'){
                        boolean notTake = dp[i][j-2]; // not taking preceding element , skipping j-1 element
                        boolean takeMultipleTimes = (a.charAt(i-1) == b.charAt(j-2) || b.charAt(j-2) == '.') &&  dp[i-1][j]; // taking j-1 element multiple times


                        dp[i][j] = takeMultipleTimes || notTake;
                    
                    
                }
                else dp[i][j]= false;
            }
        }
        
        return dp[n1][n2];
    }


    private boolean spaceOptimization(String a, String b){
        int n1 = a.length(), n2 = b.length();

        boolean[] prev = new boolean[n2+1];

        prev[0] = true;
        for(int j=1; j<=n2; j++){
            if(j-1>0 && b.charAt(j-1) == '*'){
                    
                prev[j] = prev[j-2];
            }
        }
        

        for(int i=1; i<=n1; i++){
            boolean[] curr = new boolean[n2+1];
            for(int j=1; j<=n2; j++){
                if (a.charAt(i-1) == b.charAt(j-1) || b.charAt(j-1) == '.') {
                    curr[j] = prev[j - 1];
                }else if(b.charAt(j-1) == '*'){
                        boolean notTake = curr[j-2]; // not taking preceding element , skipping j-1 element
                        boolean takeMultipleTimes = (a.charAt(i-1) == b.charAt(j-2) || b.charAt(j-2) == '.') && prev[j]; // taking j-1 element multiple times


                        curr[j] = takeMultipleTimes || notTake;
                    
                    
                }
                else curr[j]= false;
            }
            prev = curr;
        }
        
        return prev[n2];
    }
}