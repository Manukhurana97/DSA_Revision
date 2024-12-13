public class SwimInRisingWater{
    public int swimInWater(int[][] grid) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]); 
        queue.add(new int[]{0, 0, grid[0][0]});

        int rows = grid.length;
        int cols = grid[0].length;
        int maxheight = 0;

        int[][] visited = new int[rows][cols];
        visited[0][0] = 1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            maxheight = Math.max(maxheight, grid[r][c]);

            if(r == rows - 1 && c == cols-1) return maxheight;


            if(r-1>=0 && visited[r-1][c] == 0){
                visited[r-1][c] = 1;
                queue.add(new int[]{r-1, c, grid[r - 1][c]});
            }
            if(c-1>=0 && visited[r][c-1] == 0){
                visited[r][c-1] = 1;
                queue.add(new int[]{r, c-1, grid[r][c - 1]});
            }
            if(r+1<rows && visited[r+1][c] == 0){
                visited[r+1][c] = 1;
                queue.add(new int[]{r+1, c, grid[r + 1][c]});
            }
            if(c+1<cols && visited[r][c+1] == 0){
                visited[r][c+1] = 1;
                queue.add(new int[]{r, c+1, grid[r][c + 1]});
            }
        }
        
        return maxheight;
    }
}