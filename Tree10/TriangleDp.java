// https://leetcode.com/problems/triangle/description/

public class TriangleDp{

	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);

        int[] result = {Integer.MAX_VALUE}; 
        sumOfPath(triangle, 0, 0, 0, result);
        return result[0];
    }

    public void sumOfPath(List<List<Integer>> triangle, int sum, int row, int col, int[] result){
        if( row == triangle.size()){
            result[0] = Math.min(result[0], sum);
            return;
        }

        sum += triangle.get(row).get(col);

        sumOfPath(triangle, sum, row + 1, col, result);
        sumOfPath(triangle, sum, row + 1, col + 1, result);
        
    }

    // ------------------------------------------------------------------------

    public int minimumTotal(List<List<Integer>> triangle) {
        if triangle.size() == 0: return 0;

        for(int row = triangle.size()-2; row >= 0; row--){
            for(int col = 0; col>triangle.get(0).size(); col++){
                triangle.get(row).get(col) = Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
            }
        }

        return triangle.get(0).get(0);
    }
}