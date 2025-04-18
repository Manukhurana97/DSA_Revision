// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/

public class CountNumberOfPairsWithAbsoluteDifferenceK{
    
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int i: nums) {
            count += map.getOrDefault(i - k, 0);
            count += map.getOrDefault(i + k, 0);

            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return count;
    }
}