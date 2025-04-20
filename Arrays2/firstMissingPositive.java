// https://leetcode.com/problems/first-missing-positive/

public class firstMissingPositive{

    // brute force : Time O(n+maxElement), Space: O(n)
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxElement = Integer.MIN_VALUE;

        for(int i: nums){
            set.add(i);
            maxElement = Math.max(maxElement, i);
        }

        if(maxElement<0) return 1;

        for(int i=1; i<=maxElement; i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return maxElement+1;
    }


    // Time : O(n), Space: O(n)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int i: nums){
            set.add(i);
        }

        for(int i=1; i<=n; i++){
            if(!set.contains(i)) return i;
        }

        return n+1;
    }


    // Time : O(n), Space: O(1)

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace all zero or negative numbers with n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Mark the presence of values in the range [1, n]
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                if (nums[val - 1] > 0) { // to work with 0 base
                    nums[val - 1] *= -1; // to work with 0 base
                }
            }
        }

        // Step 3: Find the first index i such that nums[i] > 0
        for (int i = 0; i <n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}