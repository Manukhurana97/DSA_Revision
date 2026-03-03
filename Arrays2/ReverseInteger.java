// https://leetcode.com/problems/reverse-integer/

public class ReverseInteger {
	public int reverse(int x) {
        long n = (long) x;
        boolean isNeg = false;
        if(n<0) {
            isNeg = true;
            n *=-1;
        }

        long mirror = 0;
        while(n > 0) {
            mirror = mirror * 10 + n % 10;
            n /= 10;

            if(mirror > Integer.MAX_VALUE) return 0;
        }

        retu
}