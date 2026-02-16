// https://leetcode.com/problems/water-and-jug-problem/

public class WaterAndJug {
    public boolean canMeasureWater(int x, int y, int target) {
        if(x == target || y == target || x+y == target || target == 0) return true;
        if(x+y < target) return false;
        

        // Bézout’s Identity
        // d = gcd(a,b);
        // ax + by = d

        // gcd(x,y) = target

        return target % gcd(x, y) == 0;
    }

    public int gcd(int a, int b) {
        while(b != 0 ) {
            int temp = b;
            b = a%b;
            a = temp;
        }

        return a;
    }
}