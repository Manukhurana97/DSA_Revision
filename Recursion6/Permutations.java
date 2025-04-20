// https://leetcode.com/problems/permutations/

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(0, nums, result);
        return result;
    }

    public void recursion(int j, int[] nums, List<List<Integer>> result){
        if(j==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i: nums) list.add(i);
            result.add(new ArrayList<>(list)); // deep copy
            return;
        }

        for(int i=j; i<nums.length; i++){
            swap(j, i, nums);
            recursion(j+1, nums,  result);
            swap(j, i, nums);
        }

        
    }

    public void swap(int to, int from , int[] nums){
        int temp = nums[to];
        nums[to] = nums[from];
        nums[from] = temp;
    }


    // --------------------------------------------------------------------------------

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums, new ArrayList<Integer>(), result);
        return result;
    }

    private void recursion(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list)); // deep copy
            return;
        }
        
        for(int j=0; j<nums.length; j++){
            if(list.contains(nums[j])) continue;
            list.add(nums[j]);
            recursion(nums, list, result);
            list.remove(list.size()-1);
        }
        
    }
}