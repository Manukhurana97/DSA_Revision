// https://leetcode.com/problems/remove-element/

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        int n = nums.length, current = 0, valIndex = 0;

        if(n==0) return 0;

        // get the first element with nums[i] == val
        while(current < n && nums[current] != val) current ++;
        if(current == n) return n; // if there are no element equals to val

        valIndex = current;
        while(current < n) {
            if(nums[current] != val){
                nums[valIndex] = nums[current];
                nums[current] = val;
                valIndex+=1;
            }

            current += 1;
        }

        return valIndex;
    }
}