// https://leetcode.com/problems/power-of-four/

public class PowerOf4{
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;

        return dfs(n, 1);
    }

    public boolean dfs(int n, int p) {
        if(n == p) return true;
        if(p > n || p<=0 ) return false;

        return dfs(n, 4*p);
    }
}