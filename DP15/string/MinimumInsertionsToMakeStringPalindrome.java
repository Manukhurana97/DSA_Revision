// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

public class MinimumInsertionsToMakeStringPalindrome{

	public int getMinimumInsertion(String s){
		int n = s.length();
		StringBuilder builder = new StringBuilder(s);

		// return n - recursion(n-1, n-1, s, builder.reverse().toString());

		int[][] dp = new int[n+1][n+1];
		// return n - memoizatrion(n-1, n-1, s, builder.reverse().toString(), dp);

		// return n - tabulation(s, builder.reverse().toString(), dp);

		return n - spaceOptimization(s, builder.reverse().toString());
	}

	public int recursion(int index1, int index2, String s1, String s2){ 

		if(index1<0 || index2<0) return 0;	


		if(s1.charAt(index1) == s2.charAt(index2)){
			return 1+recursion(index1-1, index2-1, s1, s2);
		}

		return Math.max(recursion(index1-1, index2, s1, s2), recursion(index1, index2-1, s1, s2));
	}


	public int memoizatrion(int index1, int index2, String s1, String s2, int[][] dp){

		if(index1<0 || index2<0) return 0;	

		if(dp[index1][index2] != 0) return dp[index1][index2];

		if(s1.charAt(index1) == s2.charAt(index2)){
			return 1+memoizatrion(index1-1, index2-1, s1, s2, dp);
		}

		return dp[index1][index2] = Math.max(memoizatrion(index1-1, index2, s1, s2, dp), memoizatrion(index1, index2-1, s1, s2, dp));
	}


	public int tabulation(String s1, String s2, int[][] dp){
		int n = s1.length();

		for(int i=0; i<n; i++){
			dp[i][0] = 0;
			dp[0][i] = 0;
		}

		for(int index1=1; index1<=n; index1++){
			for(int index2=1; index2<=n; index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1)) 
					dp[index1][index2] = 1 + dp[index1-1][index2-1];
				else 
					dp[index1][index2] = Math.max(dp[index1-1][index2], dp[index1][index2-1]);
			}
		}

		return dp[n][n];
	}


	public int spaceOptimization(String s1, String s2){
		int n = s1.length();

		int[] curr = new int[n+1];
		int[] prev = new int[n+1];

		for(int index1=1; index1<=n; index1++){
			for(int index2=1; index2<=n; index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1)) 
					curr[index2] = 1 + prev[index2-1];
				else 
					curr[index2] = Math.max(prev[index2], curr[index2-1]);
			}
			prev = curr;
		}

		return prev[n];
	}

	public static void main(String[] args) {
		MinimumInsertionsToMakeStringPalindrome obj = new MinimumInsertionsToMakeStringPalindrome();
		System.out.println(obj.getMinimumInsertion("abcaa"));
	}
}