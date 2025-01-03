public class LongestCommonSubSequence{
	public int longestCommonSubSeq(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();

        // return recursion(n1-1, n2-1, text1, text2);

        // int[][] dp = new int[n1+1][n2+1];
        // return memoization(n1-1, n2-1, text1, text2, dp);

        // return tabulation(text1, text2, dp);

        return spaceOptimization(text1, text2);
    }

    private int recursion(int n1, int n2, String s1, String s2){
        if(n1<0 || n2<0) return 0;

        if(s1.charAt(n1) == s2.charAt(n2)){
            return 1 + recursion(n1-1, n2-1, s1, s2);
        }
        return Math.max(recursion(n1-1, n2, s1, s2), recursion(n1, n2-1, s1, s2));
    }


    private int memoization(int n1, int n2, String s1, String s2, int[][] dp){
        if(n1<0 || n2<0) return 0;

        if(dp[n1][n2] != 0) return dp[n1][n2];

        if(s1.charAt(n1) == s2.charAt(n2)){
            return 1 + memoization(n1-1, n2-1, s1, s2, dp);
        }
        
        return dp[n1][n2] = Math.max(memoization(n1-1, n2, s1, s2, dp), memoization(n1, n2-1, s1, s2, dp));
    }


    private int tabulation(String s1, String s2, int[][] dp){
        int l1 = s1.length(), l2 = s2.length();
        dp[0][0] = 0;

        for(int n1=1; n1<=l1; n1++){
            for(int n2=1; n2<=l2; n2++){
                if(s1.charAt(n1-1) == s2.charAt(n2-1)){
                    dp[n1][n2] = 1 + dp[n1-1][n2-1];
                }else{
                    dp[n1][n2] = Math.max(dp[n1-1][n2], dp[n1][n2-1]);
                }
            }
        }

        return dp[l1][l2];
    }


    private int spaceOptimization(String s1, String s2){
        int l1 = s1.length(), l2 = s2.length();
        int[] prev = new int[l2+1];

        for(int n1=1; n1<=l1; n1++){
            int[] curr = new int[l2+1];
            for(int n2=1; n2<=l2; n2++){
                if(s1.charAt(n1-1) == s2.charAt(n2-1)){
                    curr[n2] = 1 + prev[n2-1];
                }else{
                    curr[n2] = Math.max(prev[n2], curr[n2-1]);
                }
            }
            prev = curr;
        }

        return prev[l2];
    }

	public static void main(String[] args) {
		LongestCommonSubSequence obj = new LongestCommonSubSequence();
		System.out.println(obj.longestCommonSubSeq("abc", "bac"));
	}
}