class DisjointSet{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    int noOfExtraNodes = 0;
    
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
    
    public void unionBySize(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);
        
        if(uParent == vParent){ // if same parent then nodes are already conected previously
            noOfExtraNodes +=1; // extra node
            return;
        };
        if(size.get(uParent) > size.get(vParent)){
            parent.set(vParent, uParent);
            size.set(uParent, size.get(uParent) + size.get(vParent));
        }else{
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent) + size.get(vParent));
        }
    }
}

public class NumberOfConnections {

    public int Solve(int n, int[][] edges) {
        DisjointSet set = new DisjointSet(n);

        // create connections
        for(int[] edge: edges){
            set.unionBySize(edge[0], edge[1]);
        }
        
        // no of graphs
       int count = 0;
        for (int i = 0; i < n; i++) {
            if (set.findParent(i) == i) {
                count++;
            }
        }
        
        if (set.noOfExtraNodes >= count - 1) {
            return count - 1;
        }
        
        return -1;
        
    }
}