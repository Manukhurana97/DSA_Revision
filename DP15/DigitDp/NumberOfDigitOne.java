// https://leetcode.com/problems/number-of-digit-one/description

public class NumberOfDigitOne {
	// O(n^2)
    // public int countDigitOne(int n) {
    //     int count = 0;

    //     for(int i=1; i<=n; i++) {
    //         String s = Integer.toString(i);
    //         for(int j=0; j<s.length(); j++) {
    //             if(s.charAt(j) == '1') {
    //                 count += 1;
    //             }
    //         }
    //     }

    //     return count;
    // }



    public int countDigitOne(int n) {
        Integer[][][] dp = new Integer[10][2][10];
        return recursion(Integer.toString(n), 0, 1, 0, dp);
    }

    public int recursion(String s, int index, int tight, int count, Integer[][][] dp) {
        if(index == s.length()) 
            return count;

        if(dp[index][tight][count] != null) 
            return dp[index][tight][count];

        int limit = (tight == 1) ? s.charAt(index) - '0' : 9; 
        int result = 0;

        for(int i=0; i<=limit; i++) {
            int updatedCount = count + (i == 1 ? 1 : 0); 
            int updateLimit = (tight == 1 && i == limit) ? 1 : 0;
            result += recursion(s, index+1, updateLimit , updatedCount, dp);
        }

        return dp[index][tight][count] = result;

    }
}