// https://leetcode.com/problems/find-subarrays-with-equal-sum/description/

public class FindSubarraysWithEqualSum{
	public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int i=1; i<n; i++){
            if(set.contains(nums[i] + nums[i-1])) return true;

            set.add(nums[i] + nums[i-1]);
        }

        return false;
    }
}