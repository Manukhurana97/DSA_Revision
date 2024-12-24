public class PrintLongestCommonSubSequence{

	public String printSubSequence(String s1, String s2){
		int n1 = s1.length(), n2 = s2.length();
		int[][] dp = new int[n1+1][n2+1];
		return tabulation( s1, s2, dp);
	}

	public String tabulation(String a, String b, int[][] dp){
		int n1 = a.length(), n2 = b.length();
		
		for(int index1=0; index1<=n1; index1++) dp[index1][0] = 0;
		for(int index2=0; index2<=n2; index2++) dp[0][index2] = 0;

		for(int index1=1; index1<=n1; index1++){
			for(int index2=1; index2<=n2; index2++){
				if(a.charAt(index1-1) == b.charAt(index2-1))
					dp[index1][index2] = 1 + dp[index1-1][index2-1];
				else
					dp[index1][index2] = Math.max(dp[index1-1][index2], dp[index1][index2-1]);

			}
		}


		StringBuilder sb = new StringBuilder();

		while(n1>0 && n2>0){
			if(a.charAt(n1-1) == b.charAt(n2-1)){
				sb.append(a.charAt(n1-1));
				n1-=1;
				n2-=1;
			}else{
				if(dp[n1-1][n2] == dp[n1][n2]){
					n1-=1;
				}else{
					n2-=1;
				}
			}
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		PrintLongestCommonSubSequence obj = new PrintLongestCommonSubSequence();
		System.out.println(obj.printSubSequence("abc", "bac"));
	}
}