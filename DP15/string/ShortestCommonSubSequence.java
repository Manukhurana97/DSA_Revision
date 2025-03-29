// using longest commons substring approach
public class ShortestCommonSubSequence{

	public String shortestCommonSubSequence(String s1, String s2){
		int n1 = s1.length(), n2 = s2.length();

		int[][] dp = new int[n1+1][n2+1];
		return tabulation( s1, s2, dp);
	}


	public String tabulation(String s1, String s2, int[][] dp){
		int n1 = s1.length(), n2 = s2.length();

		for(int index1=0; index1<=n1; index1++) dp[index1][0] = 0;
		for(int index2=0; index2<=n2; index2++) dp[0][index2] = 0;

		for(int index1=1; index1<=n1; index1++){
			for(int index2=1; index2<=n2; index2++){
				if(s1.charAt(index1-1) == s2.charAt(index2-1))
					dp[index1][index2] = 1 + dp[index1-1][index2-1];
				else
					dp[index1][index2] = Math.max(dp[index1-1][index2], dp[index1][index2-1]);
			}
		}
		

		/*
			print / add backtracking response of dp in builder
		*/
		StringBuilder builder = new StringBuilder();
		while(n1>0 && n2>0){
			if(s1.charAt(n1-1) == s2.charAt(n2-1)){
				builder.append(s1.charAt(n1 - 1));
				n1-=1;
				n2-=1;
			}else{
				if(dp[n1][n2-1] <= dp[n1-1][n2]){
					builder.append(s1.charAt(n1 - 1));
					n1-=1;
				}else{
					builder.append(s2.charAt(n2 - 1));
					n2-=1;
				}
			}
		}

		while (n1 > 0) {
	        builder.append(s1.charAt(n1 - 1));
	        n1--;
	    }
	    while (n2 > 0) {
	        builder.append(s2.charAt(n2 - 1));
	        n2--;
	    }

		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		ShortestCommonSubSequence obj = new ShortestCommonSubSequence();
		System.out.println(obj.shortestCommonSubSequence("brute", "crate"));
	}
}