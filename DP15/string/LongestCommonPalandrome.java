public class LongestCommonPalandrome{

	// using LongestCommonSubSequence tabulation
	public String longestPalandrome(String s1){
		StringBuilder builder  = new StringBuilder(s1);

		int[][] memo = new int[s1.length()+1][s1.length()+1];
		return tabulation(s1, builder.reverse().toString(), memo);
	}


	public String tabulation(String s1, String s2, int[][] memo){
		int n1 = s2.length();

		for(int i=0; i<n1; i++){
			memo[i][0] = 0;
			memo[0][i] = 0;
		}

		for(int index1=1; index1<=n1; index1++){
			for(int index2=1; index2<=n1; index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1)){
					memo[index1][index2] = 1 + memo[index1-1][index2-1];
				} else{
				 	memo[index1][index2] = Math.max(memo[index1-1][index2], memo[index1][index2-1]);
				}
			}
		}

		for(int i=0; i<=n1; i++){
			for(int j=0; j<=n1; j++){
				System.out.print(memo[i][j]+" ");
			}
			System.out.println();
		}

		StringBuilder builder = new StringBuilder();
		int i = n1, j = n1;

		while(i>0 && j>0){
			if(s1.charAt(i-1) == s2.charAt(j-1)){
				builder.append(s1.charAt(i-1));
				i-=1;
				j-=1;
			}else{
				if(memo[i][j] == memo[i-1][j]){
					i-=1;
				}else{
					j-=1;
				}
			}
		}


		return builder.toString(); 
	}


	public static void main(String[] args) {
		LongestCommonPalandrome obj = new LongestCommonPalandrome();

		// System.out.println(obj.longestPalandrome("bbabcbcab"));
		System.out.println(obj.longestPalandrome("abcaa"));
	}
}