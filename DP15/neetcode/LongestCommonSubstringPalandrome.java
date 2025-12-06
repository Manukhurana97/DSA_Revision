// https://leetcode.com/problems/longest-palindromic-substring/description/

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
        int[][] dp = new int[n+1][n+1];

        // System.out.println(recursion(0, 0, 0, s, new StringBuilder(s).reverse().toString(), dp));
        System.out.println(tabulation(s, new StringBuilder(s).reverse().toString(), dp));
        return print(s, new StringBuilder(s).reverse().toString(), dp);
    }

    private int recursion(int i, int j, int l, String a, String b, int[][] dp) {
        if(i==a.length() || j == b.length()) return l; 

        if(dp[i][j] != 0) return dp[i][j];

        int cl = l;
        if(a.charAt(i) == b.charAt(j)) {
            cl = recursion(i+1, j+1, l+1, a, b, dp);
        }else {
            cl = Math.max(l, Math.max(recursion(i+1, j, 0, a, b, dp), recursion(i, j+1, 0, a, b, dp)));
        }

        return dp[i][j] = cl;
    }

    private int tabulation(String a, String b, int[][] dp) {
        int n = a.length();
        int maxLen = 0;

        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = 1+dp[i+1][j+1];
                    if(maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }


    private String print(String a, String b, int[][] dp) {
        int n = a.length();
        int maxLen = 0, startPoint = 0;

        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = 1+dp[i+1][j+1];
                    
                    if(maxLen < dp[i][j] && isPalandrome(i, dp[i][j], a)) {
                        maxLen = dp[i][j];
                        startPoint = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return a.substring(startPoint, startPoint + maxLen);
    }

    private boolean isPalandrome(int start, int maxLen, String a) {
        int left = start, right = start+maxLen - 1;

        while(left<right) {
            if(a.charAt(left) != a.charAt(right)) return false;
            left += 1;
            right -= 1;
        }

        return true;
    }



// -------------------------------------------------------------------------------------------------------------------------



    public static void main(String[] args) {
        LongestCommonSubstringPalandrome solution = new LongestCommonSubstringPalandrome();
        System.out.println(solution.longestPalindrome("babad"));  // Output: "bab" or "aba"
        System.out.println(solution.longestPalindrome("cbbd"));   // Output: "bb"
    }
}
