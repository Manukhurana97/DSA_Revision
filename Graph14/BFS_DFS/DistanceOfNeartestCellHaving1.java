public DistanceOfNeartestCellHaving1{
	public int[][] nearest(int[][] grid){
    	int rows = grid.length;
    	int cols = grid[0].length;
        
        int[][] visited = new int[rows][cols];
        int[][] distance = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // get all the cells has value 1
        for(int r = 0;r < rows; r++){
        	for(int c = 0; c < cols; c++){
        		if(grid[r][c] == 1){
        			queue.add(new int[]{r, c, 0});
        			visited[r][c] = 1;
        		}
        	}
        }

        // perform bfs of cells with 1 , rest all has distane =  index + 1

        while(!queue.isEmpty()){

        	int[] current = queue.poll();
        	int r = current[0];
        	int c = current[1];
        	int l = current[2];

        	if(r - 1 >= 0 && visited[r - 1][c] == 0) {
        		visited[r - 1][c] = 1;
        		distance[r - 1][c] = l + 1;
        	    queue.add(new int[]{r - 1, c, l + 1});
        	}
        	if(c - 1 >= 0 && visited[r][c - 1] == 0) {
        		visited[r][c - 1] = 1;
        		distance[r][c - 1] = l + 1;
        		queue.add(new int[]{r , c - 1, l + 1});
        	}
        	if(r + 1 < rows && visited[r + 1][c] == 0) {
        		visited[r + 1][c] =  1;
        		distance[r + 1][c] = l + 1;
        		queue.add(new int[]{r + 1, c, l + 1});
        	}
        	if(c + 1 < cols && visited[r][c + 1] == 0) {
        		visited[r ][c + 1] = 1;
        		distance[r][c + 1] = l + 1;
        		queue.add(new int[]{r , c + 1, l + 1});
        	}
        }

        return distance;
    }
}