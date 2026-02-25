// https://leetcode.com/problems/search-insert-position

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        
        if(target < nums[0]) return 0;
        if(target > nums[nums.length - 1]) return nums.length;

        return search (0, nums.length-1, nums, target);
    }

    private int search(int left, int right, int[] nums, int target) {
    
        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) return mid;
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1; 
        }

        return left; 
    }
}
