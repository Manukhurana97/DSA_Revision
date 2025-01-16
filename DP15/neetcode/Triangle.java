// https://leetcode.com/problems/triangle/description/

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        // return recursion(0, 0, triangle);
        int[][] dp = new int[triangle.size()+1][triangle.get(triangle.size()-1).size()+1];
        // return memoization(0, 0, triangle, dp);

        // return tabulation(triangle, dp);

        return spaceOptimization(triangle);
    }
    

    public int recursion(int r, int c, List<List<Integer>> triangle) {

        if(c >= triangle.get(r).size()) return Integer.MAX_VALUE;
        if(r == triangle.size()-1) return triangle.get(r).get(c);
        
        int down = recursion(r+1, c, triangle);
        int downLeft = recursion(r+1, c+1, triangle);

        return triangle.get(r).get(c) + Math.min(down, downLeft);
    }


    public int memoization(int r, int c, List<List<Integer>> triangle, int[][] dp) {

        if(c >= triangle.get(r).size()) return Integer.MAX_VALUE;
        if(r == triangle.size()-1) return triangle.get(r).get(c);

        if(dp[r][c] != 0) return dp[r][c];
        
        int down = memoization(r+1, c, triangle, dp);
        int downLeft = memoization(r+1, c+1, triangle, dp);

        return dp[r][c] = triangle.get(r).get(c) + Math.min(down, downLeft);
    }


    public int tabulation( List<List<Integer>> triangle, int[][] dp) {
        int rows = triangle.size(), cols = triangle.get(triangle.size()-1).size();

        for(int c=0; c<cols; c++){
            dp[rows-1][c] = triangle.get(rows-1).get(c);
        }
        
        for(int r=rows-2; r>=0; r--){
            for(int c=triangle.get(r).size()-1; c>=0; c--){
                int down = dp[r+1][c];
                int downLeft = c+1 > triangle.get(r).size() ? Integer.MAX_VALUE :  dp[r+1][c+1];

                dp[r][c] = triangle.get(r).get(c) + Math.min(down, downLeft);
            }
        }        
        
        return dp[0][0];
    }


    public int spaceOptimization( List<List<Integer>> triangle) {
        int rows = triangle.size(), cols = triangle.get(triangle.size()-1).size();

        int[] prev = new int[cols+1];

        for(int c=0; c<cols; c++){
            prev[c] = triangle.get(rows-1).get(c);
        }
        
        for(int r=rows-2; r>=0; r--){
            int[] curr = new int[cols+1];
            for(int c=triangle.get(r).size()-1; c>=0; c--){
                int down = prev[c];
                int downLeft = c+1 > triangle.get(r).size() ? Integer.MAX_VALUE :  prev[c+1];

                curr[c] = triangle.get(r).get(c) + Math.min(down, downLeft);
            }
            prev = curr;
        }        
        
        return prev[0];
    }
}