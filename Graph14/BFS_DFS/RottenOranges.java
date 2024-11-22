public class RottenOranges{
	public int orangesRotting(int[][] grid) {

        int oneCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                if(grid[r][c] == 2){
                    queue.add(new int[]{r, c});
                }
                if(grid[r][c] == 1){
                    oneCount += 1;
                }
            }
        }

        int time = 0;
        while(!queue.isEmpty()){

            int size = queue.size();

            for( int i=0;i<size;i++){
                var current = queue.poll();
                var r = current[0];
                var c = current[1];


                if(r - 1 >=0 && grid[r-1][c] == 1){ 
                    grid[r-1][c] = 2;
                    queue.add(new int[]{r-1, c});
                    oneCount-=1;
                }
                if(c - 1 >=0 && grid[r][c - 1] == 1){ 
                    grid[r][c-1] = 2;
                    queue.add(new int[]{r, c - 1});
                    oneCount-=1;
                }
                if(r + 1 < grid.length && grid[r+1][c] == 1){ 
                    grid[r+1][c] = 2;
                    queue.add(new int[]{r+1, c});
                    oneCount-=1;
                }
                if(c + 1 < grid[0].length && grid[r][c+1] == 1){ 
                    grid[r][c+1] = 2;
                    queue.add(new int[]{r, c+1});
                    oneCount-=1;
                }
            }
            if(!queue.isEmpty()){
                time += 1;
            }
        }

        

        return oneCount != 0 ? -1: time;
    }
}