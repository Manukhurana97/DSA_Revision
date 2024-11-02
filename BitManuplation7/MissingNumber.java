public class MissingNumber{
	public int missingNumber(int[] nums) {
        int sum = 0, total = 0;

        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
            total+=i+1;
        }

        return total-sum;
    }


    public int missingNumber(int[] nums) {
        int sum = 0, total = 0, n = nums.length;

        total = n * (n+1) / 2;

        for(int i : nums)
            sum+=i;

        return total-sum;
    }
}