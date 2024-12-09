class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i);
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
        
        if(size.get(uParent) >= size.get(vParent)){
            parent.set(vParent, uParent);
            size.set(uParent, size.get(uParent) + size.get(vParent));
        }else{
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent) + size.get(vParent));
        }
    }
}

public class NumberOfIsLands2 {
    
    public boolean isValid(int r, int c, int rows, int cols){
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet set = new DisjointSet(rows * cols);
        int[][] visited = new int[rows][cols];
        List<Integer> result = new ArrayList<>();
        int count = 0;
        
        // for each element 
        for (int i = 0; i < operators.length; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            
            // if already visited
            if(visited[row][col] == 1){
                result.add(count); // just add in result and continue
                continue;
            }
            
            // increment the number of islands 
            count +=1;
            visited[row][col] = 1;
            int currIndex = row * cols + col;
            
            // check in delta row and col if already visited
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, -1, 0, 1};
            
            for(int j=0;j<4;j++){
                int newRow = row + dr[j];
                int newCol = col + dc[j];
                
                if(isValid(newRow, newCol, rows, cols) && visited[newRow][newCol] == 1){ // valid and is neighbour available 
                    int adjIndex = newRow * cols + newCol; // delta index
                    
                    if(set.findParent(currIndex) != set.findParent(adjIndex)){ // if different parent
                        count -=1; // connect the islands 
                        set.union(currIndex, adjIndex); // mark parent of both as same 
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
}