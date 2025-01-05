// https://leetcode.com/problems/word-break/

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        Set<String> wordset = new HashSet<>(wordDict);
        // return recursion(0,  s, wordset);

        int[] dp = new int[n+1];
        // return memoization(0, s, wordset, dp);


        return tabulation(s, wordset, dp);

    }

    private boolean recursion(int i, String s, Set<String> wordset){
        if(i==s.length()){
            return true;
        }
        
        
        for (int ind = i+1; ind <= s.length(); ind++) {
            if(wordset.contains(s.substring(i, ind)) && recursion(ind,  s, wordset)){
                return true;
            }
        }

        return false;
    }



    private boolean memoization(int i, String s, Set<String> wordset, int[] dp){
        if(i==s.length()){
            return true;
        }
        
        if(dp[i] != 0) return dp[i] == 1;
        
        for (int ind = i+1; ind <= s.length(); ind++) {
            if(wordset.contains(s.substring(i, ind)) && memoization(ind,  s, wordset, dp)){
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 2;
        return false;
    }


    private boolean tabulation(String s, Set<String> wordset, int[] dp){
        dp[s.length()] = 1;
        

        for(int i=s.length()-1; i>=0; i--)    {    
            for (int ind = i+1; ind <= s.length(); ind++) {
                if(wordset.contains(s.substring(i, ind)) && dp[ind]==1){
                    dp[i] = 1;
                    break; // No need to check further
                }
            }
        }

        return dp[0]==1;
    }
}