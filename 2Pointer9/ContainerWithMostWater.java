public class ContainerWithMostWater{
	public int maxArea(int[] height) {
        int result = 0, n = height.length;

        for(int i = 0; i < n; i++){
            for(int j = 1; j < n; j++){
                result = Math.max(result, Math.min(height[i], height[j]) * (j-i) );
            }
        }

        return result;
    }



    public int maxArea(int[] height) {
        int result = 0, n = height.length;
        int left = 0, right = n-1;

        while(left <  right){
            result = Math.max(result, Math.min(height[right], height[left]) * (right-left));

            if(height[left] > height[right]){
                right -= 1;
            }else{
                left+=1;
            }
            
        }

        return result;
    }
}