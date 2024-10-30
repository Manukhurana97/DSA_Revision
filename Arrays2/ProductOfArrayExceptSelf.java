public class ProductOfArrayExceptSelf{

	public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int product = 1;
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    product *= nums[j];
                }
            }
            result[i] = product;
        }

        return result;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        prefix[0] = 1;
        int[] postfix = new int[n];
        postfix[n - 1] = 1;
        
        for(int i = 1; i < n; i++) prefix[i] = prefix[i-1] * nums[i-1];
        for(int i = n - 2; i >= 0; i--) postfix[i] = postfix[i+1] * nums[i+1];

        for(int i = 0; i < n; i++){
            result[i] = prefix[i]*postfix[i];
        }
        

        return result;
    }


    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int prefix = 1;
        for(int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i = n - 1; i >= 0; i--){ 
           result[i] *= postfix;
            postfix *= nums[i];
        }
        
        return result;
    }
}