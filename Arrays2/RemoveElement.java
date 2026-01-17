// https://leetcode.com/problems/remove-element/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0,n = nums.length;

        // get first elemenet with is equals to val
        while(i<n) {
            if(nums[i] == val) 
                break;
            i++;
        }

        int j = i+1;
        while(j<n) {
            if(nums[j] != val) {
                nums[i] = nums[j]; // replace the value
                i++;
            }
            j++;
        }

        return i;
    }
}