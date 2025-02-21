// https://leetcode.com/problems/shortest-path-in-binary-matrix/


class Node{
    int[] pos;
    int dist;

    Node(int[] pos, int dist){
        this.pos = pos;
        this.dist = dist;
    }
}


public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1|| grid[n-1][n-1] == 1) return -1;

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.dist - b.dist);  
        queue.add(new Node(new int[]{0, 0}, 1));


        int[][] distances = new int[n][n];
        for(int[] distance: distances) Arrays.fill(distance, Integer.MAX_VALUE);
        distances[0][0] = 1;

        int[] rCoord = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] cCoord = {0, -1, 0, 1, -1, 1, -1, 1};

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            int currentDist = currentNode.dist;
            int[] currentPos = currentNode.pos;
            int r = currentPos[0];
            int c = currentPos[1];

            
            for(int i=0; i<8; i++){
                int dr = r+rCoord[i];
                int dc = c+cCoord[i];
                    
                    if(validateCoord(dr, dc, n) && grid[dr][dc] == 0){
                        if(distances[dr][dc]>distances[r][c]+1){
                            distances[dr][dc] = distances[r][c]+1;
                            
                            if(dr == n-1 && dc == n-1) return distances[dr][dc];

                            queue.add(new Node(new int[]{dr, dc}, distances[dr][dc]));
                        }
                    }
                }
            }
        }

        return distances[n-1][n-1] == Integer.MAX_VALUE ? -1 : distances[n-1][n-1];
    }


    // without Priority Queue
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1|| grid[n-1][n-1] == 1) return -1;

        Queue<int[]> queue = new LinkedList<>();  
        queue.add(new int[]{0, 0});


        int[][] distances = new int[n][n];
        for(int[] distance: distances) Arrays.fill(distance, Integer.MAX_VALUE);
        distances[0][0] = 1;

        int[] rCoord = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] cCoord = {0, -1, 0, 1, -1, 1, -1, 1};

        while(!queue.isEmpty()){
            int[] currentPos = queue.poll();
            int r = currentPos[0];
            int c = currentPos[1];

            if(r == n-1 && c == n-1) return distances[dr][dc];
            
            for(int i=0; i<8; i++){
            int dr = r+rCoord[i];
            int dc = c+cCoord[i];
                
                if(validateCoord(dr, dc, n) && grid[dr][dc] == 0){
                    if(distances[dr][dc]>distances[r][c]+1){
                        distances[dr][dc] = distances[r][c]+1;

                        queue.add(new int[]{dr, dc});
                    }
                }
                
            }
        }

        return distances[n-1][n-1] == Integer.MAX_VALUE ? -1 : distances[n-1][n-1];
    }


    private boolean validateCoord(int r, int c, int n){
        return r>=0 && c>=0 && r<n && c<n;
    }
}