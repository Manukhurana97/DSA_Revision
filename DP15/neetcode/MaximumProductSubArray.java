public class MaximumProductSubArray{
	public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1, sufix=1, result = Integer.MIN_VALUE;
        
        for(int i=0;i<n; i++){
            
           prefix = (prefix != 0 ? prefix : 1) * nums[i];
           sufix = (sufix != 0 ? sufix : 1) * nums[n-i-1];

            result = Math.max(result, Math.max(prefix, sufix));
        }

        return result;
    }
}