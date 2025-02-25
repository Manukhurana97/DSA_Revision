// https://leetcode.com/problems/longest-string-chain/

import java.util.*;

/*similar to PrintLongestIncreasingSubSequence*/
public class LongestStringChain{

	public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        int[][] dp = new int[n][n];
        return recursion(0, -1, words, dp);
    }

    private int recursion(int i, int prev, String[] words, int[][] dp){
        if(i == words.length) return 0;

        if(dp[i][prev+1] != 0 ) return dp[i][prev+1];

        int notTake = recursion(i+1, prev, words, dp);
        int take = (prev == -1 || getDiff(words[i], words[prev])) ? 1 + recursion(i+1, i, words, dp) : 0;

        return dp[i][prev+1] = Math.max(take, notTake);
    }

    private boolean getDiff(String a, String b){
        if(a.length() != b.length() + 1) return false;

        int i=0, j=0, count = 0;
        while(j<a.length()){
            if(i<b.length() && a.charAt(j) == b.charAt(i)){
                i++;
            }else{
                count++;
            }
            j++;
        }
       

        return count == 1;

    }

    // --------------------------------------------------------------------------

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
}4