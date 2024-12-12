// https://leetcode.com/problems/count-sub-islands/

public class CountSubIslands{
	public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int count = 0;
        int[][] visited = new int[grid1.length][grid1[0].length];

        for(int r = 0; r<grid2.length; r++){
            for(int c=0; c<grid2[r].length; c++){
                if(grid2[r][c] == 1 && visited[r][c] == 0){
                    if(dfs(r, c, grid1, grid2 , visited)){
                        count += 1;
                    }
                }
            }
        }

        return count;
    }


    // we have to check in all the nodes that why we us use isSubIsland to keep track of all nodes
    public boolean dfs(int r, int c, int[][] grid1, int[][] grid2, int[][] visited){

        if(r < 0 || c < 0 || r >= grid1.length || c >= grid1[0].length || visited[r][c] == 1 || grid2[r][c] == 0) return true;

        visited[r][c] = 1;  
        
        boolean isSubIsland = grid1[r][c] == 1;      

        isSubIsland &= dfs(r+1, c, grid1, grid2, visited);
        isSubIsland &= dfs(r-1, c, grid1, grid2, visited);
        isSubIsland &= dfs(r, c+1, grid1, grid2, visited);
        isSubIsland &= dfs(r, c-1, grid1, grid2, visited);

        return isSubIsland;

    }
}