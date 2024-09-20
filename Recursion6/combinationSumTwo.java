import java.util.*;

public class combinationSumTwo{
	 public static void combinationSum2(int[] candidates, int target, int index, List<Integer> arr, List<List<Integer>> result){
        
        if(target == 0) {
            result.add(new ArrayList<>(arr));
            return;
        }

        // if out of bound or target is negative
        if(index >= candidates.length || target < 0) return;

        for( int i = index; i<candidates.length; i++){
            
            // Skip duplicates
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) break;
            
            // Include current candidate
            arr.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, arr, result);
            // Backtrack
            arr.remove(arr.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // to avoid duplicate , sort
        combinationSum2(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        System.out.println(combinationSum2(candidates, target));
    }
}