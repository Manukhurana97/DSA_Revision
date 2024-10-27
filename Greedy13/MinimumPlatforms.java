import java.util.*;

class Node{
	int ind;
	int time;
	boolean isArrived;

	Node(int ind, int time, boolean isArrived){
		this.ind = ind;
		this.time = time;
		this.isArrived = isArrived;

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
    	PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.time - b.time);

    	for(int i=0;i<arr.length;i++){
    		queue.add(new Node(i, arr[i], true));
    		queue.add(new Node(i, dep[i], false));
    	}

    	int maxPlatformRequired = 1;
    	int currentTrains = 0;

    	while(!queue.isEmpty()){
    		var currentNode = queue.poll();

    		if(currentNode.isArrived){ 
    			currentTrains++;
    			maxPlatformRequired = Math.max(maxPlatformRequired, currentTrains);
    		}
    		else currentTrains--;

    		
    	}

    	return maxPlatformRequired;
    }

}

// [0900, 0940, 0950, 1100, 1500, 1800], 
// [0910, 1200, 1120, 1130, 1900, 2000]

// 1:0900, 1:0910, 2:0940, 3:0950, 4:1100, 3:1120 4:1130 2:1200 5:1500 6:1800 5:1900 6:2000
// 1:0900, 1:0910
//  2:0940, 3:0950, 4:1100,

