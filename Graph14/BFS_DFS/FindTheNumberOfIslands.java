public class FindTheNumberOfIslands{

	public int numIslands(char[][] grid) {
		int noofIslands = 0, row = grid.length, col = grid[0].length;

		for(int r = 0; r < row; r++){
			for(int c = 0; c < col; c++){
				if(grid[r][c] == '1'){
					noofIslands+=1;
					dfs(r, c, grid);
				}
			}
		}

		return noofIslands;
	}


	public void bfs(int row, int col, char[][] grid){
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{row, col});

		while(!queue.isEmpty()){
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];

			grid[r][c] = '2';

			if(r - 1 >= 0 && grid[r-1][c] == '1') queue.add(new int[]{r-1, c});
			if(c - 1 >= 0 && grid[r][c-1] == '1') queue.add(new int[]{r, c-1});
			if(r + 1 < grid.length && grid[r+1][c] == '1') queue.add(new int[]{r+1, c});
			if(c + 1 < grid[0].length && grid[r][c+1] == '1') queue.add(new int[]{r, c+1});

		}
	}


	public void dfs(int row, int col, char[][] grid){
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') return;

		grid[row][col] = '2';

		dfs(row-1, col, grid);
		dfs(row, col-1, grid);
		dfs(row+1, col, grid);
		dfs(row, col+1, grid);
	}
}