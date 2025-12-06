// sales force question 
// a fixed starting poing, b variable starting point

public class LongestSubsequence {
	private int getLongestSubsequence(String a, String b) {
		// int[][] dp = new int[a.length()+1][b.length()+1];

		// int max = 0;
		// for (int start = 0; start < b.length(); start++) {
        //     max = Math.max(max, recursion(0, start, a, b, dp));
        // }

		// return max;

		// return tabulation(a, b, dp);

		return spaceOptimization(a, b);
	}

	private int recursion(int i, int j, String a, String b, int[][] dp) {
		if(i == a.length() || j == b.length()) return 0;

		if(dp[i][j] != 0) return dp[i][j];

		if(a.charAt(i) == b.charAt(j)) 
			return dp[i][j] = 1 + recursion(i+1, j+1, a, b, dp);

		return dp[i][j] = recursion(i+1, j, a, b, dp); 
	} 

	private int tabulation(String a, String b, int[][] dp) {

		for(int i=a.length()-1; i>=0; i--) {
			for(int j=b.length()-1; j>=0; j--) {
				if(a.charAt(i) == b.charAt(j)) 
					dp[i][j] = 1 + dp[i+1][j+1];
				else dp[i][j] = dp[i+1][j]; 
			}
		}

		int max = 0;
		for(int i=0; i<b.length(); i++) {
			max = Math.max(max, dp[0][i]);
		}

		return max;
	}


	private int spaceOptimization(String a, String b) {

		int[] prev = new int[b.length()+1];

		for(int i=a.length()-1; i>=0; i--) {
			int[] curr = new int[b.length() + 1];

			for(int j=b.length()-1; j>=0; j--) {
				if(a.charAt(i) == b.charAt(j)) 
					curr[j] = 1 + prev[j+1];
				else curr[j] = prev[j]; 
			}
			prev = curr;
		}

		int max = 0;
		for(int i=0; i<b.length(); i++) {
			max = Math.max(max, prev[i]);
		}

		return max;
	}

	public static void main(String[] args) {
		LongestSubsequence obj = new LongestSubsequence();
		System.out.println(obj.getLongestSubsequence("abcd", "abdc"));
		System.out.println(obj.getLongestSubsequence("abcdez", "zzbcda"));
		System.out.println(obj.getLongestSubsequence("hackerranks", "hackers"));
	}
}