
// using tabulation from LongestCommonSubSequence and PrintLongestCommonSubSequence;
public class PrintLongestCommonSubString{

	private int printSubString(String a, String b){
		int n1 = a.length(), n2 = b.length();

		int[][] dp = new int[n1+1][n2+1];
		return tabulation(a, b, dp);
	}


	public int tabulation(String a, String b, int[][] dp){
		int n1 = a.length(), n2 = b.length();

		int ans = 0;
		
		for(int index1=0; index1<=n1; index1++) dp[index1][0] = 0;
		for(int index2=0; index2<=n2; index2++) dp[0][index2] = 0;

		for(int index1=1; index1<=n1; index1++){
			for(int index2=1; index2<=n2; index2++){
				if(a.charAt(index1-1) == b.charAt(index2-1)){
					dp[index1][index2] = 1 + dp[index1-1][index2-1];
					ans = Math.max(ans, dp[index1][index2]);
				}
				else
					dp[index1][index2] = 0;

			}
		}
		return ans;
	}

	public static void main(String[] args) {
		PrintLongestCommonSubString obj = new PrintLongestCommonSubString();
		System.out.println(obj.printSubString("abxd", "abcd"));
	}
}