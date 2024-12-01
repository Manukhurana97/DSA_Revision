public class FloydWarshallAlgo{
	public void shortestDistance(int[][] mat) {
        int n = mat.length;
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(mat[r][c] == -1) 
                    mat[r][c] = Integer.MAX_VALUE; // Treat -1 as Infinity
                if(r == c) 
                    mat[r][c] = 0;
            }
        }
         
        // Floyd-Warshall algorithm
        // its a find of brute force, from a to b , it will go via a->0  and then 0 -> b
        for(int via = 0; via < n; via++){
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    if(mat[r][via] != Integer.MAX_VALUE && mat[via][c] != Integer.MAX_VALUE) // if can be reachable the update the value
                        mat[r][c] = Math.min(mat[r][c], mat[r][via] + mat[via][c]);

                }
            }
        }
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(mat[r][c] == Integer.MAX_VALUE) // convert Infinity back to -1
                    mat[r][c] = -1;
            }
        }
    }
}