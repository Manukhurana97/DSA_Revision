public class ShortestDistanceInBinaryMaze{
	public int shortestPath(int[][] grid, int[] source, int[] destination) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] distance = new int[rows][cols];
    
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                distance[r][c] = Integer.MAX_VALUE;
            }
        }
        
        distance[source[0]][source[1]] = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{source[0], source[1], 0});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int wt = current[2];
            
            if (r == destination[0] && c == destination[1]) return wt;
            
            
            
            if(r-1 >= 0 && grid[r-1][c] == 1 && distance[r-1][c] > wt + 1){
                distance[r-1][c] = wt + 1;
                queue.add(new int[]{r-1, c, wt+1});
                
            }
            if(c-1 >= 0 && grid[r][c-1] == 1 && distance[r][c-1] > wt + 1){
                distance[r][c-1] = wt + 1;
                queue.add(new int[]{r, c-1, wt+1});
            }
            if(r + 1 < rows && grid[r+1][c] == 1 && distance[r+1][c] > wt + 1){
                distance[r+1][c] = wt + 1;
                queue.add(new int[]{r+1, c, wt+1});
            }
            if(c + 1 < cols && grid[r][c+1] == 1 && distance[r][c+1] > wt + 1){
                distance[r][c+1] = wt + 1;
                queue.add(new int[]{r, c+1, wt+1});
            }
        }
        
        
        return -1;
    }
}