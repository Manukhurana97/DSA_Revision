// https://leetcode.com/problems/unique-binary-search-trees-ii/

public class UniqueNumberOfBinaryTrees2{
	public List<TreeNode> generateTrees(int n) {
        return recursion(1, n);
    }

    private List<TreeNode> recursion(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        
        if(start>end){ 
            result.add(null);
            return result;    
        }
        

        for(int i=start; i<=end; i++) {
            List<TreeNode> left = recursion(start, i-1);
            List<TreeNode> right = recursion(i+1, end);

            for(var l: left) {
                for(var r: right) {
                    result.add(new TreeNode(i, l, r));
                }
            }
        }

        return result;
    }    
}