// https://leetcode.com/problems/count-number-of-nice-subarrays/description/

public class CountNumberOfNiceSubArray{

	// find (subarray of goals) - (subarray of goals - 1)
	public int numberOfSubarrays(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k-1);
    }

    public int atMost(int[] nums, int k){
        int i = 0, j = 0, n = nums.length, count = 0, result = 0;
        
        while(j < n){
            count+= ((nums[j] & 1) == 1) ? 1 : 0;
            
            while(i<=j && count>k){
                count -= ((nums[i++] & 1) == 1) ? 1 : 0;
            }

            result += j - i + 1;
            j++;
        }

        return result;
    }

}