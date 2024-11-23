public class NumberOfEnclaves{

	public int numberOfEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // mark visited to all the nodes on or adjacent to boundry .
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
            	if((r == 0 || c == 0 || r == rows-1 || c == cols - 1) && !visited[r][c])
        			dfs(r, c, grid, visited);


        // count all the unvisited notes
        int count = 0;
        for(int r = 0; r < rows; r++)
        	for(int c = 0; c < cols; c++)
        		if(grid[r][c] == 1 && !visited[r][c])
        			count += 1;
        		
        return count;
    }


    public void dfs(int r, int c, int[][] grid, boolean[][] visited){
    	if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) return ;

    	visited[r][c] = true;

    	dfs(r-1, c, grid, visited);
    	dfs(r, c-1, grid, visited);
    	dfs(r+1, c, grid, visited);
    	dfs(r, c+1, grid, visited);

    }

}