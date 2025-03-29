// https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

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



    // -------------------------------------------------------------



    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1|| grid[n-1][n-1] == 1) return -1;

        Queue<int[]> queue = new LinkedList<>();  
        queue.add(new int[]{0, 0});


        int[][] distances = new int[n][n];
        for(int[] distance: distances) Arrays.fill(distance, Integer.MAX_VALUE);
        distances[0][0] = 1;

        int[] rCoord = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] cCoord = {0, -1, 0, 1, -1, 1, -1, 1};

        while(!queue.isEmpty()){
            int[] currentPos = queue.poll();
            int r = currentPos[0];
            int c = currentPos[1];

            if(r == n-1 && c == n-1) return distances[r][c];
            
            for(int i=0; i<8; i++){
            int dr = r+rCoord[i];
            int dc = c+cCoord[i];
                
                if(validateCoord(dr, dc, n) && grid[dr][dc] == 0){
                    if(distances[dr][dc]>distances[r][c]+1){
                        distances[dr][dc] = distances[r][c]+1;

                        queue.add(new int[]{dr, dc});
                    }
                }
                
            }
        }

        return distances[n-1][n-1] == Integer.MAX_VALUE ? -1 : distances[n-1][n-1];
    }


    private boolean validateCoord(int r, int c, int n){
        return r>=0 && c>=0 && r<n && c<n;
    }
}