// https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

public class NumberofPairsofStringsWithConcatenationEqualtoTarget {

	// brute force : Time O(n^2), Space: O(1)
    public int numOfPairs(String[] nums, String target) {
        int n = nums.length, count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j){
                    count += ((nums[i] + nums[j]).equals(target) ? 1: 0);
                }
            }
        }

        return count;
    }



    public int numOfPairs(String[] nums, String target) {
        int n = nums.length, count = 0;

        Map<String, Integer> map = new HashMap<>();
        for(String num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(String i: nums) {
            if(target.startsWith(i)){
                String s = target.substring(i.length());
                if(map.containsKey(s)) {
                    count += map.get(s);
                    if(i.equals(s)) count-=1;
                }
            }
        }

        return count;
    }

}