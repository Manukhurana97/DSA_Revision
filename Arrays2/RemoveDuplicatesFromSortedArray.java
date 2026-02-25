// leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        int prev = 1, current = 1, n = nums.length;

        while(current < n) {
            if(nums[prev-1] != nums[current]) {
                nums[prev] = nums[current];
                prev++;
            }
            current += 1;
        }

        return prev;
    }
}
