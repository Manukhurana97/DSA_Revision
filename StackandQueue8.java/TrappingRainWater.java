public class TrappingRainWater{
	// Time :O(2N) -> O(N)
    // Space : O(N)

    // approach 1: total +=  min(leftmax, rightmax) - currentHeight
    // 3 0 0 2 0 4 :: lm : 3 3 3 3 3 4, rm: 4 : 4 4 4 4 4  : 
    public int trap(int[] height) {
        
        int n = height.length;
        int leftmax = 0;
        Stack<Integer> leftStack = new Stack<>();

        for(int i=0; i<n; i++){
            leftmax = Math.max(leftmax, height[i]);
            leftStack.push(leftmax);
        }
        
        int rightmax = 0;
        int trappedWater =0;
        for(int i=0; i<n; i++){
            rightmax = Math.max(rightmax, height[n-i-1]);
            trappedWater += Math.min(leftStack.pop(), rightmax) - height[i];
        }
        
        return trappedWater;
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