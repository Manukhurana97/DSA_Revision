import java.util.*;

class Node{
	int ind;
	int time;

	Node(int ind, int time){
		this.ind = ind;
		this.time = time;
	}
}

public class MinimumPlatforms{

	static int findPlatform(int arr[], int dep[]) {
        int noOfPlatform = 1;
        
        for(int i=0;i<arr.length;i++){
            int platformRequired = 1;
            int start = arr[i];
            int end = dep[i];
            
            for(int j=i+1; j<arr.length;j++){
                
                if(arr[j] < start && dep[j] > end) platformRequired += 1;
                else if(arr[j] > start && dep[j] < end) platformRequired += 1;
                else if(arr[j] < start && dep[j] > start && dep[j] < end) platformRequired += 1;
                else if(arr[j] > start && arr[j] < end && dep[j] > end) platformRequired += 1;
            }
            noOfPlatform = Math.max(noOfPlatform, platformRequired);
        }
        
        return noOfPlatform;
    }	


    static int findPlatform1(int arr[], int dep[]) {
    	Map<Integer, Node> map = new HashMap<>();
    	PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.time - b.time);

    	for(int i=0;i<arr.length;i++){
    		queue.add(new Node(i, arr[i]));
    		queue.add(new Node(i, arr[i]));
    	}

    	int maxPlatformRequired = 1;

    	while(!queue.isEmpty()){
    		var currentNode = queue.poll();

    		if(map.containsKeys(currentNode.ind)){
    			map.remove(currentNode.ind);
    		}else{
    			map.put(i, currentNode);
    		}

    		maxPlatformRequired = Math.max(maxPlatformRequired, map.size());
    	}

    	return maxPlatformRequired;
    }

}

// [0900, 0940, 0950, 1100, 1500, 1800], 
// [0910, 1200, 1120, 1130, 1900, 2000]

