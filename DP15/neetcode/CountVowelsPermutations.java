public class CountVowelsPermutations{
	public int countVowelPermutation(int n) {
        int[][] dp = new int[n+1][5];
        dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = 1;

        int mod = 1000000007;

        for (int i = 1; i <n; i++) {
            dp[i][0] = ((dp[i - 1][1] + dp[i - 1][2]) % mod + dp[i - 1][4]) % mod; // 'a' can follow {'e', 'i', 'u'}
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod; // 'e' can follow {'a', 'i'}
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod; // 'i' can follow {'e', 'o'}
            dp[i][3] = dp[i - 1][2] % mod; // 'o' can follow {'i'}
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod; // 'u' can follow {'i', 'o'}
        }

        long count = 0;
        
        for(long d : dp[n-1]){
            count += d;
            count %= mod;
        }
 
        return (int) count;
    }

    // --------------------------------------------------------------------------------------


    public int countVowelPermutation(int n) {
        int[] prev = new int[5];
        int[] curr = new int[5];
        prev[0] = prev[1] = prev[2] = prev[3] = prev[4] = 1;

        int mod = 1000000007;

        for (int i = 1; i <n; i++) {
            curr[0] = ((prev[1] + prev[2]) % mod + prev[4]) % mod; // 'a' can follow {'e', 'i', 'u'}
            curr[1] = (prev[0] + prev[2]) % mod; // 'e' can follow {'a', 'i'}
            curr[2] = (prev[1] + prev[3]) % mod; // 'i' can follow {'e', 'o'}
            curr[3] = prev[2] % mod; // 'o' can follow {'i'}
            curr[4] = (prev[2] + prev[3]) % mod; // 'u' can follow {'i', 'o'}

            prev = curr.clone();
        }

        long count = 0;
        
        for(long d : prev){
            count += d;
            count %= mod;
        }
 
        return (int) count;
    }
}