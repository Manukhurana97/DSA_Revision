// https://leetcode.com/problems/palindrome-partitioning-iii

public class PalindromePartitioning3 {
	public int palindromePartition(String s, int k) {
        if(k == s.length()) return 0;
        Integer[][] dp = new Integer[s.length()+1][k+1];

        return recursion(0, 0, s, k, dp);
    }

    // find the valid case first 
    // minimize the string split (while back tracking)

    public int recursion(int i, int sp, String s, int k, Integer[][] dp) {
        if(sp > k) return Integer.MAX_VALUE;
        if(i == s.length()) {
            return (sp == k) ? 0 : Integer.MAX_VALUE;
        }

        if(dp[i][sp] != null) return dp[i][sp];

        int result = Integer.MAX_VALUE;
        for(int index=i; index<s.length(); index++) {
            int remaining = recursion(index+1, sp+1, s, k, dp);
            if(remaining != Integer.MAX_VALUE){
                result = Math.min(result, changeCharacterToMakePalandrome(i, index, s) + remaining);
            }
        }

        return dp[i][sp] = result;
    }

    public int changeCharacterToMakePalandrome(int start, int end, String s) {
        int diff = 0;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) diff+=1;
            start += 1;
            end -= 1;
        }

        return diff;
    }
}