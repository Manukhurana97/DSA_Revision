// https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
public class MinimumNumberOfDaysToEatNOranges {
    
    public int minDays(int n) {

        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return recursion(n, dp);

        // Map<Integer, Integer> map = new HashMap<>();
        // return recursion1(n, map);

        // return tabulation(n);

        return tabulation1(n);

    }

    // recursion + memoization
    private int recursion(int n, int[] dp){
        if(n < 0) return Integer.MAX_VALUE;
        if(n == 0) return 0;
        if(n==1) return 1;

        if(dp[n] != -1) return dp[n];
    
        int three = n>=3 && n%3 == 0 ? recursion(n - 2*(n/3), dp) : Integer.MAX_VALUE;
        int two = n>=2 && n%2 == 0 ? recursion(n/2, dp) : Integer.MAX_VALUE;
        int one = recursion(n-1, dp);    

        return dp[n] = 1 + Math.min(one, Math.min(two, three));
    }


    // to solve Memory Limit Error
    private int recursion1(int n, Map<Integer, Integer> map){
        if(n < 0) return Integer.MAX_VALUE;
        if(n==0) return 0;
        if(n==1) return 1;

        if (map.containsKey(n)) {
            return map.get(n); 
        }
    
        int three = n>=3 && n%3 == 0 ? recursion1(n - 2*(n/3), map) : Integer.MAX_VALUE;
        int two = n>=2 && n%2 == 0 ? recursion1(n/2, map) : Integer.MAX_VALUE;
        int one = recursion1(n-1, map);    

        int result = 1 + Math.min(one, Math.min(two, three));
        map.put(n, result);

        return result;
    }


    private int tabulation(int i){

        int[] dp = new int[i+1];

        for(int n=1; n<=i; n++){
            int three = n>=3 && n%3 == 0 ? dp[n - 2*(n/3)] : Integer.MAX_VALUE;
            int two = n>=2 && n%2 == 0 ? dp[n/2] : Integer.MAX_VALUE;
            int one = dp[n-1];    

            dp[n] = 1 + Math.min(one, Math.min(two, three));
        }

        return dp[i];
    }


    private int tabulation1(int i){

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);

        for(int n=1; n<=i; n++){
            int three = n>=3 && n%3 == 0 ? map.get(n - 2*(n/3)) : Integer.MAX_VALUE;
            int two = n>=2 && n%2 == 0 ? map.get(n/2) : Integer.MAX_VALUE;
            int one = map.get(n-1);    

            map.put(n, 1 + Math.min(one, Math.min(two, three)));
        }

        return map.get(i);
    }
    
}