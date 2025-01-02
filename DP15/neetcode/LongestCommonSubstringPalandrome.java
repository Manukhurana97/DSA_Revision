public class LongestCommonSubstringPalandrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder(s);
        String reversed = builder.reverse().toString();
        int[][] dp = new int[n + 1][n + 1];

        // Tabulation to return the longest palindromic substring
        String longestPalindromicSubstring = tabulation(s, reversed, dp);

        // If you want the length of the longest palindromic subsequence:
        // int longestPalindromeLength = memoization(n - 1, n - 1, s, reversed, dp);

        return longestPalindromicSubstring;
    }

    // Recursion to find the longest common palindrome length
    private int recursion(int i, int j, String s1, String s2) {
        if (i < 0 || j < 0) return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + recursion(i - 1, j - 1, s1, s2);
        } else {
            return Math.max(recursion(i - 1, j, s1, s2), recursion(i, j - 1, s1, s2));
        }
    }

    // Memoization to find the longest common palindrome length
    private int memoization(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + memoization(i - 1, j - 1, s1, s2, dp);
        } else {
            dp[i][j] = Math.max(memoization(i - 1, j, s1, s2, dp), memoization(i, j - 1, s1, s2, dp));
        }

        return dp[i][j];
    }

    // Tabulation to return the longest palindromic substring
    private String tabulation(String s1, String s2, int[][] dp) {
        int n = s1.length();
        int maxLen = 0, end = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > maxLen && (i - dp[i][j]) == (n - j)) {
                        maxLen = dp[i][j];
                        end = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s1.substring(end - maxLen + 1, end + 1);
    }


    // -------------------------------------------------------------------------------------------------------------------------


    public String longestPalindrome(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder(s);

        int[][] dp = new int[n+1][n+1];
        return tabulation(s, builder.reverse().toString(), dp);
    }


    // longest common substring
    public int recursion(int index1, int index2, String a, String b, int currentLen){

        if(index1<0 || index2<0) return 0;

        int len = currentLen;
        if(a.charAt(index1) == b.charAt(index2))
            len = recursion(index1-1, index2-1, a, b, currentLen+1);
        else 
            len = Math.max(len,  Math.max(recursion(index1-1, index2, a, b, 0), recursion(index1, index2-1, a, b, 0)));

        return len;
    }   


    // longest common substring
    public int memoization(int index1, int index2, String a, String b, int currentLen, int[][] dp){

        if(index1<0 || index2<0) return 0;

        if(dp[index1][index2] != 0) return dp[index1][index2];

        int len = currentLen;
        if(a.charAt(index1) == b.charAt(index2))
            len = memoization(index1-1, index2-1, a, b, currentLen+1, dp);
        else 
            len = Math.max(len,  Math.max(memoization(index1-1, index2, a, b, 0, dp), memoization(index1, index2-1, a, b, 0, dp)));

        return dp[index1][index2] = len;
    }   


    public String tabulation(String a, String b, int[][] dp){
        int n = a.length(), maxLen = 0, endIndex= 0;
        // increment the index by one to support base case
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){ 
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(maxLen<dp[i][j] && (i - dp[i][j]) == (n-j)){
                        maxLen = dp[i][j];
                        endIndex = i-1;
                    }
                }
                else 
                    dp[i][j] = 0;
            }
        }

        return a.substring(endIndex-maxLen+1, endIndex+1);
    }   



// -------------------------------------------------------------------------------------------------------------------------



    public static void main(String[] args) {
        LongestCommonSubstring solution = new LongestCommonSubstring();
        System.out.println(solution.longestPalindrome("babad"));  // Output: "bab" or "aba"
        System.out.println(solution.longestPalindrome("cbbd"));   // Output: "bb"
    }
}
