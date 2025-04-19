// https://leetcode.com/problems/3sum-closest/description


public class 3SumClosest{
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, closestVal=0, closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0; i<n-2; i++) {
            int left = i+1, right = nums.length-1;

            while(left < right){
                int val = nums[i] + nums[left] + nums[right];
               
                if(closestSum > Math.abs(target - val)) {
                    closestSum =  Math.abs(target - val);
                    closestVal = val;
                }
                

                if(val > target) right-=1;
                else left++;
            }
        }

        return closestVal;
    }
}