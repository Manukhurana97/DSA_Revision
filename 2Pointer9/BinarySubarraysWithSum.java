// https://leetcode.com/problems/binary-subarrays-with-sum/description/

public class BinarySubarraysWithSum{


	// 2 for loop
	public int numSubarraysWithSum(int[] nums, int goal) {
        
        int result = 0, n = nums.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                result += (sum == goal) ? 1: 0;
            }
        }

        return result;
    }

    // ------------------------------------------------------------------------------


    // find (subarray of goals) - (subarray of goals - 1)
	public int numSubarraysWithSum1(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, (goal - 1));        
    }


    public int atMost(int[] nums, int goal){

        if(goal < 0 ) return 0;

        int left = 0, current = 0, n = nums.length, sum = 0, count = 0;

        while(current<n){
            sum += nums[current];

            while(left <= current && sum > goal) sum -= nums[left++];

            count += current - left + 1;
            current++;
            
        }

        return count;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum obj = new BinarySubarraysWithSum();
        int[] arr = {1,0,1,0,1};
        System.out.println(obj.numSubarraysWithSum(arr, 2));

    }
}