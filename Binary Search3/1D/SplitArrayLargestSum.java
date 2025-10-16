// https://leetcode.com/problems/split-array-largest-sum/


public class SplitArrayLargestSum {

	public int canSplitInK(int mid, int[] nums, int k) {
        int count = 1, sum = 0;
        
        for(int i: nums) {
            if(sum + i <= mid) {
                sum +=i;
            } else{
                sum = i;
                count++;
            }
        }

        return count;
    }


    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;

        for(int i: nums) {
            left = Math.max(left, i);
            right += i;
        }

        if(k == 1) return right;
        if(k==nums.length) return left;
        if(k>nums.length) return -1;
        
        int ans = -1;
        while(left<=right) {
            int mid = (left + right) /2;
            int split = canSplitInK(mid, nums, k);

            if(split > k) {
                left = mid+1;
            } else{
                ans = mid;
                right = mid-1;
            }
        }

        return ans;
    }


	public static void main(String[] args) {
		int[] arr = {7,2,5,10,8};
		int[] arr1 = {1,2,3,4,5};

		System.out.println(splitArray(arr, 2));
		System.out.println(splitArray(arr1, 2));

		System.out.println(splitArray(arr, 2));
		System.out.println(splitArray(arr1, 2));

	}
}