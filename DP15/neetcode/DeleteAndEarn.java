// https://leetcode.com/problems/delete-and-earn/

public class DeleteAndEarn{

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ind = 0;
        int[] arr = new int[map.size()];
        for(int i: map.keySet()){
            arr[ind++] = i;
        }

        Arrays.sort(arr);

        int[] dp = new int[map.size()];

        // return recursion(map.size()-1, arr, map, dp);

        // return tabulation(arr, map, dp);

        return spaceOptimization(arr, map);
    }

    private int recursion(int i, int[] nums, Map<Integer, Integer> map, int[] dp){
        if(i<0) return 0;

        int take = nums[i] * map.get(nums[i]);
        take += (i>0 && nums[i] - nums[i-1] == 1) ? recursion(i-2, nums, map, dp) : recursion(i-1, nums, map, dp);

        int notTake = recursion(i-1, nums, map, dp);

        return dp[i] = Math.max(take, notTake);
    }


    private int tabulation(int[] nums, Map<Integer, Integer> map, int[] dp){
        int n = nums.length;

        dp[0] = nums[0] * map.get(nums[0]);

        for (int i = 1; i < n; i++) {
            int take = nums[i] * map.get(nums[i]);
            
            if(nums[i] - nums[i-1] == 1){
                take += (i-2 >= 0) ? dp[i-2] : 0;
            }else{
                take += dp[i-1];
            }
            
            int notTake = dp[i-1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[n-1];
    }


    private int spaceOptimization(int[] nums, Map<Integer, Integer> map){
        int n = nums.length, prev2 = 0, prev = 0;

        prev = nums[0] * map.get(nums[0]);

        for (int i = 1; i < n; i++) {
            int take = nums[i] * map.get(nums[i]);
            
            if(nums[i] - nums[i-1] == 1){
                take += (i-2 >= 0) ? prev2 : 0;
            }else{
                take += prev;
            }
            
            int notTake = prev;

            int curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}