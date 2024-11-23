public class NumberOfDistinctIslands{
	public int countDistinctIslands(int[][] grid) {
        // if we somehow make all the coordinates generalize , it will be just a == b

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> uniqueIslands = new HashSet<>();
        int count = 0;

        for(int r = 0; r < rows; r++){
        	for(int c = 0; c < cols; c++){
        		if(grid[r][c] == 1 && !visited[r][c]){
        			StringBuilder islandCord = new StringBuilder();
        			dfs(r, c, grid, visited, r, c, islandCord);
        			uniqueIslands.add(islandCord.toString());
        		}
        	}
        }

        return uniqueIslands.size();
    }


    public void dfs(int r, int c, int[][] grid, boolean[][] visited, int baseR, int baseC, StringBuilder islandCord){
    	if(r<0 || c<0 || r>=grid.length || c>=grid[r].length || grid[r][c] == 0 || visited[r][c]) return;

    	visited[r][c] = true;
    	islandCord.append((r - baseR) + "," + (c - baseC) + " ");


    	dfs(r-1, c, grid, visited, baseR, baseC, islandCord);
    	dfs(r, c-1, grid, visited, baseR, baseC, islandCord);
    	dfs(r+1, c, grid, visited, baseR, baseC, islandCord);
    	dfs(r, c+1, grid, visited, baseR, baseC, islandCord);
    }
}