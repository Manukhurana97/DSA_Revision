// https://leetcode.com/problems/frequency-of-the-most-frequent-element/

public class FrequencyOfMaxFrequentElement{

   public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int result = 1, n = nums.length;

        for(int i=n-1; i>=0; i--){
            int count = 1;

            for(int j=i-1; j>=0; j--){
                int remaining = nums[i] - nums[j];
                
                if(k>=remaining){
                    count +=1;
                    k-=remaining;
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }

    

	public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int current = 0, last = 0, n = nums.length;
        long total = 0, maxFreq = 1; 

        while(current < n){
            total += nums[current];
            
            // current * len > totalSum + k
            while(((current - last + 1L) * nums[current]) > (total + k)){
               total -= nums[last++];
            }

            maxFreq = Math.max(maxFreq, current - last + 1L);
            current++;
        }

        return (int) maxFreq;
    }
}