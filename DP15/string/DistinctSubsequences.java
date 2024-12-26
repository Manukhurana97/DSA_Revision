public class DistinctSubsequences{

	private int distinctSubsequences(String s1, String s2){
		int n1 = s1.length(), n2 = s2.length();
		// return recursion(n1-1, n2-1, s1, s2);

		int[][] dp = new int[n1+1][n2+1];
		// return memoization(n1-1, n2-1, s1, s2, dp);

		// return tabulation(s1, s2, dp);

		// return spaceOptimization(s1, s2);

		return spaceOptimization1(s1, s2);
	}

	/**
	 * 1. Express everything in terms of index
	 * 2. Explore all possibilities
	 * 3. Return sum/max/min/count
	 * 4. Base case
	 * */ 
	private int recursion(int index1, int index2, String s1, String s2){
		if(index2 == -1) return 1;
		if(index1 == -1) return 0;


		if (s1.charAt(index1) == s2.charAt(index2)) {
            return recursion(index1 - 1, index2 - 1, s1, s2) + recursion(index1 - 1, index2, s1, s2);
		}
		return recursion(index1 - 1, index2, s1, s2);
	}

	public int memoization(int index1, int index2, String s1, String s2, int[][] dp){
		if (index2 == -1) return 1;
        if (index1 == -1) return 0;

		if (dp[index1][index2] != 0) return dp[index1][index2];


		if(s1.charAt(index1) == s2.charAt(index2)){
			return dp[index1][index2] = memoization(index1-1, index2-1, s1, s2, dp) + memoization(index1-1, index2, s1, s2, dp);
		}
		return dp[index1][index2] = memoization(index1-1, index2, s1, s2, dp);
	}


	private int tabulation( String s1, String s2, int[][] dp){
		for(int index1=0; index1<=s1.length(); index1++){
			dp[index1][0] = 1;
		}
		for(int index2=1; index2<=s2.length(); index2++){
			dp[0][index2] = 0;
		}
	
		for(int index1=1; index1<=s1.length(); index1++){
			for(int index2=1; index2<=s2.length(); index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1))
					dp[index1][index2] = dp[index1-1][index2-1] + dp[index1-1][index2];
				else dp[index1][index2] = dp[index1-1][index2];
			}
		}

		return dp[s1.length()][s2.length()];
	}


	private int spaceOptimization( String s1, String s2){
		
		int[] prev = new int[s2.length()+1];
		int[] curr = new int[s2.length()+1];

		prev[0] = curr[0] = 1;
		
		for(int index1=1; index1<=s1.length(); index1++){
			for(int index2=1; index2<=s2.length(); index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1))
					curr[index2] = prev[index2-1] + prev[index2];
				else curr[index2] = prev[index2];
			}
			prev = curr;
		}

		return prev[s2.length()];
	}


	private int spaceOptimization1( String s1, String s2){
		
		int[] prev = new int[s2.length()+1];

		prev[0] = 1;
		
		for(int index1=1; index1<=s1.length(); index1++){
			for(int index2=1; index2<=s2.length(); index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1))
					prev[index2] = prev[index2-1] + prev[index2];
				else prev[index2] = prev[index2];
			}
		}

		return prev[s2.length()];
	}



	public static void main(String[] args) {
		DistinctSubsequences obj = new DistinctSubsequences();
		System.out.println(obj.distinctSubsequences("babgbag", "bag"));
	}
}