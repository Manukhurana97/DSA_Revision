public class MaximumMultiplicationToReachEnd{

	/* Using BFS */ 
	int minimumMultiplications(int[] arr, int start, int end) {

        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            if(current[0] == end) return current[1];
            
            for(int i: arr){
                int val = (i * current[0]) % 100000;
                
                if(!visited.contains(val)){
                    queue.add(new int[]{val, current[1]+1});
                    visited.add(val);
                }
            }
        }
        
        
        return -1;
        
    }

    // ------------------------------------------------------------------------
    /* Using Dijkstra algo*/ 


	int minimumMultiplications(int[] arr, int start, int end) {

        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            if(current[0] == end) return current[1];
            
            for(int i: arr){
                int val = (i * current[0]) % 100000;
                
                if(dist[val] > current[1] +  1){
                    queue.add(new int[]{val, current[1]+1});
                    dist[val] = current[1]  +  1;
                }
            }
        }
        
        
        return -1;
        
    }
}