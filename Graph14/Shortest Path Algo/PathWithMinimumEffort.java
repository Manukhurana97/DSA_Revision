public class PathWithMinimumEffort{
	// djastra algo
	public static int MinimumEffort(int rows, int cols, int[][] heights) {
        int[][] distance = new int[rows][cols];
        
        for(int r=0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                distance[r][c] = Integer.MAX_VALUE;
            }
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0, 0, 0});
        distance[0][0] = 0;
        
        while(!queue.isEmpty()){
            int[] current  = queue.poll();
            int r = current[0];
            int c = current[1];
            int wt = current[2];
            
            if(r == rows-1 && c == cols - 1) return wt; 
            
            if(r-1>=0){
            	// we are required to max efforts in entire journey
                int effort = Math.max(wt, Math.abs( heights[r][c] - heights[r-1][c]));
                if(distance[r-1][c] > effort){
                    distance[r-1][c] = effort;
                    queue.add(new int[]{r-1, c, effort});
            }}
            if(c-1>=0){
            	// we are required to max efforts in entire journey
                int effort = Math.max(wt, Math.abs( heights[r][c] - heights[r][c-1]));
                if(distance[r][c-1] > effort){
                    distance[r][c-1] = effort;
                    queue.add(new int[]{r, c-1, effort});
            }}
            
            if(r + 1<rows){
            	// we are required to max efforts in entire journey
                int effort = Math.max(wt, Math.abs( heights[r][c] - heights[r+1][c]));
                if(distance[r + 1][c] > effort){
                    distance[r+1][c] = effort;
                    queue.add(new int[]{r + 1, c, effort});
                }
            }
            if(c + 1 < cols){
            	// we are required to max efforts in entire journey
                int effort = Math.max(wt, Math.abs( heights[r][c] - heights[r][c+1]));
                if(distance[r][c + 1] > effort){
                    distance[r][c+1] = effort;
                    queue.add(new int[]{r, c + 1, effort});
                }
                    
            }
        }
        
        
        
        return distance[rows - 1][cols - 1];
    }
}