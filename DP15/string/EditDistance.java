// https://leetcode.com/problems/edit-distance/description/

public class EditDistance{

	private int minOperations(String s1, String s2){
		int n1 = s1.length(), n2 = s2.length();

		// return recursion(n1-1, n2-1, s1, s2);

		int[][] dp = new int[n1+1][n2+1];
		// return memoization(n1-1, n2-1, s1, s2, dp);

		// return tabulation(s1, s2, dp);

		return spaceOptimization(s1, s2);
	}

	/**
	 * 1. express everything in terms of index.
	 * 2. explore all possibilities in indexes
	 * 3. count/sum/min/max
	 * 4. base case
	 * */
	public int recursion(int index1, int index2, String s1, String s2){

		if(index1 < 0) return 1 + index2;
		if(index2 < 0) return 1 + index1;


		if(s1.charAt(index1) == s2.charAt(index2)) 
			return recursion(index1-1, index2-1, s1, s2);

		int insert =  recursion(index1, index2-1, s1, s2);
		int deletion =  recursion(index1-1, index2, s1, s2);
		int replace =  recursion(index1-1, index2-1, s1, s2);

		return 1 + Math.min(insert, Math.min(deletion, replace));
	}


	public int memoization(int index1, int index2, String s1, String s2, int[][] dp){

		if(index1 < 0) return 1 + index2;
		if(index2 < 0) return 1 + index1;

		if(dp[index1][index2] != 0) return dp[index1][index2];


		if(s1.charAt(index1) == s2.charAt(index2)) 
			return dp[index1][index2] = memoization(index1-1, index2-1, s1, s2, dp);

		int insert =  memoization(index1, index2-1, s1, s2, dp);
		int deletion =  memoization(index1-1, index2, s1, s2, dp);
		int replace =  memoization(index1-1, index2-1, s1, s2, dp);

		return dp[index1][index2] = 1 + Math.min(insert, Math.min(deletion, replace));
	}


	/**
	 * 1. base case
	 * 2. copy the changing parameter
	 * 3. copy the recurence
	 * */
	public int tabulation(String s1, String s2, int[][] dp){
		int n1 = s1.length(), n2 = s2.length();

		for(int index1=0; index1<=n1; index1++) dp[index1][0] = index1;  // Insert all remaining characters of s2
		for(int index2=0; index2<=n2; index2++) dp[0][index2] = index2; // Delete all remaining characters of s1

		for(int index1=1; index1<=n1; index1++){
			for(int index2=1; index2<=n2; index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1)) 
					dp[index1][index2] = dp[index1-1][index2-1];
				else {
					int insert =  dp[index1][index2-1];
					int deletion =  dp[index1-1][index2];
					int replace =  dp[index1-1][index2-1];
	
					dp[index1][index2] = 1 + Math.min(insert, Math.min(deletion, replace));
				}
			}
		}

		return dp[n1][n2];
	}

	public int spaceOptimization(String s1, String s2){
		int n1 = s1.length(), n2 = s2.length();
        int[] prev = new int[n2 + 1];
        int[] curr = new int[n2 + 1];

		for (int index2 = 0; index2 <= n2; index2++)
			prev[index2] = index2; // Delete all remaining characters of s1
 		
 		for (int index1 = 1; index1 <= n1; index1++) {
 			curr[0] = index1;
			for (int index2 = 1; index2 <= n2; index2++) {
				if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                    curr[index2] = prev[index2 - 1];
				else {
					int insert = curr[index2 - 1];
                    int deletion = prev[index2];
                    int replace = prev[index2 - 1];
	
                    curr[index2] = 1 + Math.min(insert, Math.min(deletion, replace));
				}
			}
			prev = curr.clone(); 
		}

		return prev[n2];
	}

	public static void main(String[] args) {
		EditDistance obj = new EditDistance();
		System.out.println(obj.minOperations("horse", "roe"));
	}
}

