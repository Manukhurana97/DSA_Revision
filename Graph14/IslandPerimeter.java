public class IslandPerimeter{
	public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        int count = 0;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c] == 1 && visited[r][c] == 0){
                    count += bfs(r, c, grid, visited);
                    break;
                }
            }
        }

        return count;
    }

    public int bfs(int r, int c, int[][] grid, int[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        visited[r][c] = 1;
        int count = 0;

        while(!queue.isEmpty()){
            int[] currentNode = queue.poll();
            int cr = currentNode[0];
            int cc = currentNode[1];
            count += 4;

            if(cr - 1 >= 0 && grid[cr - 1][cc] == 1){
                count -= 1;
                if(visited[cr-1][cc] == 0){
                    visited[cr-1][cc] = 1;
                    queue.add(new int[]{cr - 1, cc});}
            }
            if(cc - 1 >= 0 && grid[cr][cc - 1] == 1){
                count -= 1;
                if(visited[cr][cc - 1] == 0){
                    visited[cr][cc-1] = 1;
                    queue.add(new int[]{cr, cc - 1});}
            }

            if(cr+1<grid.length && grid[cr+1][cc] == 1){
                count -= 1;
                if(visited[cr+1][cc] == 0){
                    visited[cr+1][cc] = 1;
                    queue.add(new int[]{cr+1, cc});
                }
            }
            if(cc+1<grid[cr].length && grid[cr][cc+1] == 1){
                count -= 1;
                if(visited[cr][cc+1] == 0){
                    visited[cr][cc+1] = 1;
                    queue.add(new int[]{cr, cc+1});
                }
            }
        }

        return count;
    }
}