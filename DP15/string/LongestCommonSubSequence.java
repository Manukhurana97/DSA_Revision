public class LongestCommonSubSequence{
	public int longestCommonSubSeq(String a, String b){

		// return recursion(a.length()-1, b.length()-1, a, b);

		// int[][] dp = new int[a.length()][b.length()];
		// return memoization(a.length()-1, b.length()-1, a, b, dp);

		// int[][] dp = new int[a.length()+1][b.length()+1];
		// return memoization1(a.length(), b.length(), a, b, dp);

		// return tabulation(a, b, dp);

		return spaceOptimize(a, b);
	}

	/**
	 * Rules:
	 * 1. express everything in tearms of index
	 * 2. explore all possibilities on that index
	 * 3. take the best amongst them
	 * */ 
	public int recursion(int index1, int index2, String a, String b){

		if(index1<0 || index2<0) return 0;

		if(a.charAt(index1) == b.charAt(index2))
			return 1 + recursion(index1-1, index2-1, a, b);

		return Math.max(recursion(index1-1, index2, a, b), recursion(index1, index2-1, a, b));
	}	


	public int memoization(int index1, int index2, String a, String b, int[][] dp){

		if(index1<0 || index2<0) return 0;

		if(dp[index1][index2] != 0) return dp[index1][index2];

		if(a.charAt(index1) == b.charAt(index2))
			return dp[index1][index2] = 1 + memoization(index1-1, index2-1, a, b, dp);

		return dp[index1][index2] =  Math.max(memoization(index1-1, index2, a, b, dp), memoization(index1, index2-1, a, b, dp));
	}	


	// after shifting of index
	public int memoization1(int index1, int index2, String a, String b, int[][] dp){

		if(index1==0 || index2==0) return 0;

		if(dp[index1][index2] != 0) return dp[index1][index2];

		if(a.charAt(index1-1) == b.charAt(index2-1))
			return dp[index1][index2] = 1 + memoization1(index1-1, index2-1, a, b, dp);

		return dp[index1][index2] =  Math.max(memoization1(index1-1, index2, a, b, dp), memoization1(index1, index2-1, a, b, dp));
	}	


	public int tabulation(String a, String b, int[][] dp){
		int n1 = a.length(), n2 = b.length();

		for(int index1=0; index1<=n1; index1++){
			dp[index1][0] = 0; 
		}
		for(int index2=0; index2<=n2; index2++){
			dp[0][index2] = 0; 
		}

		for(int index1=1; index1<=n1; index1++){
			for(int index2=1; index2<=n2; index2++){
				if(a.charAt(index1-1) == b.charAt(index2-1))
					dp[index1][index2] = 1 + dp[index1-1][index2-1];
				else 
					dp[index1][index2] =  Math.max(dp[index1-1][index2], dp[index1][index2-1]);
			}
		}
		return dp[a.length()][b.length()];
	}	


	public int spaceOptimize(String a, String b){
		int n1 = a.length(), n2 = b.length();

		int[] prev = new int[n2+1];
		int[] curr = new int[n2+1];

		for(int index1=0; index1<=n1; index1++){
			prev[0] = 0; 
		}	

		for(int index1=1; index1<=n1; index1++){
			for(int index2=1; index2<=n2; index2++){
				if(a.charAt(index1-1) == b.charAt(index2-1))
					curr[index2] = 1 + prev[index2-1];
				else 
					curr[index2] =  Math.max(prev[index2], curr[index2-1]);
			}
			prev = curr;
		}
		return prev[b.length()];
	}	

	public static void main(String[] args) {
		LongestCommonSubSequence obj = new LongestCommonSubSequence();
		System.out.println(obj.longestCommonSubSeq("abc", "bac"));
	}
}