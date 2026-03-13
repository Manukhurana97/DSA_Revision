// https://leetcode.com/problems/combinations/

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        recursion(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public void recursion(int i, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if(list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int j=i; j<=n; j++) {
            list.add(j);
            recursion(j+1, n, k, list, result);
            list.remove(list.size()-1);
        }
    }
}