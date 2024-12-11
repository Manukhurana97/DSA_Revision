// https://leetcode.com/problems/pacific-atlantic-water-flow/

public class PacificAndAtlantic{
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            dfs(r, 0,  heights[r][0], heights, pac); // Left border for Pacific
            dfs(r, cols-1, heights[r][cols - 1], heights, atl); // Right border for Atlantic
        }

        for(int c=0; c<cols; c++){
            dfs(0, c,  heights[0][c], heights, pac); // Top border for Pacific
            dfs(rows - 1, c , heights[rows-1][c], heights, atl); // Bottom border for Atlantic
        }


        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) {
                    List<Integer> aux = new ArrayList<>();
                    aux.add(r); // Add row index
                    aux.add(c); // Add column index
                    result.add(aux);
                }
            }
        }

        return result;
    }


    public void dfs(int r, int c, int preVal, int[][] heights, boolean[][] visited){
        if(r<0 || c<0 || r>=heights.length || c>= heights[r].length || heights[r][c] < preVal || visited[r][c]) return;

        visited[r][c] = true;

        dfs(r+1, c, heights[r][c], heights, visited);
        dfs(r-1, c, heights[r][c], heights, visited);
        dfs(r, c+1, heights[r][c], heights, visited);
        dfs(r, c-1, heights[r][c], heights, visited);
    }
}