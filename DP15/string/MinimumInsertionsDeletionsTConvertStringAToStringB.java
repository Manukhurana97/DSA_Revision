// https://leetcode.com/problems/delete-operation-for-two-strings/

public class MinimumInsertionsDeletionsTConvertStringAToStringB{

	private int minNumberOfOperations(String s1, String s2){
		int n1 = s1.length(), n2 = s2.length();

		// int commonElement = recursion(n1-1, n2-1, s1, s2);

		int[][] dp = new int[n1+1][n2+1];
		// int commonElement = memoization(n1-1, n2-1, s1, s2, dp);

		// int commonElement = tabulation(s1, s2, dp);

		int commonElement = spaceOptimization(s1, s2);

				// no of insertions    no of deletions
		return (n1 - commonElement) + (n2 - commonElement);
	}


	private int recursion(int index1, int index2, String s1, String s2){
		if(index1 < 0 || index2 < 0) return 0;

		if(s1.charAt(index1) == s2.charAt(index2)){
			return 1 + recursion(index1-1, index2-1, s1, s2);
		}

		return Math.max(recursion(index1-1, index2, s1, s2), recursion(index1, index2-1, s1, s2));
	}


	private int memoization(int index1, int index2, String s1, String s2, int[][] dp){
		if(index1 < 0 || index2 < 0) return 0;

		if(dp[index1][index2] != 0) return dp[index1][index2];

		if(s1.charAt(index1) == s2.charAt(index2)){
			return 1 + memoization(index1-1, index2-1, s1, s2, dp);
		}

		return dp[index1][index2] = Math.max(memoization(index1-1, index2, s1, s2, dp), memoization(index1, index2-1, s1, s2, dp));
	}


	private int tabulation(String s1, String s2, int[][] dp){
		int n1 = s1.length(), n2 = s2.length();

		for(int index1=0; index1<=n1; index1++) dp[index1][0] = 0;
		for(int index2=1; index2<=n2; index2++) dp[0][index2] = 0;

		for(int index1=1; index1<=n1; index1++){
			for(int index2=1; index2<=n2; index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1)){
					dp[index1][index2] = 1 + dp[index1-1][index2-1];
				}else{
					 dp[index1][index2] = Math.max(dp[index1-1][index2], dp[index1][index2-1]);
				}
			}
		}

		return dp[n1][n2];
	}


	private int spaceOptimization(String s1, String s2){
		int n1 = s1.length(), n2 = s2.length();
		int[] prev = new int[n2+1];
		int[] curr = new int[n2+1];

		prev[0] = 0;

		for(int index1=1; index1<=n1; index1++){
			for(int index2=1; index2<=n2; index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1)){
					curr[index2] = 1 + prev[index2-1];
				}else{
					 curr[index2] = Math.max(prev[index2], curr[index2-1]);
				}
			}
			prev = curr;
		}

		return prev[n2];
	}

	public static void main(String[] args) {
		MinimumInsertionsDeletionsTConvertStringAToStringB obj = new MinimumInsertionsDeletionsTConvertStringAToStringB();
		System.out.println(obj.minNumberOfOperations("abcd", "anc"));
	}
}
