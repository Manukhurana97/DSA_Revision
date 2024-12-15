// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

public class LongestIncreasingPathInMatrix{
	public int longestIncreasingPath(int[][] matrix) {
        int longestPathlen = 0;
        int[][] visited = new int[matrix.length][matrix[0].length];

        for(int r=0; r<matrix.length;r++){
            for(int c=0; c<matrix[0].length;c++){
                longestPathlen = Math.max(longestPathlen, dfs(r, c, -1, matrix, visited));
            }
        }

        return longestPathlen;
    }

    public int dfs(int r, int c, int prevVal, int[][] matrix, int[][] visited){
        if(r<0 || c<0 || r>=matrix.length || c>=matrix[0].length || matrix[r][c] <= prevVal) return 0;
        // if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] <= prevVal) return 0;


        if(visited[r][c] > 0) return visited[r][c];

        int res = 1;

        res = Math.max(res, 1 + dfs(r-1, c, matrix[r][c], matrix, visited));
        res = Math.max(res, 1 + dfs(r, c-1, matrix[r][c], matrix, visited));
        res = Math.max(res, 1 + dfs(r+1, c, matrix[r][c], matrix, visited));
        res = Math.max(res, 1 + dfs(r, c+1, matrix[r][c], matrix, visited));

        visited[r][c] = res;
        return res;
    }
}