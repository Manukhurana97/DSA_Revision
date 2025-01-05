public class WildcardMatching{
	private boolean wildCard(String a, String b){
		int n1 = a.length(), n2 = b.length();

		return recursion(n1-1, n2-1, a, b);

		// int[][] dp = new int[n1+1][n2+1];
		// return memoization(n1-1, n2-1, a, b, dp);

		// return tabulation(a, b);

		// return spaceOptimize(a, b);
	}

	/**
	 * 1. express everything in tearms of index
	 * 2. explore all possibilities
	 * 3. return boolean 
	 * 4. base case
	 * 
	 * if chat is same we will reduce both
	 * if s1 has * explore all case by taking * and not taking *
	 * else both char are different return false;
	 * */ 
	private boolean recursion(int index1, int index2, String s1, String s2){
		if (index1 < 0 && index2 < 0) return true;
		if(index1<0 && index2>=0) return false; // Pattern exhausted, but text remains
		if(index2<0){
			while(index1>=0){
				if(s1.charAt(index1) != '*') return false;
				index1-=1;
			}
			return true;
		}

		if(s1.charAt(index1) == s2.charAt(index2) || s1.charAt(index1) == '?'){
			// Characters match or '?' matches any character
			return recursion(index1-1, index2-1, s1, s2);
		}else if(s1.charAt(index1) == '*'){
			// '*' matches zero or more characters
			return recursion(index1, index2-1, s1, s2)  // '*' matches zero characters
			|| recursion(index1-1, index2, s1, s2); // '*' matches one or more characters
		}else{
			return false; // Characters do not match
		}
	}


	private boolean memoization(int index1, int index2, String s1, String s2, int[][] dp){
		if (index1 < 0 && index2 < 0) return true;
		if(index1<0) return false; // Pattern exhausted, but text remains
		if(index2<0){
			while(index1>=0){
				if(s1.charAt(index1) != '*') return false;
				index1-=1;
			}
			return true;
		}
		if(dp[index1][index2] != 0) return dp[index1][index2] == 1;

		if(s1.charAt(index1) == s2.charAt(index2) || s1.charAt(index1) == '?'){
			boolean val = memoization(index1-1, index2-1, s1, s2, dp);
			 dp[index1][index2] = val == true ? 1 : 2;
			 return val;
		}else if(s1.charAt(index1) == '*'){
			boolean val = (memoization(index1, index2-1, s1, s2, dp) ||  memoization(index1-1, index2, s1, s2, dp));
			dp[index1][index2] = val == true ? 1 : 2; 
			return val;
		}else{
			dp[index1][index2] = 2;
			return  false; 
		}
	}


	/**
	 * 1. base case
	 * 2. changing parameters
	 * 3. copy ther recurence 
	 * */

	private boolean tabulation(String s1, String s2){
	 	int n1 = s1.length(), n2 = s2.length();
	 	boolean[][] dp = new boolean[n1+1][n2+1];

	 	dp[0][0] = true;


	 	for(int index2=1; index2<=n2; index2++)
			dp[0][index2] = false; // Pattern exhausted, but text remains
		
		for(int index1=1; index1<=n1; index1++){
			boolean flag = true;
			for(int i=1; i<=index1; i++){
				if (s1.charAt(i - 1) != '*') {
	                flag = false;
	                break;
	            }
			}
			dp[index1][0] = flag;
		}

		for(int index1=1; index1<=n1; index1++){
			for(int index2=1; index2<=n2; index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1) || s1.charAt(index1-1) == '?'){
					 dp[index1][index2] = dp[index1-1][index2-1];
				}else if(s1.charAt(index1-1) == '*'){
					dp[index1][index2] = (dp[index1][index2-1] || dp[index1-1][index2]);
				}else{
					dp[index1][index2] = false;
				}
			}
		}

		return dp[n1][n2];
	}


	private boolean spaceOptimize(String s1, String s2){
	 	int n1 = s1.length(), n2 = s2.length();
	 	boolean[] prev = new boolean[n2+1];
	 	boolean[] curr = new boolean[n2+1];

	 	prev[0] = true;

	 	for(int index2=1; index2<=n2; index2++)
			prev[index2] = false; // Pattern exhausted, but text remains


		for(int index1=1; index1<=n1; index1++){
			curr[0] = true;
			for(int i=1; i<=index1; i++){
				if (s1.charAt(i - 1) != '*') {
	                curr[0] = false;
	                break;
	            }
			}
			for(int index2=1; index2<=n2; index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1) || s1.charAt(index1-1) == '?'){
					 curr[index2] = prev[index2-1];
				}else if(s1.charAt(index1-1) == '*'){
					curr[index2] = (curr[index2-1] || prev[index2]);
				}else{
					curr[index2] = false;
				}
			}
			prev = curr.clone();
		}

		return prev[n2];
	}

	

	public static void main(String[] args) {
		WildcardMatching obj = new WildcardMatching();
		System.out.println(obj.wildCard("ab*cd", "abdejcd")); // true
	    System.out.println(obj.wildCard("a?b", "acb")); // true
	    System.out.println(obj.wildCard("*", "abcdef")); // true
	    System.out.println(obj.wildCard("a*", "")); // false
	    System.out.println(obj.wildCard("a*b", "acb")); // true
	    System.out.println(obj.wildCard("a*b", "ab")); // true
	}
}