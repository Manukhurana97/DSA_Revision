// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class RemoveDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int val = nums[0], count = 0, replaceIndex = -1;

        for(int i=0; i<n; i++) {
            if(val == nums[i] && count + 1 > 2) {
                if(replaceIndex == -1) replaceIndex = i;
                continue;
            } else {
                if(val != nums[i]) {
                    val = nums[i];
                    count = 0;
                }
                if(replaceIndex != - 1) {
                    nums[replaceIndex] = nums[i];
                    replaceIndex++;
                } 
                count++;
            }
        }

        return replaceIndex == -1 ? nums.length : replaceIndex;
    }
}