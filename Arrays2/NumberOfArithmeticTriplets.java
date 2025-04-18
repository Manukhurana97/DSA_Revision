// https://leetcode.com/problems/number-of-arithmetic-triplets/

public class NumberOfArithmeticTriplets{

	public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length, count = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[j] - nums[i] == diff){
                    for(int k=j+1; k<n; k++){
                        if(nums[k] - nums[j] == diff){
                            count += 1;
                        }
                    }
                }
            }
        }

        return count;
    }


    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length, count = 0;

        for(int i = 0; i < n; i++){
            int left = i + 1, right = n - 1;

            while(left < right){
                while(left < right && nums[left] - nums[i] < diff) left++;
                if(left == right || nums[left] - nums[i] != diff) break;

                while(left < right && nums[right] - nums[left] > diff) right--;
                if(left == right || nums[right] - nums[left] != diff) break;

                count += (nums[left] - nums[i] == diff && nums[right] - nums[left] == diff) ? 1 : 0;
                left +=1;
                right -=1;
            }
        }

        return count;
    }


    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length, count = 0;
        Set<Integer> set = new HashSet<>();

        for(int i: nums) set.add(i);
        
        for(int i: nums){
            if(set.contains(i+diff) && set.contains(i+2*diff)){
                count +=1;
            }
        }

        return count;
    }

}