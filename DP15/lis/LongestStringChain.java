import java.util.*;

/*similar to PrintLongestIncreasingSubSequence*/
public class LongestStringChain{

	public int longestChain(String[] arr){

		int n = arr.length, maxLen = 0;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for(int i=0; i<arr.length; i++){
			for(int prev = 0; prev<=i; prev++){
				if(compare(arr[i], arr[prev]) && dp[i] < dp[prev] + 1){
					dp[i] = dp[prev] + 1;
				}
			}

			if(dp[i]>maxLen){
				maxLen = dp[i];
			}
		}

		return maxLen;
	}


	private boolean compare(String a, String b){
		if(a.length() != b.length() + 1) return false;


		int i=0, j=0;

		while(i<a.length() && j<b.length()){
			if(a.charAt(i) != b.charAt(j)){
				j+=1;
			}
			i+=1;
		}

		return j == b.length();

	}

	public static void main(String[] args) {
		LongestStringChain obj = new LongestStringChain();
		String[] arr = {"a", "b", "c", "ab", "ac", "bc", "abc"};
		System.out.println(obj.longestChain(arr));
	}
}