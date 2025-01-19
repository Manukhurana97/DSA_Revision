// https://leetcode.com/problems/number-of-operations-to-make-network-connected/

class DisjointSet{

    int exitraConnectionCount = 0;
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


    public void unionBySize(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);

        if(uParent == vParent){ 
            exitraConnectionCount+=1;
            return;
        }

        if(size.get(uParent) > size.get(vParent)){
            parent.set(vParent, uParent);
            size.set(uParent, size.get(uParent) + size.get(vParent));
        }else{
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent) + size.get(vParent));
        }
    }
}

public class NumberOfOperationToMakeNodeConnected{
	public int makeConnected(int n, int[][] connections) {
        DisjointSet dSet = new DisjointSet(n);


        for(int[] connection: connections){
            dSet.unionBySize(connection[0], connection[1]);
        }

        int distinctComponents = 0;
        for (int i = 0; i < n; i++) {
            if (dSet.findParent(i) == i) {
                distinctComponents++;
            }
        }

       return distinctComponents-1 > dSet.exitraConnectionCount ? -1 : distinctComponents-1;
    }
}