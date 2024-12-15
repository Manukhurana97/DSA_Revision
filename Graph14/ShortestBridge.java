// https://leetcode.com/problems/shortest-bridge/

class Node{
    int[] coord;
    int l;

    Node(int[] coord, int l){
        this.coord = coord;
        this.l = l;
    }
}


public class ShortestBridge{
	public int shortestBridge(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        // get first island areas
        for(int r=0; r<rows; r++){
            boolean found = false;
            for(int c=0; c<cols; c++){
                if(grid[r][c] == 1){
                    dfs(r, c, grid, queue, visited);
                    found = true;
                    break;
                }
            }
            if(found) break;
        }


        // perform bfs on around first island
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, -1, 0, 1 };

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int[] currentPoint = node.coord;
            int l = node.l;

            for(int i=0; i<4; i++){
                int r = dr[i] + currentPoint[0];
                int c = dc[i] + currentPoint[1];
            

                if (r >= 0 && c >= 0 && r < rows && c < cols && !visited[r][c]) {
                    visited[r][c] = true;
                    if (grid[r][c] == 1) return l;
                    queue.add(new Node(new int[]{r, c}, l+1));
                }
            }

        }
        return -1;
    }

    public void dfs(int r, int c, int[][] grid, Queue<Node> queue, boolean[][] visited){
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] || grid[r][c] == 0) {
            return;
        }
        
        visited[r][c] = true;
        queue.add(new Node(new int[]{r, c}, 0));

        dfs(r-1, c, grid, queue, visited);
        dfs(r, c-1, grid, queue, visited);
        dfs(r+1, c, grid, queue, visited);
        dfs(r, c+1, grid, queue, visited);
    }
}