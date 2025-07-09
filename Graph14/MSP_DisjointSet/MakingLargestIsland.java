// https://leetcode.com/problems/making-a-large-island/

public class DisJointSet{
    int biggestIsland = 1;
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisJointSet(int n){
        for(int i=0;i<n;i++){
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
            biggestIsland = Math.max(biggestIsland, size.get(uParent));
        }else{
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent) + size.get(vParent));
            biggestIsland = Math.max(biggestIsland, size.get(vParent));
        }

    }
}

public class MakingLargestIsland {
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DisJointSet dSet = new DisJointSet(n*n);
        int[] rCoord = {-1, 0, 1, 0};
        int[] cCoord = {0, -1, 0, 1};

        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] == 1){
                    int index = r*n+c;
                     
                    for(int i=0; i<4; i++){
                        int dr = r+rCoord[i];
                        int dc = c+cCoord[i];

                        if(validCoord(dr, dc, n) && grid[dr][dc] == 1){
                            int newIndex = dr*n+dc;
                            dSet.union(index, newIndex);
                        }
                    }
                }
            }
        }


        int biggestIsland = dSet.biggestIsland;
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] == 0){
                    int index = r*n+c;

                    Set<Integer> parent = new HashSet<>(); // since we dont want to make connection of 0 with 1, we will store the parent in this
                    
                    for(int i=0; i<4; i++){
                        int dr = r+rCoord[i];
                        int dc = c+cCoord[i];

                        if(validCoord(dr, dc, n) && grid[dr][dc] == 1){
                            int newIndex = dr*n+dc;
                            
                            parent.add(dSet.findParent(newIndex));
                        }
                    }

                    int sum = 1;
                    for(int i: parent){
                        sum += dSet.size.get(i);
                    }

                    biggestIsland = Math.max(biggestIsland, sum);
                }
            }
        }

        
        return biggestIsland;
    }

    private boolean validCoord(int r, int c, int n){
        return r>=0 && c>=0 && r<n && c<n;
    }
}