

class DisjointSet{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findParent(int u){
        if(parent.get(u) != u){
            parent.set(u, findParent(parent.get(u)));
        }
        
        return parent.get(u);
    }
    
    public void unionBySize(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);
        
        if(size.get(uParent) > size.get(vParent)){
            parent.set(vParent, uParent);
            size.set(uParent, size.get(uParent) + size.get(vParent));
        }else{
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent) + size.get(vParent));
        }
    }
    
}

public class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet set = new DisjointSet(V);
        
        for(int i = 0; i < V ; i++){
            for(int j = 0; j < V; j++){
                if(adj.get(i).get(j) == 1){
                    set.unionBySize(i, j);
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < V ; i++){
            if(set.parent.get(i) == i){
                count += 1;
            }
        }
        
        
        return count;
    }
};