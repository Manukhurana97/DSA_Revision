class DisJointSet{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    DisJointSet(int n){
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
        
        if(size.get(uParent) > size.get(vParent)){
            parent.set(vParent, uParent);
            size.set(uParent, size.get(uParent) + size.get(vParent));
        }else{
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent) + size.get(vParent));
        }
    }
}


public class MostStonesRemovedFromSameRowAndColumn {

    int maxRemove(int[][] stones, int n) {
        int maxRow = 0;
        int maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(stone[0], maxRow);
            maxCol = Math.max(stone[1], maxCol);
        }
        
        // create a connected component 
         // Initialize DisJointSet with enough capacity
        DisJointSet set = new DisJointSet(maxRow + maxCol + 2);
        Map<Integer, Integer> stoneNodes = new HashMap<>();
        
        for(int[] stone: stones){
            int r = stone[0];
            int c = stone[1] + maxRow + 1;
            
            set.union(r, c);
            stoneNodes.put(r, 1);
            stoneNodes.put(c, 1);
        }
        
        // for all parent 
        // Count distinct connected components
        int count = 0;
        for (Map.Entry<Integer, Integer> k_v : stoneNodes.entrySet()) {
            // Check if the current node is a root
            if (set.findParent(k_v.getKey()) == k_v.getKey()) {
                count++;
            }
        }
        
        
        return n - count; 
        
    }
};