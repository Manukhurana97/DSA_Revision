public class NumberOfLongestIncreasingSubsequences{


	/** 
	 * number of combinations we can formed for the longest seusequece
	 * eg : [1,2,4,3,5], max id 5 with len 4 , we can have in in 2 order [{1,2,4,5}, {1,2,3,5}]
	 * */
	private int longestIncSubSequence(int[] arr){

		int n = arr.length, maxLen = 0;

		int[] dp = new int[n];
		int[] cnt = new int[n];

		for(int i=0; i<n; i++){
			dp[i]=1;
			cnt[i] = 1;
		}

		for(int i=0; i<n; i++){
			for(int prev = 0; prev<i; prev++){
				if(arr[prev]<arr[i] && dp[i]<dp[prev] + 1){
					dp[i] = dp[prev]+1;
					cnt[i] = cnt[prev];
				}else if(arr[prev]<arr[i] && dp[i] == dp[prev] + 1){
					cnt[i] += cnt[prev];
				}
			}
			maxLen = Math.max(maxLen, cnt[i]);
		}

		return maxLen;
	}


	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequences obj = new NumberOfLongestIncreasingSubsequences();
		int[] arr = {1,2,3,5,4,7};
		System.out.println(obj.longestIncSubSequence(arr));
	}

}