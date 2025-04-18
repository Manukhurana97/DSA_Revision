// https://leetcode.com/problems/count-good-meals/

public class GoodMeal{

	public int countPairs(int[] deliciousness) {
        int count = 0, n = deliciousness.length;
        int mod = 100_000_007;

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



    public int countPairs(int[] deliciousness) {
        int count = 0, n = deliciousness.length;
        int mod = 1_000_000_007;


        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int val = deliciousness[i], j=1;
            
            while(Math.pow(2, j) < val){
                j++;
            }


            if(map.containsKey(Math.pow(2, j) - val)){
                count += map.get(Math.pow(2, j) - val);
            }

            map.put(val, map.getOrDefault(val, 0)+1);
        }
        

        return count;
    }
}