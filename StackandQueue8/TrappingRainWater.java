// https://leetcode.com/problems/trapping-rain-water/

public class TrappingRainWater{
	// Time :O(2N) -> O(N)
    // Space : O(N)

    // approach 1: total +=  min(leftmax, rightmax) - currentHeight
    // 3 0 0 2 0 4 :: lm : 3 3 3 3 3 4, rm: 4 : 4 4 4 4 4  : 
    public int trap(int[] nums) {
        int n = nums.length;

        int leftMax = 0;        
        int[] leftval = new int[n];

        for(int i=0; i<n; i++){
            leftMax = Math.max(leftMax, nums[i]);
            leftval[i] = leftMax;
        }

        int total = 0;
        int rightMax = 0;
        for(int i=n-1; i>=0; i--){
           rightMax = Math.max(rightMax, nums[i]);
           total += Math.min(leftval[i], rightMax) - nums[i];
        }

        return total;
    }


    public int trap(int[] height) {

        int  left = 0, right =  height.length-1;
        int leftmax = 0, rightmax = 0;
        int trappedWater =0;

        while(left <= right){
            if(height[left] < height[right]){
                if(height[left] > leftmax){
                    leftmax = height[left];
                }else{
                    trappedWater += leftmax - height[left];
                }
                
                left++;
            }else{
                if(height[right] > rightmax){
                    rightmax = height[right];
                }else{
                    trappedWater += rightmax - height[right];
                }
                right--;
            }
        }     

        return trappedWater;
    }
}