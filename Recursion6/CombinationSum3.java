// https://leetcode.com/problems/combination-sum-iii/

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(1, k, n, new ArrayList<>(), result);
        return result;
    }

    public void recursion(int i, int k, int n, List<Integer> list, List<List<Integer>> result){
        if(list.size() == k){
            if(n == 0) result.add(new ArrayList<>(list));
            return;
        }

        
        for(int c=i; c<10; c++){
            if(n >=c) {
                list.add(c);
                recursion(c+1, k, n-c, list, result);
                list.remove(list.size()-1);
            }
        }
        
    }
}