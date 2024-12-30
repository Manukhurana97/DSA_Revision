public class PalandromePartitioning2{

	/*min cuts required to make all string palandrome*/
	private int getMinPartitions(String str){
		int n = str.length();
		// return recursion(0, str);

		int[] dp = new int[n+1];
		// return memoization(0,str, dp);

		// return tabulation(str, dp);

		return spaceOptimization(str);
	}


	/**
	 * 1. express everything in tearms of index
	 * 2. explore all possibilities
	 * 3. return min
	 * 4. base case
	 * */
	private boolean isPalandrome(int i, int j, String s){
		while(i<j){
			if(s.charAt(i) != s.charAt(j)) return false;
			i+=1;
			j-=1;
		}

		return true;
	} 

	// Time : O(2^n, Space: O(n)
	private int recursion(int i, String str){
		if(i==str.length()) return 0;

		int minPartitions = Integer.MAX_VALUE;
		for(int ind=i; ind<str.length(); ind++){
			if(isPalandrome(i, ind, str)){
				int partitions = 1 + recursion(ind+1, str);
				minPartitions =Math.min(minPartitions, partitions);
			}
		}

		return minPartitions;
	}


	// Time : O(n^2), Space: O(n+n)
	private int memoization(int i, String str, int[] dp){
		if(i==str.length()) return 0;

		if(dp[i] != 0) return dp[i];

		int minPartitions = Integer.MAX_VALUE;
		for(int ind=i; ind<str.length(); ind++){
			if(isPalandrome(i, ind, str)){
				int partitions = 1 + memoization(ind+1, str, dp);
				minPartitions =Math.min(minPartitions, partitions);
			}
		}

		return dp[i] = minPartitions;
	}


	// Time : O(n^2), Space: O(n)
	private int tabulation(String str, int[] dp){

		for(int i=str.length()-1; i>=0; i--){
			int minPartitions = Integer.MAX_VALUE;
			for(int ind=i; ind<str.length(); ind++){
				if(isPalandrome(i, ind, str)){
					int partitions = 1 + dp[ind+1];
					minPartitions = Math.min(minPartitions, partitions);
				}
			}
			dp[i] = minPartitions;
		}

		return dp[0];
	}

	public static void main(String[] args) {
		PalandromePartitioning2 obj = new PalandromePartitioning2();
		System.out.println(obj.getMinPartitions("bababcbacede"));
	}
}