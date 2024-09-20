class Node{
    int row;
    int col;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}

// using bfs
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Node> q1 = new LinkedList<>();  
        Queue<Node> q2 = new LinkedList<>();  
        int n = grid.length, m = grid[0].length; 

        // get all the orange which are rotted initially
        for(int r = 0; r < n; r++)
            for(int c=0; c < m; c++)
                if(grid[r][c] == 2) q1.add(new Node(r, c));
                

        int time = 0;
        while(!q1.isEmpty()){

            var node = q1.poll();
            int r = node.row;
            int c = node.col;

            if(r-1 >= 0 && grid[r - 1][c] == 1){
                grid[r-1][c] = 2;
                q2.add(new Node(r-1, c));
            }
            if(c-1 >= 0 && grid[r][c - 1] == 1){
                grid[r][c-1] = 2;
                q2.add(new Node(r, c-1));
            }
            if(r+1 <n && grid[r + 1][c] == 1){
                grid[r+1][c] = 2;
                q2.add(new Node(r+1, c));
            }
            if(c+1<m && grid[r][c+1] == 1){
                grid[r][c+1] = 2;
                q2.add(new Node(r, c+1));
            }
            

            if(q1.isEmpty() && !q2.isEmpty()){
                q1.addAll(q2);
                q2.clear();
                time += 1;
            }
        }
       

        for(int r = 0; r < n; r++)
            for(int c=0; c < m; c++)
                if(grid[r][c] == 1)
                    return -1;
        
        return  time;
    }


// 
    public int orangesRotting(int[][] grid) {
        Queue<Node> q1 = new LinkedList<>();  
        int n = grid.length, m = grid[0].length; 

        // get all the orange which are rotted initially
        for(int r = 0; r < n; r++)
            for(int c=0; c < m; c++)
                if(grid[r][c] == 2) q1.add(new Node(r, c));
                

        int time = 0;
        int size = q1.size();
        while(size > 0){

            var node = q1.poll();
            int r = node.row;
            int c = node.col;

            if(r-1 >= 0 && grid[r - 1][c] == 1){
                grid[r-1][c] = 2;
                q1.add(new Node(r-1, c));
            }
            if(c-1 >= 0 && grid[r][c - 1] == 1){
                grid[r][c-1] = 2;
                q1.add(new Node(r, c-1));
            }
            if(r+1 <n && grid[r + 1][c] == 1){
                grid[r+1][c] = 2;
                q1.add(new Node(r+1, c));
            }
            if(c+1<m && grid[r][c+1] == 1){
                grid[r][c+1] = 2;
                q1.add(new Node(r, c+1));
            }
            

            if(--size == 0 && !q1.isEmpty()){
                size = q1.size();
                time += 1;
            }
        }
       

        for(int r = 0; r < n; r++)
            for(int c=0; c < m; c++)
                if(grid[r][c] == 1)
                    return -1;
        
        return  time;
    }
}