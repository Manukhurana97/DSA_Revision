// https://leetcode.com/problems/counting-bits/description/

public class CountingBits{
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for(int i=1; i<=n; i++){
            int count = 0 ;
            int j = i;
            while(j>0){
                count += j&1;
                j>>>=1;
            }

            result[i] += count;
        }

        return result;
    }
}