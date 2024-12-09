class DisjointSet{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i); // initially everyone is a parent of himself
            size.add(1);
        }
    }
    
    public int findParent(int i){
        if(i != parent.get(i)){
            parent.set(i, findParent(parent.get(i)));
        }
        
        return parent.get(i);
    }
    
    public void union(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);
        
        if(uParent == vParent) return;
        
        if(size.get(uParent)>=size.get(vParent)){
            parent.set(vParent, uParent);
            size.set(uParent, size.get(uParent) + size.get(vParent));
        }else{
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent) + size.get(vParent));
        }
    }
    
}


public class MaximumConnectedGraph {
    
    // boundry check
    public boolean isValid(int r, int c, int[][] grid){
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        
        if (n == 1) {
        return grid[0][0] == 1 ? 1 : 1; // Either the cell is already `1` or can be flipped
    }
        
        DisjointSet set = new DisjointSet(n*n);
        
        // each for each cell if 1 then check for its neighbours/adjacent (up, down, left right)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int currentNode = i * n + j;
    
                    int[] dr = {-1, 0, 1, 0};
                    int[] dc = {0, -1, 0, 1};
    
                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];
    
                        if (isValid(r, c, grid) && grid[r][c] == 1) { // if 1, then create a union 
                            set.union(currentNode, r * n + c);
                        }
                    }
                }
            }
        }
        
        // check all the remaining nodes (0)
        int maxGroupLength = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    int sum = 0;
                    int currentNode = i * n + j;
                    Set<Integer> visited = new HashSet<>();

                    // check for adjancet node, if 1 , then just make it a one big island
                    int[] dr = {-1, 0, 1, 0};
                    int[] dc = {0, -1, 0, 1};
                    
                     for(int k = 0; k < 4; k++){
                        int r = i + dr[k];
                        int c = j + dc[k];
                        
                        int newNode = r * n + c;
                        
                        if(isValid(r, c, grid) && grid[r][c] == 1){ 
                            int parent = set.findParent(r * n + c);
                            if(!visited.contains(parent)){
                                visited.add(parent);
                                sum += set.size.get(parent);
                            }
                        }
                    }
                    
                    maxGroupLength = Math.max(maxGroupLength, sum + 1);
                }
            }
        }
        
        // if entire grid is already filled with 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    maxGroupLength = Math.max(maxGroupLength, set.size.get(set.findParent( i * n + j)));
                }
            }
        }
        
        return maxGroupLength;
    }
}