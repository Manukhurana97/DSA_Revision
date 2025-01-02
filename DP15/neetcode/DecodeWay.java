class DecodeWay {
    public int numDecodings(String s) {
        // return recursion(0, s);

        // int[] dp = new int[s.length()+1];
        // return memoization(0, s, dp);

        // return tabulation(s, dp);

        return spaceOptimization(s);
    }

    private int recursion(int i, String s){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;


        int current = recursion(i+1, s); // take the current char
        int next = 0;
        if(i<s.length()-1){
             // if current is one then proceed, else for 2 i+1 should be less the 7
            if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <'7'){
                next += recursion(i+2, s); // take the i+1 char
            }
        }

        return current+next;
    }


    private int memoization(int i, String s, int[] dp){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != 0) return dp[i];

        int current = memoization(i+1, s, dp);
        int next = 0;
        if(i<s.length()-1){
            // if current is one then proceed, else for 2 i+1 should be less the 7
            if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <'7'){
                next += memoization(i+2, s, dp);
            }
        }

        return dp[i] = current+next;
    }


    private int tabulation(String s, int[] dp){
        int n = s.length();
        dp[s.length()] = 1;

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }else{
                int current = dp[i+1];
                int next = 0;
                if(i<s.length()-1){
                    // if current is one then proceed, else for 2 i+1 should be less the 7
                    if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <'7'){
                        next += dp[i+2];
                    }
                }
                dp[i] = current+next;
            }
        }

        return dp[0];
    }

    private int spaceOptimization(String s){
        int n = s.length(), dp = 0, dp1=1, dp2=0;

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '0'){
                dp = 0;
            }else{
                int current = dp1;
                int next = 0;
                if(i<s.length()-1){
                    // if current is one then proceed, else for 2 i+1 should be less the 7
                    if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <'7'){
                        next += dp2;
                    }
                }
                dp = current+next;
            }
            dp2 = dp1;
            dp1 = dp;
            dp = 0;
        }

        return dp1;
    }
}