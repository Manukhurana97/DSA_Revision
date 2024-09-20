public class SubArraysWithKDifferentIntegers{
	 public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    public int atMostKDistinct(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int current  = 0, last = 0, n = nums.length, result = 0;

        while(current < n){
           var value = nums[current];
            map.put(value, map.getOrDefault(value, 0) + 1);

            while(map.size()>k){
                var leftVal = nums[last]; 
                map.put(leftVal, map.get(leftVal)-1);

                if(map.get(leftVal) == 0) map.remove(leftVal);
                last+=1;
            }

            result += current - last + 1;
            current += 1;
        }

        return result;
    }
}