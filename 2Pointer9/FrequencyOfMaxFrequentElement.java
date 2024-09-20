public class FrequencyOfMaxFrequentElement{
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