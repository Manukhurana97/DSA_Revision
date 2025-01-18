// https://leetcode.com/problems/01-matrix/

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(mat[r][c] == 0){
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        bfs(queue, mat, visited);

        return mat;
    }

    private void bfs(Queue<int[]> queue, int[][] matrix, boolean[][] visited){

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0], c = current[1];

            if(r-1>=0 && !visited[r-1][c]){
                visited[r-1][c] = true;
                matrix[r-1][c] = matrix[r][c]+1;
                queue.add(new int[]{r-1, c});
            }
            
            if(c-1>=0 && !visited[r][c-1]){
                visited[r][c-1] = true;
                matrix[r][c-1] = matrix[r][c]+1;
                queue.add(new int[]{r, c-1});
            }


            if(r+1<matrix.length && !visited[r+1][c]){
                visited[r+1][c] = true;
                matrix[r+1][c] = matrix[r][c]+1;
                queue.add(new int[]{r+1, c});
            }
            
            if(c+1<matrix[r].length && !visited[r][c+1]){
                visited[r][c+1] = true;
                matrix[r][c+1] = matrix[r][c]+1;
                queue.add(new int[]{r, c+1});
            }
        }
    }


    // --------------------------------------------------------------------


    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(mat[r][c] == 0){
                    queue.add(new int[]{r, c});
                }else {
                    mat[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        bfs(queue, mat);

        return mat;
    }

    private void bfs(Queue<int[]> queue, int[][] matrix){

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0], c = current[1];

            if(r-1>=0 && matrix[r-1][c]>matrix[r][c]+1){
                matrix[r-1][c] = matrix[r][c]+1;
                queue.add(new int[]{r-1, c});
            }
            
            if(c-1>=0 && matrix[r][c-1]>matrix[r][c]+1){
                matrix[r][c-1] = matrix[r][c]+1;
                queue.add(new int[]{r, c-1});
            }


            if(r+1<matrix.length && matrix[r+1][c]>matrix[r][c]+1){
                matrix[r+1][c] = matrix[r][c]+1;
                queue.add(new int[]{r+1, c});
            }
            
            if(c+1<matrix[r].length && matrix[r][c+1]>matrix[r][c]+1){
                matrix[r][c+1] = matrix[r][c]+1;
                queue.add(new int[]{r, c+1});
            }
        }
    }
}