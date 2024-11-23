public class SurroundedRegion{

	static char[][] fill(int n, int m, char a[][])
    {
        int rows = a.length;
        int cols = a[0].length;
        int[][] visited = new int[rows][cols];

        // get all boundry and adjacent node in row
        for(int r=0;r<rows;r++){
        	if(a[r][0] == 'O' && visited[r][0] == 0){
        		dfs(r, 0, a, visited);
        	}

        	if(a[r][cols - 1] == 'O' && visited[r][cols - 1] == 0){
        		dfs(r, cols - 1, a, visited);
        	}
        }	

        // get all boundry and adjacent node in row
        for(int c=0;c<cols;c++){
        	if(a[0][c] == 'O' && visited[0][c] == 0){
        		dfs(0, c, a, visited);
        	}

        	if(a[rows-1][c] == 'O' && visited[rows - 1][c] == 0){
        		dfs(rows-1, c, a, visited);
        	}
        }

        for(int r = 0; r < rows; r++){
        	for(int c = 0; c < cols; c++){
        		if(a[r][c] == 'O' && visited[r][c] == 0){
        			a[r][c] = 'X';
        		}
        	}
        }

        return a;	
    }

    static void dfs(int r, int c, char[][] grid, int[][] visited){
    	if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 'O' || visited[r][c] == 1) return;


    	visited[r][c] = 1;

    	dfs(r-1, c, grid, visited);
    	dfs(r, c-1, grid, visited);
    	dfs(r+1, c, grid, visited);
    	dfs(r, c + 1, grid, visited);
    }
}