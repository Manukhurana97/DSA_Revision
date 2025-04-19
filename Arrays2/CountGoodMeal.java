// https://leetcode.com/problems/count-good-meals/

public class GoodMeal{

    public int countPairs(int[] deliciousness) {
        int count = 0, n = deliciousness.length;
        int mod = 1_000_000_007;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int val = (deliciousness[i] + deliciousness[j])%mod;
                if(isPowerOfTwo(val)){
                    count+=1;
                }
            }
        }

        return count;
    }

    
    private boolean isPowerOfTwo(int val){
        int count = 0;
        while(val!=0 && count<2){
            count += val&1;
            val>>>=1;
        }

        return count==1;
    }

// -----------------------------------------------------------------------
    

    public int countPairs(int[] deliciousness) {
        int count = 0, n = deliciousness.length;
        int mod = 1_000_000_007;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i: deliciousness) {
            for(int j=1; j<=(1<<21); j<<=1){
                int rem = j - i;
                count = (count + map.getOrDefault(rem, 0)) % mod;
            }

            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return count;
    }   
}