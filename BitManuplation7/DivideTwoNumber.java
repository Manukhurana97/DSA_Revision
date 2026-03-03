// https://leetcode.com/problems/divide-two-integers/

public class DivideTwoNumber{
    public int divide(int a, int b) {
        if(a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
    
        long dividend = Math.abs((long) a), divisor = Math.abs((long) b);
        long count = 0;
        while(dividend >= divisor) {
            long temp = divisor;
            long multiple = 1;

            while(dividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dividend -= temp;
            count += multiple;
        }

        boolean isNeg = (a<0) ^ (b<0);
        return isNeg ? (int)(-count) : (int)(count);
    }
}