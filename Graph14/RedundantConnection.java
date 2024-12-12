// https://leetcode.com/problems/redundant-connection/

class DisJointSet{

    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisJointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node != parent.get(node)){
            parent.set(node, findParent(parent.get(node)));
        }

        return parent.get(node);
    }

    public void union(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);

        if(uParent == vParent) return;

        if(size.get(uParent)>size.get(vParent)){
            parent.set(vParent, uParent);
            size.set(uParent, size.get(uParent) + size.get(vParent));
        }else{
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent) + size.get(vParent));
        }
    }
    
}

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        
        DisJointSet dSet = new DisJointSet(edges.length + 1);
        int[] result = new int[2];

        for(int[] edge: edges){
            int uParent = dSet.findParent(edge[0]);
            int vParent = dSet.findParent(edge[1]);

            if(uParent == vParent){
                result = new int[]{edge[0], edge[1]};
            }else{
                dSet.union(edge[0], edge[1]);
            }
        }

        return result;

    }
}
