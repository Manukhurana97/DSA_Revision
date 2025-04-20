// https://leetcode.com/problems/permutations-ii/

public class Permutations2 {
	ublic List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if(nums.length == 0) return result;

        recursion(0, nums, result, set);

        return result;
    }

    private void recursion(int i, int[] nums, List<List<Integer>> result, Set<List<Integer>> set){
        if(i == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num: nums) list.add(num);
            if(!set.contains(list)){
                result.add(new ArrayList<>(list));
                set.add(list);
            }
            return;
        }


        for(int j=i; j<nums.length; j++){
            nums = swap(i, j, nums);
            recursion(i+1, nums, result, set);
            nums = swap(i, j, nums);
        }
    }

    private int[] swap(int from, int to, int[] nums) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
        
        return nums;
    }



    // -------------------------------------------------------- Without Set ---------------------------------------------------------------

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        Arrays.sort(nums);

        if(nums.length == 0) return result;

        recursion(nums, new ArrayList<>(), result, used);

        return result;
    }

    private void recursion(int[] nums, List<Integer> list,  List<List<Integer>> result, boolean[] used){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }


        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;

            used[i] = true;
            list.add(nums[i]);
            recursion(nums, list, result, used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}