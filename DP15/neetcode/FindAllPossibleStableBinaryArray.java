// https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i

public class FindAllPossibleStableBinaryArray {
	int MOD = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        // Integer[][][][] dp = new Integer[zero+1][one+1][2][limit+1];
        
        // int sum = 0;
        // if(zero > 0) sum = (sum + recursion(zero-1, one, 0, 1, limit, dp)) % MOD;
        // if(one > 0) sum = (sum + recursion(zero, one-1, 1, 1, limit, dp)) % MOD;
        // return sum;

        return tabulation(zero, one, limit);
    }

    private int recursion(int zero, int one, int last, int count, int limit, Integer[][][][] dp) {
        if(zero == 0 && one == 0) return 1;

        if(dp[zero][one][last][count] != null) return dp[zero][one][last][count];

        long ways = 0;
         if(zero > 0) {
            if(last != 0) ways += recursion(zero-1, one, 0, 1, limit, dp);
            else if(count < limit) ways += recursion(zero-1, one, 0, count + 1, limit, dp);
        }
        if(one > 0) {
            if(last != 1) ways += recursion(zero, one-1, 1, 1, limit, dp);
            else if(count < limit) ways += recursion(zero, one-1,  1, count+1, limit, dp);
        }

        return dp[zero][one][last][count] = (int)(ways % MOD);
    }

    public int tabulation(int zero, int one, int limit) {
        int[][][][] dp = new int[zero+1][one+1][2][limit+1];

        for(int l=0; l<2; l++) {
            for(int c=0; c<=limit; c++) {
                dp[0][0][l][c] = 1;
            }
        }

        for(int z=0; z<=zero; z++) {
            for(int o=0; o<=one; o++) {
                if(z == 0 && o == 0) continue;

                for(int l = 0; l<2; l++) {
                    for(int c=0; c<=limit; c++) {
                        
                        long ways = 0;
                        if(z > 0) {
                            if(l != 0) ways += dp[z-1][o][0][1];
                            else if(c < limit) ways += dp[z-1][o][0][c+1];
                        }
                        if(o > 0) {
                            if(l != 1) ways += dp[z][o-1][1][1];
                            else if(c < limit) ways += dp[z][o-1][1][c+1];
                        }
                        dp[z][o][l][c] = (int)(ways % MOD);
                    }
                }
            }
        }

        long ans = 0;
        for(int c=1; c<=limit; c++) {
            ans = (ans + dp[zero][one][0][c]) % MOD;
            ans = (ans + dp[zero][one][1][c]) % MOD;
        }

        return (int)ans;
    }

}